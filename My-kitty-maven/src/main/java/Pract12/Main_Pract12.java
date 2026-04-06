package Pract12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static Pract12.InboxArchiver.archiveTmpFiles;
import static Pract12.PathSafety.safeResolve;
import static Pract12.PaymentReportWriter.writeReport;
import static Pract12.StatusFile.readStatus;
import static Pract12.StatusFile.updateStatus;

public class Main_Pract12 {
    public static void main(String[] args) throws IOException {
        Path testFile = Files.createTempFile("payments", ".csv");
        String csvContent = """
                id,email,status,amountCents
                1,user1@mail.com,PAID,1500
                2,user2@mail.com,NEW,2000
                
                3,bad-email.com,UNKNOWN_STATUS,500
                4,user4@mail.com,FAILED,not_a_number
                5,user5@mail.com,PAID,9900
                """;

        Files.writeString(testFile, csvContent, StandardCharsets.UTF_8);
        LoadResult result = PaymentLoader.loadWithStats(testFile);
        System.out.println("=== Результати обробки CSV Завд 1===");
        System.out.println("Успішно завантажено (валідні платежі): " + result.payments().size());
        System.out.println("Відкинуто (невалідні рядки): " + result.invalidLines());
        System.out.println("\nВалідні платежі:");
        for (Payment p : result.payments()) {
            System.out.println(p);
        }
        Files.deleteIfExists(testFile);
        System.out.println();



        List<Payment> testPayments = List.of(
                new Payment("1", "user1@mail.com", PaymentStatus.PAID, 1500),
                new Payment("2", "user2@mail.com", PaymentStatus.NEW, 2000),
                new Payment("5", "user5@mail.com", PaymentStatus.PAID, 9900),
                new Payment("6", "user6@mail.com", PaymentStatus.FAILED, 500)
        );
        Path reportPath = Path.of("payment_report.txt");
        try {
            System.out.println("Генеруємо звіт...Завд 2");
            writeReport(reportPath, testPayments, 2);
            System.out.println("Звіт успішно збережено у файл: " + reportPath.toAbsolutePath());
            System.out.println("\n--- Вміст файлу ---");
            Files.readAllLines(reportPath).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Помилка запису файлу: " + e.getMessage());
        } finally {
            try { Files.deleteIfExists(reportPath); } catch (IOException ignored) {}
        }
        System.out.println();


        Path inboxDir = Path.of("practical-data/inbox");
        Path archiveDir = Path.of("practical-data/archive");
        try {
            Files.createDirectories(inboxDir);
            Files.writeString(inboxDir.resolve("data1.txt"), "Текстовий файл 1");
            Files.writeString(inboxDir.resolve("temp1.tmp"), "Тимчасовий файл 1");
            Files.writeString(inboxDir.resolve("temp2.tmp"), "Тимчасовий файл 2");
            Files.writeString(inboxDir.resolve("data2.txt"), "Текстовий файл 2");
            System.out.println("--- Тестові файли створено Завд 3---");
            archiveTmpFiles(inboxDir, archiveDir);
        } catch (IOException e) {
            System.err.println("Помилка підготовки тесту: " + e.getMessage());
        }
        System.out.println();



        Path baseDir = Paths.get("my_app/workdir");

        System.out.println("Базова директорія: " + baseDir.toAbsolutePath().normalize());
        System.out.println("================== Завд 4 =======================");


        System.out.println("Тест 1: reports/2025.txt");
        try {
            Path safePath = safeResolve(baseDir, "reports/2025.txt");
            System.out.println("[УСПІХ] Дозволено доступ до: " + safePath);
        } catch (IllegalArgumentException e) {
            System.err.println("[ВІДМОВА] " + e.getMessage());
        }
        System.out.println("\n-----------------------------------------");
        System.out.println("Тест 2: ../secret.txt");
        try {
            Path unsafePath = safeResolve(baseDir, "../secret.txt");
            System.out.println("[УСПІХ] Дозволено доступ до: " + unsafePath);
        } catch (IllegalArgumentException e) {
            System.err.println("[ВІДМОВА ЗАХИСТОМ] " + e.getMessage());
        }


        Path statusFile = Path.of("status.bin");
        int N = 10;

        try {
            Files.write(statusFile, new byte[N]);
            System.out.println("Файл створено.(Завд 5) Розмір: " + Files.size(statusFile) + " байт.");
            int targetIndex = 4;
            byte newStatus = 7;
            System.out.println("Записуємо статус [" + newStatus + "] на індекс [" + targetIndex + "]...");
            updateStatus(statusFile, targetIndex, newStatus);
            byte readBack = readStatus(statusFile, targetIndex);
            System.out.println("Зчитано статус: [" + readBack + "]");
            if (newStatus == readBack) {
                System.out.println("УСПІХ! Байт успішно оновлено на місці.");
            }
        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        } finally {
            try { Files.deleteIfExists(statusFile); } catch (IOException ignored) {}
        }

    }
}

