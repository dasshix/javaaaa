public class ExceptionPropagationDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРОГРАММА ЗАПУЩЕНА ===");

        try {
            System.out.println("\n1. ПЕРЕХВАЧЕННОЕ исключение (ArrayIndexOutOfBoundsException):");
            handledException();
            System.out.println("✓ Этот блок выполнился после обработки!");

            System.out.println("\n2. НЕПЕРЕХВАЧЕННОЕ исключение (ArithmeticException):");
            unhandledException();  // АВАРИЙНАЯ ОСТАНОВКА ЗДЕСЬ!

        } catch (Exception e) {
            System.out.println("В main поймано: " + e.getClass().getSimpleName());
        }

        System.out.println("=== ПРОГРАММА ЗАВЕРШЕНА НОРМАЛЬНО ===");
    }

    // ПРАКТИКА #1: Метод с ПЕРЕХВАЧЕННЫМ исключением
    static void handledException() {
        System.out.println("  Вызов handledException()");

        int[] numbers = {1, 2, 3};

        try {
            System.out.println("    Попытка доступа к numbers[10]...");
            int value = numbers[10];  // ArrayIndexOutOfBoundsException
            System.out.println("    Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("    ✓ В handledException() ПЕРЕХВАЧЕНО:");
            System.out.println("      Тип: " + e.getClass().getSimpleName());
            System.out.println("      Сообщение: " + e.getMessage());
            System.out.println("      Размер массива: " + numbers.length);
            // Программа ПРОДОЛЖАЕТСЯ!
        }

        System.out.println("  handledException() завершен успешно");
    }

    // Метод с НЕПЕРЕХВАЧЕННЫМ исключением (throws НЕ используется)
    static void unhandledException() {
        System.out.println("  Вызов unhandledException()");
        System.out.println("    Попытка деления на 0...");

        int result = 10 / 0;  // ArithmeticException - НЕ ПЕРЕХВАЧЕНО!
        System.out.println("    Результат: " + result);

        // ЭТОТ КОД НЕ ВЫПОЛНИТСЯ
        System.out.println("    unhandledException() завершен");
    }

    // Дополнительно: метод с throws (перекладывает ответственность)
    static void methodWithThrows() throws ArithmeticException {
        System.out.println("\nДополнительно: метод с throws");
        int result = 5 / 0;  // Выбросит исключение ВВЕРХ
    }
}
