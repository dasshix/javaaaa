/**
 * Демонстрация всех способов вызова статического метода printVars().
 */
public class A {
    public static int a = 1;
    public static int b = 99; // инициализируем для наглядности

    /**
     * Статический метод - принадлежит классу A.
     */
    public static void printVars() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    /**
     * Нестатический метод тоже может вызывать статический.
     */
    public void instanceMethod() {
        printVars(); // Вариант 1: через this (неявно)
    }

    public static void main(String[] args) {
        // ПРАКТИКА #1: Все варианты вызова printVars()
        System.out.println("=== Все способы вызова printVars() ===");

        // 1. Через имя класса (рекомендуемый)
        A.printVars();

        // 2. Через объект (компилятор сам найдет статический метод)
        A obj1 = new A();
        obj1.printVars();

        // 3. Через другой объект того же класса
        A obj2 = new A();
        obj2.printVars();

        // 4. Из нестатического метода (через this)
        obj1.instanceMethod();

        // 5. Короткая запись (если в том же классе)
        printVars(); // прямо в main()

        System.out.println("\nИзменяем статическое поле:");
        A.a = 100; // видно всем объектам

        A.printVars(); // a теперь 100
    }
}

