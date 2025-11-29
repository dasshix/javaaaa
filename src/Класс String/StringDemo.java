import java.util.StringJoiner;

public class StringDemo {
    public static void main(String[] args) {
        String text = "  Java ПрОГрАмМиРоВаНие!  ";

        System.out.println("Исходная строка: '" + text + "'");
        System.out.println("Длина: " + text.length()); // 1. length() - возвращает длину строки

        // ПРАКТИКА #1: 10 методов класса String
        System.out.println("\n=== ПРАКТИКА #1: Методы класса String ===");

        // 2. charAt(int index) - символ по индексу
        System.out.println("Символ на позиции 3: '" + text.charAt(3) + "'");

        // 3. substring(int begin, int end) - подстрока
        System.out.println("Подстрока (5-12): '" + text.substring(5, 12) + "'");

        // 4. toLowerCase() / toUpperCase() - регистр
        System.out.println("В нижний регистр: '" + text.toLowerCase() + "'");
        System.out.println("В верхний регистр: '" + text.toUpperCase() + "'");

        // 5. trim() - убрать пробелы
        System.out.println("После trim(): '" + text.trim() + "'");

        // 6. replace(char old, char new) - замена символа
        System.out.println("Замена 'а' на '@': '" + text.replace('а', '@') + "'");

        // 7. indexOf(String str) - первый индекс подстроки
        System.out.println("Индекс 'Пр': " + text.indexOf("Пр"));

        // 8. lastIndexOf(char ch) - последний индекс символа
        System.out.println("Последний пробел: " + text.lastIndexOf(' '));

        // 9. startsWith() / endsWith() - начало/конец
        System.out.println("Начинается с '  J': " + text.startsWith("  J"));
        System.out.println("Заканчивается на '!  ': " + text.endsWith("!  "));

        // 10. split(String regex) - разделить по разделителю
        String[] words = text.trim().split("\\s+");
        System.out.println("Слова: " + java.util.Arrays.toString(words));

        System.out.println("\n=== ПРАКТИКА #2: StringJoiner ===");
        // ПРАКТИКА #2: StringJoiner
        StringJoiner joiner1 = new StringJoiner(", ", "[", "]"); // разделитель + префикс + суффикс
        joiner1.add("Java").add("C#").add("Python");
        System.out.println("StringJoiner: " + joiner1);

        StringJoiner joiner2 = new StringJoiner(" | ");
        joiner2.add("Имя").add("Возраст").add("Город");
        System.out.println("Простой разделитель: " + joiner2);

        // String.join() - удобный статический метод
        String[] cities = {"Москва", "СПб", "Казань"};
        System.out.println("String.join: " + String.join(" → ", cities));

        System.out.println("\n=== ПРАКТИКА #3: Тройные кавычки (Text Blocks) ===");
        // ПРАКТИКА #3: """ - Text Blocks (Java 15+)
        String html = """
            <html>
                <head>
                    <title>Пример страницы</title>
                </head>
                <body>
                    <h1>Заголовок</h1>
                    <p>Многострочный HTML без \n и конкатенации!</p>
                </body>
            </html>
            """;
        System.out.println("Text Block (HTML):");
        System.out.println(html);

        String sql = """
            SELECT name, age, city
            FROM users
            WHERE age > 18
            ORDER BY name
            """;
        System.out.println("\nSQL запрос:");
        System.out.println(sql);
    }
}
