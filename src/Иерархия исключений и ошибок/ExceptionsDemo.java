public class ExceptionsDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Иерархия исключений ===");
        explainHierarchy();

        System.out.println("\n=== ПРАКТИКА #2: Демонстрация исключений ===");

        // 1. ArithmeticException
        demonstrateArithmeticException();

        // 2. ArrayIndexOutOfBoundsException
        demonstrateArrayIndexOutOfBounds();

        // 3. IllegalArgumentException
        demonstrateIllegalArgument();

        // 4. ClassCastException
        demonstrateClassCast();

        // 5. NullPointerException
        demonstrateNullPointer();
    }

    // ПРАКТИКА #1: Объяснение классов исключений
    static void explainHierarchy() {
        System.out.println("Иерархия исключений:");
        System.out.println("java.lang.Object");
        System.out.println("   └── java.lang.Throwable");
        System.out.println("        ├── java.lang.Error (критические ошибки JVM)");
        System.out.println("        │    • OutOfMemoryError - нет памяти");
        System.out.println("        │    • StackOverflowError - переполнение стека");
        System.out.println("        └── java.lang.Exception (обрабатываемые ошибки)");
        System.out.println("             ├── Проверяемые (checked)");
        System.out.println("             │    • IOException");
        System.out.println("             │    • SQLException");
        System.out.println("             └── Непроверяемые (unchecked) RuntimeException");
        System.out.println("                  • ArithmeticException");
        System.out.println("                  • NullPointerException");
        System.out.println("                  • ArrayIndexOutOfBoundsException");
    }

    // 1. ArithmeticException - деление на ноль
    static void demonstrateArithmeticException() {
        System.out.println("\n1. ArithmeticException (деление на 0):");
        try {
            int result = 10 / 0;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("✓ Поймано: " + e.getClass().getSimpleName());
            System.out.println("  Сообщение: " + e.getMessage());
        }
    }

    // 2. ArrayIndexOutOfBoundsException - выход за границы массива
    static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\n2. ArrayIndexOutOfBoundsException:");
        int[] numbers = {1, 2, 3, 4, 5};
        try {
            System.out.println("Элемент с индексом 10: " + numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✓ Поймано: " + e.getClass().getSimpleName());
            System.out.println("  Размер массива: " + numbers.length);
            System.out.println("  Попытка доступа: " + e.getMessage());
        }
    }

    // 3. IllegalArgumentException - некорректный аргумент
    static void demonstrateIllegalArgument() {
        System.out.println("\n3. IllegalArgumentException:");
        try {
            calculateDiscount(-50);  // Отрицательная сумма
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Поймано: " + e.getClass().getSimpleName());
            System.out.println("  Причина: " + e.getMessage());
        }
    }

    // Генерация IllegalArgumentException
    static double calculateDiscount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма не может быть отрицательной: " + amount);
        }
        return amount * 0.9;
    }

    // 4. ClassCastException - неверное приведение типов
    static void demonstrateClassCast() {
        System.out.println("\n4. ClassCastException:");
        Object obj = "Это строка";
        try {
            Integer number = (Integer) obj;  // Попытка привести String к Integer
            System.out.println("Число: " + number);
        } catch (ClassCastException e) {
            System.out.println("✓ Поймано: " + e.getClass().getSimpleName());
            System.out.println("  Нельзя привести " + obj.getClass().getSimpleName() +
                    " к " + Integer.class.getSimpleName());
        }
    }

    // 5. NullPointerException - обращение к null
    static void demonstrateNullPointer() {
        System.out.println("\n5. NullPointerException:");
        String text = null;
        try {
            int length = text.length();  // Обращение к методу null-объекта
            System.out.println("Длина: " + length);
        } catch (NullPointerException e) {
            System.out.println("✓ Поймано: " + e.getClass().getSimpleName());
            System.out.println("  Пытались вызвать метод на null: " + e.getMessage());
        }
    }
}
