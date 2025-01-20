import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class BackupCreator {

    public static void createBackup(String sourceDirectoryPath) {
        // Путь к папке backup
        String backupDirectoryPath = sourceDirectoryPath + File.separator + "backup";

        // Создаем объект для исходной директории
        File sourceDirectory = new File(sourceDirectoryPath);

        // Проверяем, существует ли исходная директория и является ли она папкой
        if (!sourceDirectory.exists() || !sourceDirectory.isDirectory()) {
            System.err.println("Ошибка: Указанная директория не существует или не является папкой.");
            return;
        }

        // Создаем папку backup, если она не существует
        File backupDirectory = new File(backupDirectoryPath);
        if (!backupDirectory.exists()) {
            if (backupDirectory.mkdir()) {
                System.out.println("Папка backup успешно создана: " + backupDirectoryPath);
            } else {
                System.err.println("Ошибка: Не удалось создать папку backup.");
                return;
            }
        }

        // Копируем файлы из исходной директории в папку backup
        File[] files = sourceDirectory.listFiles((dir, name) -> new File(dir, name).isFile());
        if (files != null) {
            for (File file : files) {
                Path sourcePath = file.toPath();
                Path destinationPath = Paths.get(backupDirectoryPath, file.getName());
                try {
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Файл скопирован: " + file.getName());
                } catch (IOException e) {
                    System.err.println("Ошибка при копировании файла: " + file.getName());
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Нет файлов для копирования в директории: " + sourceDirectoryPath);
        }
    }

    public static void main(String[] args) {
        String sourceDirectoryPath = "Sem5_FileSystem/Files";

        createBackup(sourceDirectoryPath);
    }
}
