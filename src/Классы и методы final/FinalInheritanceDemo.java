public class FinalInheritanceDemo {

    public static void main(String[] args) {
        FinalClassDemo obj = new FinalClassDemo();
        obj.method(); // Работает

        // FinalMethodDemo вызовет ошибку компиляции!
        // new FinalChild(); // ОШИБКА!
    }
}

// ПРАКТИКА #1: final метод - НЕЛЬЗЯ переопределить
class FinalMethodDemo {
    public final void method() {
        System.out.println("Final метод суперкласса");
    }
}

/*
class FinalChild extends FinalMethodDemo {  // ОШИБКА КОМПИЛЯЦИИ!
    @Override
    public void method() {  // cannot override the final method from FinalMethodDemo
        System.out.println("Попытка переопределить final метод");
    }
}
*/

// ПРАКТИКА #2: final класс - НЕЛЬЗЯ наследовать
final class FinalClassDemo {
    public void method() {
        System.out.println("Метод final класса");
    }
}

/*
class FinalClassChild extends FinalClassDemo {  // ОШИБКА КОМПИЛЯЦИИ!
    // cannot inherit from final FinalClassDemo
}
*/
