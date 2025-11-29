/**
 * Демонстрация enum с инициализацией элементов и дополнительными методами.
 * Решает Практику #1 (инициализация) и #2 (дополнительный метод).
 * @author Student
 * @version 1.0
 */
public class EnumDemo {

    // ПРАКТИКА #1: Enum с инициализацией элементов (конструктор + поля)
    public enum Day {
        MONDAY("Понедельник", 1),
        TUESDAY("Вторник", 2),
        WEDNESDAY("Среда", 3),
        THURSDAY("Четверг", 4),
        FRIDAY("Пятница", 5),
        SATURDAY("Суббота", 6),
        SUNDAY("Воскресенье", 7);

        private final String russianName;
        private final int dayNumber;

        // Конструктор enum (инициализация элементов)
        Day(String russianName, int dayNumber) {
            this.russianName = russianName;
            this.dayNumber = dayNumber;
        }

        // Геттеры
        public String getRussianName() { return russianName; }
        public int getDayNumber() { return dayNumber; }
    }

    // ПРАКТИКА #2: Enum с дополнительным методом
    public enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.37814e6),
        MARS(6.421e+23, 3.3972e6);

        private final double mass;   // масса в килограммах
        private final double radius; // радиус в метрах

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        // Дополнительный метод: поверхностное ускорение
        public double surfaceGravity() {
            final double G = 6.67300E-11; // гравитационная постоянная
            return G * mass / (radius * radius);
        }

        public double surfaceWeight(double otherMass) {
            return otherMass * surfaceGravity();
        }
    }

    public static void main(String[] args) {
        // Практика #1: использование инициализированных enum
        System.out.println("=== ПРАКТИКА #1: Enum с инициализацией ===");
        Day today = Day.FRIDAY;
        System.out.println(today + " → " + today.getRussianName() + " (день " + today.getDayNumber() + ")");

        // Практика #2: enum с методом
        System.out.println("\n=== ПРАКТИКА #2: Enum с методом ===");
        double earthWeight = 80; // масса человека на Земле
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        System.out.printf("Вес %4.2f кг на Земле = %.2f кг массы\n", earthWeight, mass);
        System.out.printf("На Марсе: %.2f кг\n", Planet.MARS.surfaceWeight(mass));
        System.out.printf("На Венере: %.2f кг\n", Planet.VENUS.surfaceWeight(mass));
    }
}
