/**
 * Демонстрация всех операторов Java (Практика #1) и instanceof (Практика #2).
 * Показывает приоритет операторов и работу с базовыми типами, String, null.
 */
public class Operators {
    /**
     * Основной метод с примерами всех операторов.
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // ПРАКТИКА #1: Базовые типы
        int a = 10, b = 3;

        // Присваивание (низший приоритет)
        int x = a;        // =
        x += b;           // +=
        x -= b;           // -=
        x *= b;           // *=
        x /= b;           // /=
        x %= b;           // %=

        // Тернарный ?:
        int max = (a > b) ? a : b;

        // Логические
        boolean p = true, q = false;
        boolean r = p || q;  // ||
        r = p && q;          // &&
        r = p | q;           // |
        r = p ^ q;           // ^
        r = p & q;           // &

        // Сравнение
        boolean eq = a == b; // ==
        boolean ne = a != b; // !=

        // Сдвиги
        int s1 = a >> 1;    // >>
        int s2 = a >>> 1;   // >>>
        int s3 = a << 1;    // <<

        // Арифметика
        int sum = a + b;    // +
        int diff = a - b;   // -
        int mul = a * b;    // *
        int div = a / b;    // /
        int mod = a % b;    // %

        // Унарные (высший приоритет)
        int preInc = ++a;   // ++ префикс
        int postInc = b++;  // ++ постфикс
        int preDec = --a;   // -- префикс
        int postDec = b--;  // -- постфикс
        int bitwiseNot = ~a; // ~
        boolean logicNot = !p; // !

        // String конкатенация (+ и +=)
        String s = "Hello";
        String t = "World";
        String hello = s + t;           // +
        s += " " + t + "!";             // +=

        // Вывод базовых типов
        System.out.println("=== ПРАКТИКА #1: БАЗОВЫЕ ТИПЫ ===");
        System.out.println("= : " + x);
        System.out.println("?: " + max);
        System.out.println("||: " + (p || q));
        System.out.println("&&: " + (p && q));
        System.out.println("+: " + sum + ", -: " + diff);
        System.out.println("++ префикс: " + preInc + ", постфикс: " + postInc);
        System.out.println("String +: " + hello + ", +=: " + s);

        // ПРАКТИКА #2: instanceof
        System.out.println("\n=== ПРАКТИКА #2: INSTANCEOF ===");
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal nullAnimal = null;

        System.out.println("dog instanceof Animal: " + (dog instanceof Animal));     // true
        System.out.println("dog instanceof Dog: " + (dog instanceof Dog));           // true
        System.out.println("cat instanceof Dog: " + (cat instanceof Dog));           // false
        System.out.println("null instanceof Animal: " + (nullAnimal instanceof Animal)); // false
    }

    // Классы для instanceof
    static class Animal {}
    static class Dog extends Animal {}
    static class Cat extends Animal {}
}
