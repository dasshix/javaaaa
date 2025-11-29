import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        // ПРАКТИКА #1: instanceof с generics
        System.out.println("=== ПРАКТИКА #1: instanceof с generics ===");
        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        List<?> wildList = intList;

        System.out.println("intList instanceof List: " + (intList instanceof List)); // true
        System.out.println("intList instanceof List<Integer>: " + (intList instanceof List<Integer>));
        System.out.println("wildList instanceof List: " + (wildList instanceof List)); // true
        System.out.println("Пустой список имеет length=0, но instanceof работает!");

        // ПРАКТИКА #2: <? extends T> и <? super T> (безопасно)
        System.out.println("\n=== ПРАКТИКА #2: Bounded Wildcards ===");

        List<Integer> ints = new ArrayList<>();
        ints.add(10); // Добавляем элемент
        List<? extends Number> numbers = ints;
        System.out.println("Чтение из <? extends Number>: " + numbers.get(0)); // OK

        List<Number> numList = new ArrayList<>();
        List<? super Integer> superList = numList;
        superList.add(42); // OK - запись
        System.out.println("Запись в <? super Integer>: добавлен 42");
        
    }
}
