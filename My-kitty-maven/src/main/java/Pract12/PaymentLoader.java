package Pract12;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaymentLoader {
    public static LoadResult loadWithStats(Path csvPath) {
        List<Payment> payments = new ArrayList<>();
        int invalidLines = 0;
        try (BufferedReader reader = Files.newBufferedReader(csvPath, StandardCharsets.UTF_8)) {
            String header = reader.readLine();
            if (header == null) {
                return new LoadResult(payments, 0); // Файл порожній
            }
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    invalidLines++;
                    continue;
                }

                try {
                    Payment payment = parsePayment(line);
                    payments.add(payment);
                } catch (Exception e) {
                    invalidLines++;
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }
        return new LoadResult(payments, invalidLines);
    }
    private static Payment parsePayment(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Невірна кількість колонок");
        }
        String id = parts[0].trim();
        String email = parts[1].trim();
        PaymentStatus status = PaymentStatus.valueOf(parts[2].trim().toUpperCase());
        long amountCents = Long.parseLong(parts[3].trim());

        return new Payment(id, email, status, amountCents);
    }
}

