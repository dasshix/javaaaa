import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * Демонстрация переопределения метода equals() и hashCode()
 */
public class EqualsDemo {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация переопределения equals() ===\n");

        // Создаем несколько студентов для тестирования
        Student student1 = new Student("S001", "Иван Иванов", 20, "Computer Science");
        Student student2 = new Student("S001", "Иван Иванов", 20, "Computer Science");
        Student student3 = new Student("S002", "Петр Петров", 21, "Mathematics");
        Student student4 = new Student("S001", "Иван Иванов", 22, "Computer Science"); // Другой возраст

        // Тестируем рефлексивность
        System.out.println("1. Рефлексивность (student1.equals(student1)): " + student1.equals(student1));

        // Тестируем симметричность
        System.out.println("2. Симметричность:");
        System.out.println("   student1.equals(student2): " + student1.equals(student2));
        System.out.println("   student2.equals(student1): " + student2.equals(student1));

        // Тестируем транзитивность
        Student student1Copy = new Student("S001", "Иван Иванов", 20, "Computer Science");
        System.out.println("3. Транзитивность:");
        System.out.println("   student1.equals(student2): " + student1.equals(student2));
        System.out.println("   student2.equals(student1Copy): " + student2.equals(student1Copy));
        System.out.println("   student1.equals(student1Copy): " + student1.equals(student1Copy));

        // Тестируем сравнение с null
        System.out.println("4. Сравнение с null: " + student1.equals(null));

        // Тестируем сравнение с объектом другого класса
        System.out.println("5. Сравнение с другим классом: " + student1.equals("Not a Student"));

        // Тестируем различные случаи неравенства
        System.out.println("\n6. Тестирование различных случаев:");
        System.out.println("   student1.equals(student3): " + student1.equals(student3) + " // Разные ID");
        System.out.println("   student1.equals(student4): " + student1.equals(student4) + " // Разный возраст");

        // Тестируем hashCode контракт
        System.out.println("\n7. Проверка контракта hashCode():");
        System.out.println("   student1.hashCode() == student2.hashCode(): " +
                (student1.hashCode() == student2.hashCode()));
        System.out.println("   student1.hashCode(): " + student1.hashCode());
        System.out.println("   student2.hashCode(): " + student2.hashCode());

        // Демонстрация использования в коллекциях
        System.out.println("\n8. Использование в HashSet:");
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2); // Должен считаться дубликатом
        studentSet.add(student3);

        System.out.println("   Размер HashSet: " + studentSet.size());
        System.out.println("   Содержит student1: " + studentSet.contains(student1));
        System.out.println("   Содержит student2: " + studentSet.contains(student2));

        // Демонстрация с InternationalStudent
        System.out.println("\n=== Тестирование с InternationalStudent ===");
        InternationalStudent intStudent1 = new InternationalStudent("S001", "John", 20, "CS", "USA");
        InternationalStudent intStudent2 = new InternationalStudent("S001", "John", 20, "CS", "USA");
        Student regularStudent = new Student("S001", "John", 20, "CS");

        System.out.println("intStudent1.equals(intStudent2): " + intStudent1.equals(intStudent2));
        System.out.println("intStudent1.equals(regularStudent): " + intStudent1.equals(regularStudent));
        System.out.println("regularStudent.equals(intStudent1): " + regularStudent.equals(intStudent1));

        demonstrateCommonMistakes();
    }

    public static void demonstrateCommonMistakes() {
        System.out.println("\n=== Распространенные ошибки при переопределении equals() ===\n");

        // Пример неправильной реализации
        BadStudent bad1 = new BadStudent("B001");
        BadStudent bad2 = new BadStudent("B001");

        System.out.println("Ошибка 1 - Неправильная сигнатура метода:");
        System.out.println("   bad1.equals(bad2): " + bad1.equals(bad2)); // Работает
        System.out.println("   Но при полиморфном вызове может сломаться!");

        System.out.println("\nОшибка 2 - Отсутствие hashCode():");
        System.out.println("   Если equals() переопределен, hashCode() тоже должен быть переопределен");

        System.out.println("\nОшибка 3 - Непроверка на null и класс:");
        System.out.println("   Может привести к ClassCastException или NullPointerException");
    }
}

/**
 * Класс Student с переопределенным методом equals()
 */
class Student {
    private final String id;
    private final String name;
    private final int age;
    private final String department;

    public Student(String id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    /**
     * Переопределение метода equals() с соблюдением контракта
     *
     * Контракт метода equals():
     * 1. Рефлексивность: x.equals(x) → true
     * 2. Симметричность: x.equals(y) → y.equals(x)
     * 3. Транзитивность: x.equals(y) и y.equals(z) → x.equals(z)
     * 4. Непротиворечивость: многократные вызовы возвращают одинаковый результат
     * 5. Сравнение с null: x.equals(null) → false
     */
    @Override
    public boolean equals(Object obj) {
        // 1. Проверка рефлексивности - тот же объект
        if (this == obj) {
            return true;
        }

        // 2. Проверка на null и совместимость типов
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        // 3. Приведение типа
        Student other = (Student) obj;

        // 4. Сравнение значимых полей
        // Сначала сравниваем примитивы (age), затем объекты с null-проверкой
        return this.age == other.age &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.department, other.department);
    }

    /**
     * Переопределение hashCode() в соответствии с контрактом:
     * - Если два объекта равны по equals(), их hashCode() должны быть равны
     * - Обратное не обязательно: разные объекты могут иметь одинаковый hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, department);
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', age=%d, department='%s'}",
                id, name, age, department);
    }

    // Геттеры
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
}

/**
 * Дополнительный пример с наследованием
 */
class InternationalStudent extends Student {
    private final String country;

    public InternationalStudent(String id, String name, int age, String department, String country) {
        super(id, name, age, department);
        this.country = country;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (obj instanceof InternationalStudent) {
            InternationalStudent other = (InternationalStudent) obj;
            return Objects.equals(this.country, other.country);
        }

        // Если obj Student, но не InternationalStudent, они не равны
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country);
    }

    @Override
    public String toString() {
        return String.format("InternationalStudent{id='%s', name='%s', age=%d, department='%s', country='%s'}",
                getId(), getName(), getAge(), getDepartment(), country);
    }
}

/**
 * Пример класса с неправильной реализацией equals()
 */
class BadStudent {
    private String id;

    public BadStudent(String id) {
        this.id = id;
    }

    // НЕПРАВИЛЬНАЯ реализация equals()
    public boolean equals(BadStudent other) { // Ошибка: параметр должен быть Object
        return this.id.equals(other.id);
    }

    // Отсутствует переопределение hashCode()
}