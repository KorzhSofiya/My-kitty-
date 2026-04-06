package Pract12;

import java.io.IOException;
import java.nio.file.*;

public class InboxArchiver {
    public static void archiveTmpFiles(Path inbox, Path archive) {
        try {
            if (!Files.exists(archive)) {
                Files.createDirectories(archive);
                System.out.println("Створено директорію: " + archive.toAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Не вдалося створити директорію архіву: " + e.getMessage());
            return;
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(inbox, "*.tmp")) {
            int movedCount = 0;
            for (Path file : stream) {
                Path targetPath = archive.resolve(file.getFileName());
                Files.move(file, targetPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Переміщено: " + file.getFileName());
                movedCount++;
            }
            System.out.println("Архівацію завершено. Переміщено файлів: " + movedCount);

        } catch (IOException | DirectoryIteratorException e) {
            System.err.println("Помилка під час архівації файлів: " + e.getMessage());
        }

    }
}
