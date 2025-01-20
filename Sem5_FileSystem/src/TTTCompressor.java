import java.io.FileOutputStream;
import java.io.IOException;

public class TTTCompressor {
    public static void main(String[] args) {
        // Исходный массив значений поля
        int[] field = {1, 2, 0, 1, 2, 3, 0, 1, 2};

        try {
            // Записываем массив в файл в сжатом виде
            writeCompressedFieldToFile(field, "src/field.dat");
            System.out.println("Поле успешно записано в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void writeCompressedFieldToFile(int[] field, String fileName) throws IOException {
        if (field.length != 9) {
            throw new IllegalArgumentException("Поле должно содержать ровно 9 значений.");
        }

        // Упаковываем данные в одно 32-битное число
        int packedField = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i] < 0 || field[i] > 3) {
                throw new IllegalArgumentException("Значения поля должны быть в диапазоне от 0 до 3.");
            }
            packedField |= (field[i] << (i * 2));
        }

        // Преобразуем packedField в массив байтов (3 байта)
        byte[] compressed = new byte[3];
        compressed[0] = (byte) (packedField & 0xFF);        // Младший байт
        compressed[1] = (byte) ((packedField >> 8) & 0xFF); // Средний байт
        compressed[2] = (byte) ((packedField >> 16) & 0xFF); // Старший байт

        // Записываем байты в файл
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(compressed);
        }
    }
}
