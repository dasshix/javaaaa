import java.util.Formatter;
import java.time.LocalDateTime;

public class FormatterDemo {
    public static void main(String[] args) {
        // ПРАКТИКА #1: 5 спецификаторов форматирования
        System.out.println("=== ПРАКТИКА #1: Спецификаторы форматирования ===");

        String name = "Алексей";
        int age = 28;
        double salary = 125000.75;
        boolean isActive = true;
        char grade = 'A';

        // 1. %s - строковое представление
        System.out.printf("1. %%s (строка): Имя сотрудника: %s%n", name);

        // 2. %d - десятичное целое
        System.out.printf("2. %%d (целое): Возраст: %d лет%n", age);

        // 3. %f - число с плавающей точкой
        System.out.printf("3. %%f (дробное): Зарплата: %.2f руб.%n", salary);

        // 4. %b - логическое значение
        System.out.printf("4. %%b (логическое): Статус: %b%n", isActive);

        // 5. %c - символ
        System.out.printf("5. %%c (символ): Оценка: %c%n", grade);

        // ПРАКТИКА #2: flush()
        System.out.println("\n=== ПРАКТИКА #2: Метод flush() ===");
        demonstrateFlush();

        // ПРАКТИКА #3: 5 спецификаторов даты/времени
        System.out.println("\n=== ПРАКТИКА #3: Форматирование даты/времени ===");
        LocalDateTime now = LocalDateTime.now();

        // 1. %tY - год (4 цифры)
        System.out.printf("1. %%tY: Год: %tY%n", now);

        // 2. %tH:%tM:%tS - время
        System.out.printf("2. %%tH:%%tM:%%tS: Время: %tH:%tM:%tS%n", now);

        // 3. %tB - полное название месяца
        System.out.printf("3. %%tB: Месяц: %tB%n", now);

        // 4. %tA - день недели
        System.out.printf("4. %%tA: День недели: %tA%n", now);

        // 5. %tm/%td - месяц/день
        System.out.printf("5. %%tm/%%td: Дата: %tm/%td/%tY%n", now);

        // Полный формат даты
        System.out.printf("\nПолный формат: %1$tA, %1$tB %1$td, %1$tY %1$tH:%1$tM:%1$tS%n", now);
    }

    // ПРАКТИКА #2: Демонстрация flush()
    static void demonstrateFlush() {
        try (Formatter formatter = new Formatter()) {
            // Записываем в буфер, но НЕ выводим сразу
            formatter.format("Данные в буфере: %s%n", "НЕ ВЫВЕДЕНО");

            System.out.println("До flush(): буфер заполнен, но не выведен");

            // flush() - принудительно вывести содержимое буфера
            formatter.flush();
            System.out.println("После flush(): данные выведены!");

            // Теперь выводим вторую строку
            formatter.format("Вторая строка: выведена сразу%n");
            formatter.flush();  // Гарантированный вывод

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

