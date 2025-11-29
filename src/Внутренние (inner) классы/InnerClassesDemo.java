public class InnerClassesDemo {
    // Поля внешнего класса с разными модификаторами доступа
    private String privateField = "private поле";
    protected String protectedField = "protected поле";
    String packageField = "package поле";
    public String publicField = "public поле";

    // Методы внешнего класса
    private void privateMethod() { System.out.println("privateMethod()"); }
    protected void protectedMethod() { System.out.println("protectedMethod()"); }

    // ПРАКТИКА #1: Внутренние классы с разными спецификаторами доступа
    public class PublicInnerClass {      // public - доступен везде
        public String innerField = "public inner";
        public void show() {
            System.out.println("PublicInnerClass: " + privateField);
        }
    }

    protected class ProtectedInnerClass { // protected - пакет + подклассы
        protected String innerField = "protected inner";
        public void show() {
            System.out.println("ProtectedInnerClass: " + protectedField);
        }
    }

    class PackageInnerClass {           // package-private - только в пакете
        String innerField = "package inner";
        public void show() {
            System.out.println("PackageInnerClass: " + packageField);
        }
    }

    private class PrivateInnerClass {   // private - только внутри OuterClass
        private String innerField = "private inner";
        public void show() {
            System.out.println("PrivateInnerClass: " + publicField);
        }
    }

    // ПРАКТИКА #2: Демонстрация доступа ВНУТРЕННЕГО КЛАССА к ВНЕШНЕМУ
    class AccessDemoInner {
        void demonstrateAccess() {
            // Внутренний класс видит ВСЕ поля и методы внешнего класса!
            System.out.println("=== Практика #2: Доступ внутреннего к внешнему ===");
            System.out.println(privateField);      // ✓ private
            System.out.println(protectedField);    // ✓ protected
            System.out.println(packageField);      // ✓ package
            System.out.println(publicField);       // ✓ public

            privateMethod();                       // ✓ private метод
            protectedMethod();                     // ✓ protected метод
        }
    }

    // ПРАКТИКА #3: Демонстрация доступа ВНЕШНЕГО КЛАССА к ВНУТРЕННЕМУ
    public void demonstrateOuterAccess() {
        System.out.println("\n=== Практика #3: Доступ внешнего к внутреннему ===");

        // Создаем экземпляры внутренних классов
        PublicInnerClass publicInner = new PublicInnerClass();
        ProtectedInnerClass protectedInner = new ProtectedInnerClass();
        PackageInnerClass packageInner = new PackageInnerClass();
        PrivateInnerClass privateInner = new PrivateInnerClass();

        // Внешний класс имеет доступ к публичным полям/методам ВСЕХ внутренних классов
        System.out.println("Public inner field: " + publicInner.innerField);      // ✓
        System.out.println("Protected inner field: " + protectedInner.innerField); // ✓
        System.out.println("Package inner field: " + packageInner.innerField);    // ✓
        System.out.println("Private inner field: " + privateInner.innerField);    // ✓ private поле доступно!

        // Вызываем методы
        publicInner.show();
        protectedInner.show();
        packageInner.show();
        privateInner.show();
    }

    public static void main(String[] args) {
        System.out.println("=== Практика #1: Создание внутренних классов ===");
        InnerClassesDemo outer = new InnerClassesDemo();

        // ✓ public - работает везде
        outer.new PublicInnerClass().show();

        // ✓ protected - работает в пакете/подклассах
        outer.new ProtectedInnerClass().show();

        // ✓ package-private - работает в пакете
        outer.new PackageInnerClass().show();

        // ✗ private - ОШИБКА! Недоступен извне класса
        // outer.new PrivateInnerClass().show(); // Компиляционная ошибка!

        // Практика #2
        outer.new AccessDemoInner().demonstrateAccess();

        // Практика #3
        outer.demonstrateOuterAccess();
    }
}
