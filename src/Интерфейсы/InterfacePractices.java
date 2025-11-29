// Практика #1: Package-private интерфейс (без модификатора)
interface PackagePrivateInterface {
    String PACKAGE_FIELD = "Package Field";
    void packageMethod();
}

// Практика #3, #4: Класс для демонстрации protected и private интерфейсов
class OuterClass {
    // Практика #3: Protected интерфейс
    protected interface ProtectedInterface {
        String PROTECTED_FIELD = "Protected Field";
        void protectedMethod();
    }

    // Практика #4: Private интерфейс
    private interface PrivateInterface {
        String PRIVATE_FIELD = "Private Field";
        void privateMethod();
    }

    private class PrivateImpl implements PrivateInterface {
        public void privateMethod() {
            System.out.println("Реализация private метода: " + PRIVATE_FIELD);
        }
    }

    public void demonstratePrivateInterface() {
        PrivateImpl privateImpl = new PrivateImpl();
        privateImpl.privateMethod();
    }
}

// Практика: Наследование интерфейсов
interface BaseInterface1 {
    void baseMethod1();
}

interface BaseInterface2 {
    void baseMethod2();
}

// Практика: Интерфейс, наследующий другие интерфейсы
interface ExtendedInterface extends BaseInterface1, BaseInterface2 {
    void extendedMethod();
}

// Практика: Абстрактный класс, не реализующий все методы
abstract class AbstractClass implements ExtendedInterface {
    public void baseMethod1() {
        System.out.println("Реализован baseMethod1");
    }
    // baseMethod2 и extendedMethod не реализованы - класс abstract
}

// Конкретный класс, завершающий реализацию
class ConcreteClass extends AbstractClass {
    public void baseMethod2() {
        System.out.println("Реализован baseMethod2");
    }

    public void extendedMethod() {
        System.out.println("Реализован extendedMethod");
    }
}

// Практика: Класс, реализующий несколько интерфейсов
class MultiInterfaceClass implements PackagePrivateInterface, OuterClass.ProtectedInterface {
    public void packageMethod() {
        System.out.println("Package-private метод: " + PACKAGE_FIELD);
    }

    public void protectedMethod() {
        System.out.println("Protected метод: " + PROTECTED_FIELD);
    }
}

// Главный класс
public class InterfacePractices {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ВСЕХ ПРАКТИК ===\n");

        // Практика #1: Package-private интерфейс
        System.out.println("1. Package-private интерфейс:");
        MultiInterfaceClass multi = new MultiInterfaceClass();
        multi.packageMethod();
        multi.protectedMethod();
        System.out.println();

        // Практика #3, #4: Protected и private интерфейсы
        System.out.println("2. Protected и Private интерфейсы:");
        OuterClass outer = new OuterClass();
        outer.demonstratePrivateInterface();
        System.out.println();

        // Практика: Наследование интерфейсов и абстрактные классы
        System.out.println("3. Наследование интерфейсов и абстрактные классы:");
        ConcreteClass concrete = new ConcreteClass();
        concrete.baseMethod1();
        concrete.baseMethod2();
        concrete.extendedMethod();
        System.out.println();

        // Практика: Поля интерфейсов
        System.out.println("4. Поля интерфейсов (public static final):");
        System.out.println("Package поле: " + PackagePrivateInterface.PACKAGE_FIELD);
        System.out.println("Protected поле: " + OuterClass.ProtectedInterface.PROTECTED_FIELD);

        // Демонстрация нескольких интерфейсов
        System.out.println("\n5. Реализация нескольких интерфейсов:");
        class TestClass implements BaseInterface1, BaseInterface2 {
            public void baseMethod1() {
                System.out.println("BaseMethod1 из двух интерфейсов");
            }
            public void baseMethod2() {
                System.out.println("BaseMethod2 из двух интерфейсов");
            }
        }
        TestClass test = new TestClass();
        test.baseMethod1();
        test.baseMethod2();
    }
}