/**
 * Демонстрация всех способов инициализации final поля класса.
 * @author Student
 * @version 1.0
 */
public class FinalDemo {

    // ВАРИАНТ 1: Инициализация при объявлении (рекомендуемый)
    public final int a1 = 42;

    // ВАРИАНТ 2: Инициализация в конструкторе
    public final int a2;

    // ВАРИАНТ 3: Инициализация в блоке инициализации экземпляра
    public final int a3;

    // Статическая final - только при объявлении или в static блоке
    public static final int STATIC_A = 100;

    // Блок инициализации экземпляра
    {
        a3 = 300;
    }

    // Конструктор - инициализация final полей
    public FinalDemo() {
        a2 = 200;  // Обязательно!
    }

    // Статический блок (для static final)
    static {
        // STATIC_A = 200; // ОШИБКА! static final только при объявлении
    }

    public static void main(String[] args) {
        FinalDemo obj = new FinalDemo();

        System.out.println("a1 = " + obj.a1); // 42
        System.out.println("a2 = " + obj.a2); // 200 (конструктор)
        System.out.println("a3 = " + obj.a3); // 300 (блок инициализации)
        System.out.println("STATIC_A = " + FinalDemo.STATIC_A); // 100

        // obj.a1 = 99; // ОШИБКА! final нельзя менять
    }
}
