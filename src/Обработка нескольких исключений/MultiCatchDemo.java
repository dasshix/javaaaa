// Собственные исключения для демонстрации иерархии
class BaseException extends Exception {
    public BaseException(String message) {
        super("BaseException: " + message);
    }
}

class MiddleException extends BaseException {
    public MiddleException(String message) {
        super(message);
    }
}

class ChildException extends MiddleException {
    public ChildException(String message) {
        super("ChildException: " + message);
    }
}

public class MultiCatchDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Несколько исключений ===");

        // Ситуация 1: ИДЕНТИЧНАЯ обработка НЕСВЯЗАННЫХ исключений
        System.out.println("\n1. ИДЕНТИЧНАЯ обработка (multi-catch):");
        try {
            riskyOperation1();
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("  ✓ Multi-catch: " + e.getClass().getSimpleName());
            System.out.println("     Обработано идентично: " + e.getMessage());
        }

        // Ситуация 2: Иерархия исключений Ex1 <|-- Ex2 <|-- Ex3
        System.out.println("\n2. ИЕРАРХИЯ исключений (от ребенка к родителю):");
        demonstrateHierarchy();

        System.out.println("\n=== ПРАКТИКА #2: final в catch ===");
        demonstrateFinal();
    }

    // Ситуация 1: Рискованная операция генерирует разные исключения
    static void riskyOperation1() {
        int[] arr = {1, 2, 3};
        System.out.println("  Деление на 0...");
        int x = 10 / 0;  // ArithmeticException

        System.out.println("  arr[5]...");
        int y = arr[5];  // ArrayIndexOutOfBoundsException (НЕ ДОЙДЕТ)
    }

    // Ситуация 2: Демонстрация иерархии исключений
    static void demonstrateHierarchy() {
        try {
            System.out.println("  Генерация ChildException...");
            throw new ChildException("Ошибка ребенка");  // Child < Middle < Base
        } catch (ChildException e) {
            System.out.println("  ✓ catch ChildException: " + e.getMessage());
        } catch (MiddleException e) {
            System.out.println("  ✓ catch MiddleException: " + e.getMessage());
        } catch (BaseException e) {
            System.out.println("  ✓ catch BaseException: " + e.getMessage());
        }
        System.out.println("  ✓ Все уровни иерархии обработаны!");
    }

    // ПРАКТИКА #2: final Exception
    static void demonstrateFinal() {
        try {
            riskyOperationWithFinal();
        } catch (final Exception e) {  // final - параметр НЕИЗМЕНЯЕМЫЙ!
            System.out.println("  final Exception поймано: " + e.getClass().getSimpleName());

            // e = new RuntimeException();  // ОШИБКА! final нельзя переприсваивать
            System.out.println("  final e.hashCode(): " + e.hashCode());
            System.out.println("  final НЕ позволяет: e = new Exception()");
        }

    }

    static void riskyOperationWithFinal() throws ChildException {
        throw new ChildException("final демонстрация");
    }
}
