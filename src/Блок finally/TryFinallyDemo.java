public class TryFinallyDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: try БЕЗ catch и finally ===");
        testTryOnly();

        System.out.println("\n=== ПРАКТИКА #2: try ТОЛЬКО С finally ===");
        testTryFinally();

        System.out.println("\n=== ПРАКТИКА #3: try С ДВУМЯ finally ===");
        testDoubleFinally();
    }

    // ПРАКТИКА #1: try БЕЗ catch и finally
    static void testTryOnly() {
        // ОШИБКА КОМПИЛЯЦИИ!
        /*
        try {
            System.out.println("Код в try");
            int x = 10 / 0;  // ArithmeticException
        }
        // ОШИБКА: 'try' without 'catch', 'finally' or resource declarations
        */
        System.out.println(" НЕВОЗМОЖНО! Требуется catch или finally");
    }

    // ПРАКТИКА #2: try ТОЛЬКО С finally (Java 7+)
    static void testTryFinally() {
        System.out.println("  ВОЗМОЖНО!");
        try {
            System.out.println("    Код в try");
            int x = 10 / 0;  // ArithmeticException выбросится
            System.out.println("    Этот код НЕ выполнится");
        } finally {
            System.out.println("    finally ВСЕГДА выполняется!");
        }
        // Программа завершится аварийно после finally
    }

    // ПРАКТИКА #3: try С ДВУМЯ finally
    static void testDoubleFinally() {

        System.out.println("НЕВОЗМОЖНО! Только 1 finally");
    }
}
