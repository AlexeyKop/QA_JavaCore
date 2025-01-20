import java.io.FileInputStream;
import java.io.IOException;

public class TTTDecompressor {
    public static void main(String[] args) {
        try {
            // Читаем данные из файла и декодируем
            int[] field = readCompressedFieldFromFile("Sem5_FileSystem/src/field.dat");
            System.out.println("Поле успешно прочитано из файла:");
            for (int cell : field) {
                System.out.print(cell + " ");
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла: " + e.getMessage());
        }
    }

    public static int[] readCompressedFieldFromFile(String fileName) throws IOException {
        // Читаем три байта из файла
        byte[] compressed = new byte[3];
        try (FileInputStream fis = new FileInputStream(fileName)) {
            if (fis.read(compressed) != 3) {
                throw new IOException("Файл должен содержать ровно 3 байта.");
            }
        }

        // Восстанавливаем packedField из байтов
        int packedField = (compressed[0] & 0xFF) | 
                          ((compressed[1] & 0xFF) << 8) | 
                          ((compressed[2] & 0xFF) << 16);

        // Декодируем массив значений поля
        int[] field = new int[9];
        for (int i = 0; i < field.length; i++) {
            field[i] = (packedField >> (i * 2)) & 0b11; // Извлекаем 2 бита на каждую ячейку
        }

        return field;
    }
}
