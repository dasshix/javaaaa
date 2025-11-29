// Практика #1 и #2 - Демонстрация ключевого слова super
class Vehicle {
    protected String brand = "Unknown Brand";
    protected int maxSpeed = 100;

    // Конструктор суперкласса
    public Vehicle() {
        System.out.println("Vehicle constructor: Creating a vehicle");
    }

    public Vehicle(String brand) {
        this.brand = brand;
        System.out.println("Vehicle constructor: Creating " + brand);
    }

    public void startEngine() {
        System.out.println("Vehicle: Engine started");
    }

    public void displayInfo() {
        System.out.println("Vehicle: Brand=" + brand + ", MaxSpeed=" + maxSpeed);
    }
}

class Car extends Vehicle {
    protected int doors;
    protected String brand = "Car Brand"; // Переопределение поля

    // 1. Обращение к конструктору суперкласса
    public Car() {
        super(); // Вызов конструктора Vehicle()
        System.out.println("Car constructor: Creating a car");
    }

    public Car(String brand, int doors) {
        super(brand); // Вызов конструктора Vehicle(String brand)
        this.doors = doors;
        System.out.println("Car constructor: Creating " + brand + " with " + doors + " doors");
    }

    @Override
    public void startEngine() {
        System.out.println("Car: Engine started with key");
    }

    public void showDetails() {
        // 2. Доступ к полю суперкласса
        System.out.println("Vehicle brand: " + super.brand); // Доступ к полю Vehicle
        System.out.println("Car brand: " + this.brand); // Доступ к полю Car

        // 3. Доступ к методу суперкласса
        super.displayInfo(); // Вызов метода Vehicle
        System.out.println("Car: Doors=" + doors);
    }
}

class SportsCar extends Car {
    private boolean turboMode;

    public SportsCar(String brand, int doors, boolean turbo) {
        super(brand, doors); // Вызов конструктора Car
        this.turboMode = turbo;
        System.out.println("SportsCar constructor: Creating sports car with turbo=" + turbo);
    }

    @Override
    public void startEngine() {
        // Вызов метода суперкласса
        super.startEngine(); // Вызов метода Car.startEngine()
        if (turboMode) {
            System.out.println("SportsCar: Turbo mode activated!");
        }
    }

    public void showAllInfo() {
        // Доступ к полям через цепочку super
        System.out.println("Accessing through super chain:");
        System.out.println("From Vehicle: " + super.brand); // Будет "Car Brand"
        super.showDetails(); // Вызов метода Car.showDetails()
    }
}

// Практика #2 - Ответ на вопрос
class BaseClass {
    int value = 10;

    void display() {
        System.out.println("BaseClass display: value = " + value);
    }
}

class MiddleClass extends BaseClass {
    // Не переопределяем value и display
}

class DerivedClass extends MiddleClass {
    void display() {
        // super.value и super.display() будут ссылаться на BaseClass
        // даже через MiddleClass, потому что MiddleClass их не переопределяет
        int val = super.value; // Получаем value из BaseClass
        super.display(); // Вызываем display из BaseClass
        System.out.println("DerivedClass: Accessed value from BaseClass = " + val);
    }
}

// Практика #3 - Переписывание с использованием this()
class Configuration {
    int width;
    int height;
    int depth;
    int defaultSetting;

    // Конструктор по умолчанию
    public Configuration() {
        this(0, 0, 0); // Вызов конструктора с тремя параметрами
    }

    // Конструктор с одним параметром
    public Configuration(int width) {
        this(width, 0, 0); // Вызов конструктора с тремя параметрами
    }

    // Конструктор с двумя параметрами
    public Configuration(int width, int height) {
        this(width, height, 0); // Вызов конструктора с тремя параметрами
    }

    // Основной конструктор с тремя параметрами
    public Configuration(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.defaultSetting = 1; // Общая инициализация
        System.out.println("Created configuration: " + width + "x" + height + "x" + depth);
    }

    public void display() {
        System.out.println("Configuration: " + width + "x" + height + "x" + depth +
                ", setting=" + defaultSetting);
    }
}

// Главный класс для демонстрации
public class SuperThisDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Демонстрация super ===");

        System.out.println("\n1. Создание обычного автомобиля:");
        Car car = new Car("Toyota", 4);
        car.showDetails();

        System.out.println("\n2. Создание спортивного автомобиля:");
        SportsCar sportsCar = new SportsCar("Ferrari", 2, true);
        sportsCar.startEngine();
        sportsCar.showAllInfo();

        System.out.println("\n=== ПРАКТИКА #2: Наследование через промежуточный класс ===");
        DerivedClass derived = new DerivedClass();
        derived.display();

        System.out.println("\n=== ПРАКТИКА #3: Использование this() ===");
        Configuration config1 = new Configuration();
        Configuration config2 = new Configuration(100);
        Configuration config3 = new Configuration(100, 200);
        Configuration config4 = new Configuration(100, 200, 300);

        config1.display();
        config2.display();
        config3.display();
        config4.display();

        System.out.println("\n=== Дополнительная демонстрация цепочки super ===");
        demonstrateSuperChain();
    }

    public static void demonstrateSuperChain() {
        System.out.println("\nДемонстрация цепочки вызовов:");

        class Level1 {
            String data = "Level1 data";

            Level1() {
                System.out.println("Level1 constructor");
            }

            void show() {
                System.out.println("Level1 show: " + data);
            }
        }

        class Level2 extends Level1 {
            String data = "Level2 data";

            Level2() {
                System.out.println("Level2 constructor");
            }

            @Override
            void show() {
                System.out.println("Level2 show: " + data);
                super.show(); // Вызов метода Level1
            }

            void showAll() {
                System.out.println("Level2 data: " + this.data);
                System.out.println("Level1 data: " + super.data);
            }
        }

        class Level3 extends Level2 {
            String data = "Level3 data";

            Level3() {
                System.out.println("Level3 constructor");
            }

            @Override
            void show() {
                System.out.println("Level3 show: " + data);
                super.show(); // Вызов метода Level2
            }

            void showHierarchy() {
                System.out.println("\nData hierarchy:");
                System.out.println("Level3: " + this.data);
                System.out.println("Level2: " + super.data);
                // Чтобы получить Level1 data, нужно использовать приведение типов
                // или создать специальный метод в Level2
                super.showAll();
            }
        }

        Level3 obj = new Level3();
        obj.show();
        obj.showHierarchy();
    }
}