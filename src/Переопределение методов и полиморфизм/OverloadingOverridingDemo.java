// Практика #1: Пример перегруженных методов
class Calculator {

    // Перегруженные методы - одинаковое имя, разные параметры

    // 1. Сложение двух целых чисел
    public int add(int a, int b) {
        System.out.println("add(int, int): " + a + " + " + b);
        return a + b;
    }

    // 2. Сложение трех целых чисел
    public int add(int a, int b, int c) {
        System.out.println("add(int, int, int): " + a + " + " + b + " + " + c);
        return a + b + c;
    }

    // 3. Сложение чисел с плавающей точкой
    public double add(double a, double b) {
        System.out.println("add(double, double): " + a + " + " + b);
        return a + b;
    }

    // 4. Сложение массива чисел
    public int add(int... numbers) {
        System.out.print("add(int...): ");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            System.out.print(num + " ");
        }
        System.out.println();
        return sum;
    }

    // 5. Конкатенация строк
    public String add(String a, String b) {
        System.out.println("add(String, String): \"" + a + "\" + \"" + b + "\"");
        return a + b;
    }
}

// Практика #2: Пример переопределенных методов
class Animals {
    protected String name;

    public Animals(String name) {
        this.name = name;
    }

    // Метод, который будет переопределен
    public String makeSound() {
        return name + " издает звук";
    }

    public void move() {
        System.out.println(name + " двигается");
    }

    // Метод для демонстрации возвращаемого значения
    public Animals getChild() {
        return new Animals("Детеныш " + name);
    }
}

class Dogs extends Animals {
    private String breed;

    public Dogs(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    // Переопределение метода makeSound()
    @Override
    public String makeSound() {
        return name + " (" + breed + ") лает: Гав-гав!";
    }

    // Ковариантный возвращаемый тип
    @Override
    public Dogs getChild() {
        return new Dogs("Щенок " + name, breed);
    }
}

class Cat extends Animals {
    public Cat(String name) {
        super(name);
    }

    // Переопределение метода makeSound()
    @Override
    public String makeSound() {
        return name + " мяукает: Мяу-мяу!";
    }
}

// Практика #3: Пример использования @Override для обнаружения ошибок
class BaseClasss {

    public void correctMethod() {
        System.out.println("Правильный метод в BaseClass");
    }

    public void methodWithParam(int x) {
        System.out.println("Method with param: " + x);
    }

    public String getName() {
        return "BaseClass";
    }
}

class DerivedClasss extends BaseClasss {

    // Правильное переопределение
    @Override
    public void correctMethod() {
        System.out.println("Переопределенный метод в DerivedClass");
    }

}

// Дополнительный пример для демонстрации ковариантности
class Fruit {
    public Fruit getFruit() {
        return new Fruit();
    }

    public void describe() {
        System.out.println("Просто фрукт");
    }
}

class Apple extends Fruit {
    // Ковариантный возвращаемый тип - допустимо!
    @Override
    public Apple getFruit() {
        return new Apple();
    }

    @Override
    public void describe() {
        System.out.println("Сочное яблоко");
    }
}

// Главный класс для демонстрации
public class OverloadingOverridingDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Перегруженные методы ===");
        demonstrateOverloading();

        System.out.println("\n=== ПРАКТИКА #2: Переопределенные методы ===");
        demonstrateOverriding();

        System.out.println("\n=== ПРАКТИКА #3: Аннотация @Override ===");
        demonstrateOverrideAnnotation();

        System.out.println("\n=== Дополнительно: Полиморфизм ===");
        demonstratePolymorphism();
    }

    public static void demonstrateOverloading() {
        Calculator calc = new Calculator();

        // Вызов разных перегруженных методов
        System.out.println("Результат: " + calc.add(5, 3));
        System.out.println("Результат: " + calc.add(2, 4, 6));
        System.out.println("Результат: " + calc.add(2.5, 3.7));
        System.out.println("Результат: " + calc.add(1, 2, 3, 4, 5));
        System.out.println("Результат: " + calc.add("Hello, ", "World!"));

        // Автоматическое преобразование типов
        System.out.println("\nАвтоматическое преобразование типов:");
        System.out.println("Результат: " + calc.add(5, 3.5)); // int + double → double
    }

    public static void demonstrateOverriding() {
        Animals animal = new Animals("Неизвестное животное");
        Dogs dog = new Dogs("Бобик", "Овчарка");
        Cat cat = new Cat("Мурка");

        // Демонстрация переопределенных методов
        System.out.println(animal.makeSound());
        System.out.println(dog.makeSound());
        System.out.println(cat.makeSound());

        // Демонстрация ковариантных возвращаемых типов
        System.out.println("\nКовариантные возвращаемые типы:");
        Animals animalChild = animal.getChild();
        Dogs dogChild = dog.getChild(); // Возвращает Dog, а не Animal

        animalChild.move();
        dogChild.makeSound(); // У собаки есть специфичные методы

        // ОШИБКА: если бы возвращаемый тип не совпадал
        System.out.println("\nЧто происходит при несовпадении возвращаемых типов:");
        System.out.println("""
            Если у переопределенного метода другой возвращаемый тип,
            который не является подтипом исходного, то:
            - Компилятор выдаст ошибку
            - Программа не скомпилируется
            """);
    }

    public static void demonstrateOverrideAnnotation() {
        BaseClasss base = new BaseClasss();
        DerivedClasss derived = new DerivedClasss();

        base.correctMethod();
        derived.correctMethod();

        System.out.println("\nПреимущества @Override:");
        System.out.println("""
            1. Обнаружение опечаток в имени метода
            2. Проверка соответствия сигнатуры метода
            3. Проверка, что метод действительно переопределяет метод суперкласса
            4. Улучшение читаемости кода
            5. Защита от случайных ошибок при изменении суперкласса
            """);

        // Пример, когда @Override помогает при рефакторинге
        System.out.println("Пример защиты при рефакторинге:");
        System.out.println("""
            Если в BaseClass изменить сигнатуру methodWithParam(int) на methodWithParam(String),
            то метод в DerivedClass с аннотацией @Override перестанет компилироваться,
            что укажет на необходимость обновления.
            """);
    }

    public static void demonstratePolymorphism() {
        System.out.println("Демонстрация полиморфизма (динамического связывания):");

        // Массив родительского типа, содержащий объекты разных подклассов
        Animals[] animals = {
                new Animals("Просто животное"),
                new Dogs("Рекс", "Дворняжка"),
                new Cat("Васька"),
                new Dogs("Лорд", "Бульдог")
        };

        // Полиморфный вызов - метод выбирается во время выполнения
        for (Animals animal : animals) {
            System.out.println(animal.makeSound()); // Динамическое связывание
        }

        System.out.println("\nБез полиморфизма (статические вызовы):");
        for (Animals animal : animals) {
            if (animal instanceof Dogs) {
                System.out.println(((Dogs) animal).makeSound());
            } else if (animal instanceof Cat) {
                System.out.println(((Cat) animal).makeSound());
            } else {
                System.out.println(animal.makeSound());
            }
        }
    }
}

// Дополнительный пример: Ошибки, которые обнаруживает @Override
class ErrorExamples {

    static class Parent {
        public void doSomething(int value) {
            System.out.println("Parent: " + value);
        }

        public String getValue() {
            return "parent";
        }
    }

    static class Child extends Parent {

        public void doSomething(String value) { // Должен быть int, а не String
            System.out.println("Child: " + value);
        }


    }
}