import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Чтение файла с помощью Scanner ===");

        // Создаем тестовый файл программно
        createTestFile();

        // Читаем файл разными способами
        readFileLineByLine();
        readFileWords();
        readFileNumbers();
        readEntireFile();
    }

    // Создание тестового файла data.txt
    static void createTestFile() {
        try {
            java.nio.file.Files.writeString(
                    java.nio.file.Paths.get("data.txt"),
                    "Иван\n25\nМосква\n3.14\nАнна\n30\nСПб\n2.71\nКонец файла"
            );
            System.out.println("✓ Тестовый файл 'data.txt' создан");
        } catch (Exception e) {
            System.out.println("Ошибка создания файла: " + e.getMessage());
        }
    }

    // Способ 1: Чтение ПО СТРОКАМ (nextLine())
    static void readFileLineByLine() {
        System.out.println("\n1. Чтение ПО СТРОКАМ (nextLine()):");
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            int lineNum = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.printf("Строка %d: '%s'%n", lineNum++, line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    // Способ 2: Чтение СЛОВ (next())
    static void readFileWords() {
        System.out.println("\n2. Чтение СЛОВ (next()):");
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                System.out.println("Слово: '" + word + "'");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    // Способ 3: Чтение ЧИСЕЛ (nextInt(), nextDouble())
    static void readFileNumbers() {
        System.out.println("\n3. Чтение ЧИСЕЛ:");
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            while (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    System.out.println("Целое: " + num);
                } else if (scanner.hasNextDouble()) {
                    double num = scanner.nextDouble();
                    System.out.println("Дробное: " + num);
                } else {
                    scanner.nextLine();  // Пропустить не-число
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения чисел: " + e.getMessage());
        }
    }

    // Способ 4: Чтение ВСЕГО файла (useDelimiter("\\Z"))
    static void readEntireFile() {
        System.out.println("\n4. Чтение ВСЕГО файла:");
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            String content = scanner.useDelimiter("\\Z").next();
            System.out.println("Полный текст:");
            System.out.println(content);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}
