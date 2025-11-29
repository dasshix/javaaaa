public class P {
    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i);
    }

    public void printNum(int i) {
        System.out.printf("int = %d%n", i);
    }

    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f);
    }

    public void printNum(Number n) {
        System.out.println("Number=" + n);
    }

    public static void main(String[] args) {
        P a = new P();
        Number[] num = {new Integer(1), 11, 1.11f, 11.11};

        // Цикл for (1)
        System.out.println("=== Цикл for-each (1) ===");
        for (Number n : num) {
            a.printNum(n);  // ВСЕгда Number!
        }

        // Прямые вызовы (2)
        System.out.println("\n=== Прямые вызовы (2) ===");
        a.printNum(new Integer(1));  // Integer
        a.printNum(11);              // int
        a.printNum(1.11f);           // Float
        a.printNum(11.11);           // double → Number (нет double метода!)
    }
}
