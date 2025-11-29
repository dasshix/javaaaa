import java.io.*;

public class StreamsDemo {
    public static void main(String[] args) {
        // ПРАКТИКА #1: InputStream.read()
        System.out.println("=== ПРАКТИКА #1: FileInputStream.read() ===");
        demoInputStreamRead();

        // ПРАКТИКА #2: OutputStream.write()
        System.out.println("\n=== ПРАКТИКА #2: FileOutputStream.write() ===");
        demoOutputStreamWrite();

        // ПРАКТИКА #3: Reader vs InputStream
        System.out.println("\n=== ПРАКТИКА #3: Reader vs InputStream ===");
        demoReaderVsStream();

        // ПРАКТИКА #4: AutoCloseable
        System.out.println("\n=== ПРАКТИКА #4: AutoCloseable ===");
        demoAutoCloseable();
    }

    // ПРАКТИКА #1: FileInputStream.read()
    static void demoInputStreamRead() {
        try (FileInputStream fis = new FileInputStream("input.txt")) {
            System.out.println("Чтение байтов из файла:");
            int data;
            int count = 0;

            // read() возвращает int (0-255) или -1 (конец файла)
            while ((data = fis.read()) != -1) {
                System.out.printf("Байт #%d: %d (char: '%c')%n",
                        ++count, data, (char) data);
            }
            System.out.println("Всего байтов: " + count);

        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    // ПРАКТИКА #2: FileOutputStream.write(int)
    static void demoOutputStreamWrite() {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String message = "Hello, Java Streams!";

            System.out.println("Запись байтов в файл:");
            for (int i = 0; i < message.length(); i++) {
                int byteValue = (int) message.charAt(i);  // Unicode → byte
                fos.write(byteValue);  // write(int) принимает 0-255
                System.out.printf("Записан байт: %d ('%c')%n", byteValue, message.charAt(i));
            }
            System.out.println("✓ Файл 'output.txt' создан!");

        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }

    // ПРАКТИКА #3: Reader vs InputStream
    static void demoReaderVsStream() {
        System.out.println("InputStream (байты) → для БИНАРНЫХ данных:");
        System.out.println("- Изображения (jpg, png)");
        System.out.println("- Архивы (zip)");
        System.out.println("- Сетевые протоколы");

        System.out.println("\nReader (символы) → для ТЕКСТА:");
        System.out.println("- Файлы .txt, .csv, .json");
        System.out.println("- Автоматическое определение кодировки");
        System.out.println("- Unicode поддержка");
    }

    // ПРАКТИКА #4: AutoCloseable + try-with-resources
    static void demoAutoCloseable() {
        System.out.println("Без AutoCloseable (Java 6):");
        // Ручное закрытие - легко забыть!
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("input.txt");
            // работа...
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nС AutoCloseable (Java 7+):");
        // Автоматическое закрытие!
        try (FileInputStream fis2 = new FileInputStream("input.txt");
             BufferedInputStream bis = new BufferedInputStream(fis2)) {
            // работа...
            System.out.println("✓ Автоматически закрываются ВСЕ потоки!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
