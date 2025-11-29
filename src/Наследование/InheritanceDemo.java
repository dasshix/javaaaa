public class InheritanceDemo {

    public static void main(String[] args) {
        // Тест доступа
        B b = new B();
        C c = new C();

        // Практика #2: доступ из C к полям A
        System.out.println("=== ПРАКТИКА #2: Доступ из класса C ===");
        c.method1();     // OK (default → default)
        c.method2();     // OK (public → public)
        c.method3();     // OK (protected → protected)
        // c.method4();  // ОШИБКА! private недоступно

        // Поля из C
        System.out.println("a1=" + c.a1);      // OK
        System.out.println("a2=" + c.a2);      // OK
        System.out.println("a3=" + c.a3);      // OK
        // System.out.println("a4=" + c.a4);   // ОШИБКА!
    }
}

// ПРАКТИКА #2: Исходные классы
class AAA {
    int a1;           // default (package-private)
    public int a2;    // public
    protected int a3; // protected
    private int a4;   // private

    void method1() {        // default
        System.out.println("A.method1()");
    }

    public void method2() { // public
        System.out.println("A.method2()");
    }

    protected void method3() { // protected
        System.out.println("A.method3()");
    }

    private void method4() {   // private
        System.out.println("A.method4()");
    }
}

class B extends AAA {
    // Наследует все НЕ private поля и методы
}

class C extends B {
    // ПРАКТИКА #1: this и super в подклассе
    void demoThisSuper() {
        this.a1 = 1;     // Текущий класс (C через B)
        this.a2 = 2;
        this.a3 = 3;

        super.a1 = 10;   // Суперкласс (B/A)
        super.a2 = 20;
        super.a3 = 30;

        // super.method1(); // OK (наследуется)
        // super.method2(); // OK
        // super.method3(); // OK

        System.out.println("this.a1=" + this.a1 + ", super.a1=" + super.a1);
    }
}
