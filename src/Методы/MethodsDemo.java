/**
 * Демонстрация перегрузки (overloading) и переопределения (overriding) методов.
 */
public class MethodsDemo {

    // ПЕРЕГРУЗКА (overloading) - разные параметры в одном классе
    public void print(int num) {
        System.out.println("int: " + num);
    }

    public void print(double num) {
        System.out.println("double: " + num);
    }

    public void print(String text) {
        System.out.println("String: " + text);
    }

    public void print(int a, int b) {
        System.out.println("int x int: " + (a + b));
    }

    public static void main(String[] args) {
        MethodsDemo demo = new MethodsDemo();

        // Перегрузка работает по типам и количеству параметров
        demo.print(42);           // int
        demo.print(3.14);         // double
        demo.print("Hello");      // String
        demo.print(5, 7);         // два int

        Animal animal = new Dog();
        animal.makeSound();       // Dog sound (переопределение!)

        System.out.println("\n=== Перегрузка конструкторов ===");
        // Конструкторы тоже перегружаются
        new Box(10);
        new Box(20, 30);
    }
}

// ПЕРЕОПРЕДЕЛЕНИЕ (overriding) - в подклассе
class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override  // Аннотация переопределения
    public void makeSound() {
        System.out.println("Dog: Woof!");
    }
}

// Перегрузка конструкторов
class Box {
    int width, height;

    public Box(int size) {
        width = height = size;
        System.out.println("Квадрат: " + size);
    }

    public Box(int w, int h) {
        width = w;
        height = h;
        System.out.println("Прямоугольник: " + w + "x" + h);
    }
}
