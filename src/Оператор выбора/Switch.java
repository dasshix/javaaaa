public class Switch {
    /**
     * Показывает все возможные типы switch и fall-through.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // ПРАКТИКА #1: Все возможные типы switch

        // 1. byte, short, int, char (и их wrapper'ы)
        byte b = 1;
        switch (b) {
            case 1: System.out.println("byte: " + b); break;
            default: break;
        }

        short s = 2;
        switch (s) {
            case 2: System.out.println("short: " + s); break;
            default: break;
        }

        int i = 3;
        switch (i) {
            case 3: System.out.println("int: " + i); break;
            default: break;
        }

        char c = 'A';
        switch (c) {
            case 'A': System.out.println("char: " + c); break;
            default: break;
        }

        // 2. String (Java 7+)
        String str = "Hello";
        switch (str) {
            case "Hello": System.out.println("String: " + str); break;
            default: break;
        }

        // 3. enum
        Day day = Day.MONDAY;
        switch (day) {
            case MONDAY: System.out.println("enum: " + day); break;
            default: break;
        }

        // ПРАКТИКА #2: Fall-through (отсутствие break)
        System.out.println("\n=== ПРАКТИКА #2: Fall-through (без break) ===");
        int value = 2;
        int result = 0;
        switch (value) {
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                // Нет break - fall-through!
            case 3:
                result = 3;  // Выполнится для value=2!
                break;
            default:
                result = 99;
        }
        System.out.println("value=2 → result=" + result); // Выведет 3!
    }

    // enum для switch
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY
    }
}
