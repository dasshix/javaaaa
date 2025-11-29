import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// ПРАКТИКА #1: Демонстрация встроенных аннотаций

class Parent {
    public void originalMethod() {
        System.out.println("Оригинальный метод из Parent");
    }

    @Deprecated(since = "1.0", forRemoval = true)
    public void oldMethod() {
        System.out.println("УСТАРЕВШИЙ метод - не используйте!");
    }
}

class Child extends Parent {
    // @Override - проверяет корректное переопределение
    @Override
    public void originalMethod() {
        System.out.println("ПЕРЕОПРЕДЕЛЕННЫЙ метод в Child");
    }

    // Ошибка! Попытка переопределить с опечаткой
    /*
    @Override
    public void orignalMethod() {  // ОШИБКА компиляции!
        System.out.println("Опечатка в имени метода");
    }
    */

    // @SuppressWarnings - подавляет предупреждения компилятора
    @SuppressWarnings("deprecation")
    public void callDeprecated() {
        oldMethod();  // Без аннотации было бы предупреждение!
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void unsafeCode() {
        java.util.List list = new java.util.ArrayList();  // Raw type warning подавлено
        list.add("Элемент");
        System.out.println("Небезопасный код: " + list.get(0));
    }
}

// Собственная аннотация (как в примере)
@Target(ElementType.TYPE)
@interface BaseAction {
    int level();
}

@BaseAction(level = 2)
class AnnotatedClass {
    public void doAction() {
        try {
            Class<?> clazz = AnnotatedClass.class;
            BaseAction action = (BaseAction) clazz.getAnnotation(BaseAction.class);
            if (action != null) {
                System.out.println("Уровень аннотации BaseAction: " + action.level());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class AnnotationsDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ АННОТАЦИЙ ===");

        // 1. @Override - гарантирует корректное переопределение
        System.out.println("\n1. @Override:");
        Child child = new Child();
        child.originalMethod();  // Вызывает переопределенный метод

        // 2. @Deprecated - помечает устаревший код
        System.out.println("\n2. @Deprecated:");
        // child.oldMethod();  // Компилятор покажет предупреждение!

        // 3. @SuppressWarnings - скрывает предупреждения
        System.out.println("\n3. @SuppressWarnings:");
        child.callDeprecated();     // Предупреждение подавлено
        child.unsafeCode();         // Raw types предупреждение подавлено

        // 4. Собственная аннотация
        System.out.println("\n4. Собственная аннотация @BaseAction:");
        AnnotatedClass annotated = new AnnotatedClass();
        annotated.doAction();
    }
}
