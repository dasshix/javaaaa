public class Cl {

    public static void main(String[] args) {
        // Практика #1 - Метод decode()
        practice1();

        // Практика #2 - Создание Boolean
        practice2();

        // Практика #3 - NullPointerException при автоупаковке
        practice3();

        // Практика #4 - Кэширование Integer
        practice4();
    }

    /**
     * Практика #1 - Метод decode()
     */
    public static void practice1() {
        System.out.println("=== Практика #1 - Метод decode() ===");

        // decode() может парсить числа в разных системах счисления:
        // - Десятичные: "123"
        // - Восьмеричные: "0123" (начинается с 0)
        // - Шестнадцатеричные: "0x123", "0X123", "#123"

        // Десятичные числа
        Integer dec1 = Integer.decode("123");
        Integer dec2 = Integer.decode("456");
        System.out.println("decode(\"123\") = " + dec1);
        System.out.println("decode(\"456\") = " + dec2);

        // Восьмеричные числа (начинаются с 0)
        Integer oct1 = Integer.decode("0123"); // 83 в десятичной
        Integer oct2 = Integer.decode("0777"); // 511 в десятичной
        System.out.println("decode(\"0123\") = " + oct1 + " (восьмеричное)");
        System.out.println("decode(\"0777\") = " + oct2 + " (восьмеричное)");

        // Шестнадцатеричные числа
        Integer hex1 = Integer.decode("0x123");  // 291 в десятичной
        Integer hex2 = Integer.decode("0XABC");  // 2748 в десятичной
        Integer hex3 = Integer.decode("#FFF");   // 4095 в десятичной
        System.out.println("decode(\"0x123\") = " + hex1 + " (шестнадцатеричное)");
        System.out.println("decode(\"0XABC\") = " + hex2 + " (шестнадцатеричное)");
        System.out.println("decode(\"#FFF\") = " + hex3 + " (шестнадцатеричное)");

        // Отрицательные числа
        Integer neg1 = Integer.decode("-123");
        Integer neg2 = Integer.decode("-0x1F"); // -31 в десятичной
        System.out.println("decode(\"-123\") = " + neg1);
        System.out.println("decode(\"-0x1F\") = " + neg2);

        // Для других типов
        Long longVal = Long.decode("0x123456789ABCDEF");
        System.out.println("Long.decode(\"0x123456789ABCDEF\") = " + longVal);

        System.out.println();
    }

    /**
     * Практика #2 - Создание экземпляров Boolean
     */
    public static void practice2() {
        System.out.println("=== Практика #2 - Создание Boolean ===");

        // 1. Через конструктор (не рекомендуется, deprecated в Java 9+)
        Boolean bool1 = new Boolean(true);
        Boolean bool2 = new Boolean(false);
        Boolean bool3 = new Boolean("true");
        Boolean bool4 = new Boolean("false");
        Boolean bool5 = new Boolean("TRUE"); // нечувствителен к регистру
        Boolean bool6 = new Boolean("любой_текст"); // false для любой строки кроме "true"

        System.out.println("Конструкторы:");
        System.out.println("new Boolean(true) = " + bool1);
        System.out.println("new Boolean(\"true\") = " + bool3);
        System.out.println("new Boolean(\"TRUE\") = " + bool5);
        System.out.println("new Boolean(\"любой_текст\") = " + bool6);

        // 2. Через valueOf (рекомендуемый способ)
        Boolean bool7 = Boolean.valueOf(true);
        Boolean bool8 = Boolean.valueOf(false);
        Boolean bool9 = Boolean.valueOf("true");
        Boolean bool10 = Boolean.valueOf("false");
        Boolean bool11 = Boolean.valueOf("TRUE");
        Boolean bool12 = Boolean.valueOf("любой_текст");

        System.out.println("\nvalueOf():");
        System.out.println("Boolean.valueOf(true) = " + bool7);
        System.out.println("Boolean.valueOf(\"true\") = " + bool9);
        System.out.println("Boolean.valueOf(\"TRUE\") = " + bool11);
        System.out.println("Boolean.valueOf(\"любой_текст\") = " + bool12);

        // 3. Через parseBoolean (возвращает примитив boolean)
        boolean bool13 = Boolean.parseBoolean("true");
        boolean bool14 = Boolean.parseBoolean("false");
        boolean bool15 = Boolean.parseBoolean("TRUE");
        boolean bool16 = Boolean.parseBoolean("любой_текст");

        System.out.println("\nparseBoolean():");
        System.out.println("Boolean.parseBoolean(\"true\") = " + bool13);
        System.out.println("Boolean.parseBoolean(\"TRUE\") = " + bool15);
        System.out.println("Boolean.parseBoolean(\"любой_текст\") = " + bool16);

        // 4. Автоупаковка
        Boolean bool17 = true;
        Boolean bool18 = false;

        System.out.println("\nАвтоупаковка:");
        System.out.println("Boolean bool17 = true -> " + bool17);
        System.out.println("Boolean bool18 = false -> " + bool18);

        // 5. Константы
        Boolean bool19 = Boolean.TRUE;
        Boolean bool20 = Boolean.FALSE;

        System.out.println("\nКонстанты:");
        System.out.println("Boolean.TRUE = " + bool19);
        System.out.println("Boolean.FALSE = " + bool20);

        System.out.println();
    }

    /**
     * Практика #3 - NullPointerException при автоупаковке/распаковке
     */
    public static void practice3() {
        System.out.println("=== Практика #3 - NullPointerException ===");

        // Исключение возникает при попытке распаковать null в примитив
        Integer nullInteger = null;
        Double nullDouble = null;
        Boolean nullBoolean = null;

        try {
            System.out.println("Попытка распаковать null Integer:");
            int i = nullInteger; // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("NullPointerException при распаковке Integer: " + e.getMessage());
        }

        try {
            System.out.println("Попытка распаковать null Double:");
            double d = nullDouble; // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("NullPointerException при распаковке Double: " + e.getMessage());
        }

        try {
            System.out.println("Попытка распаковать null Boolean:");
            boolean b = nullBoolean; // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("NullPointerException при распаковке Boolean: " + e.getMessage());
        }

        // Также в арифметических операциях
        try {
            System.out.println("Попытка арифметической операции с null:");
            int result = nullInteger + 10; // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("NullPointerException в арифметической операции: " + e.getMessage());
        }

        // Но сравнение с null безопасно
        System.out.println("\nБезопасные операции с null:");
        System.out.println("nullInteger == null: " + (nullInteger == null));
        System.out.println("nullInteger != null: " + (nullInteger != null));

        // Автоупаковка null невозможна, т.к. null уже является ссылкой
        Integer autoBoxed = null; // Это нормально - просто присваиваем null ссылке

        System.out.println();
    }

    /**
     * Практика #4 - Кэширование Integer и сравнение
     */
    public static void practice4() {
        System.out.println("=== Практика #4 - Кэширование Integer ===");

        // IntegerCache кэширует значения от -128 до 127
        // Для значений в этом диапазоне valueOf() возвращает один и те же объекты
        // Для значений вне этого диапазона создаются новые объекты

        System.out.println("=== Для значения 128 (вне кэша) ===");
        int i1 = 128;
        Integer a1 = i1;  // автоупаковка - создается новый объект
        Integer b1 = i1;  // автоупаковка - создается новый объект

        System.out.println("a1==i1 " + (a1 == i1));       // true - автораспаковка
        System.out.println("b1==i1 " + (b1 == i1));       // true - автораспаковка
        System.out.println("a1==b1 " + (a1 == b1));       // false - разные объекты!
        System.out.println("a1.equals(i1) -> " + a1.equals(i1)); // true
        System.out.println("b1.equals(i1) -> " + b1.equals(i1)); // true
        System.out.println("a1.equals(b1) -> " + a1.equals(b1)); // true

        System.out.println("\n=== Для значения 127 (в кэше) ===");
        int i2 = 127;
        Integer a2 = i2;  // автоупаковка - берется из кэша
        Integer b2 = i2;  // автоупаковка - берется из кэша (тот же объект)

        System.out.println("a2==i2 " + (a2 == i2));       // true - автораспаковка
        System.out.println("b2==i2 " + (b2 == i2));       // true - автораспаковка
        System.out.println("a2==b2 " + (a2 == b2));       // true - один объект из кэша!
        System.out.println("a2.equals(i2) -> " + a2.equals(i2)); // true
        System.out.println("b2.equals(i2) -> " + b2.equals(i2)); // true
        System.out.println("a2.equals(b2) -> " + a2.equals(b2)); // true

        // Демонстрация работы IntegerCache
        System.out.println("\n=== Демонстрация IntegerCache ===");

        // Значения в диапазоне кэша
        Integer c1 = Integer.valueOf(100);
        Integer c2 = Integer.valueOf(100);
        System.out.println("Integer.valueOf(100) == Integer.valueOf(100): " + (c1 == c2)); // true

        // Значения вне диапазона кэша
        Integer c3 = Integer.valueOf(200);
        Integer c4 = Integer.valueOf(200);
        System.out.println("Integer.valueOf(200) == Integer.valueOf(200): " + (c3 == c4)); // false

        // Граничные значения
        Integer c5 = Integer.valueOf(127);
        Integer c6 = Integer.valueOf(127);
        Integer c7 = Integer.valueOf(128);
        Integer c8 = Integer.valueOf(128);
        System.out.println("Integer.valueOf(127) == Integer.valueOf(127): " + (c5 == c6)); // true
        System.out.println("Integer.valueOf(128) == Integer.valueOf(128): " + (c7 == c8)); // false

        // Отрицательные значения тоже кэшируются
        Integer c9 = Integer.valueOf(-128);
        Integer c10 = Integer.valueOf(-128);
        Integer c11 = Integer.valueOf(-129);
        Integer c12 = Integer.valueOf(-129);
        System.out.println("Integer.valueOf(-128) == Integer.valueOf(-128): " + (c9 == c10)); // true
        System.out.println("Integer.valueOf(-129) == Integer.valueOf(-129): " + (c11 == c12)); // false

        System.out.println("\nВывод: всегда используйте equals() для сравнения объектов!");
    }
}

/**
 * Дополнительный класс для демонстрации сравнения оберток
 */
class WrapperComparison {
    public static void main(String[] args) {
        System.out.println("=== Дополнительные примеры сравнения ===");

        // Сравнение через compareTo
        Integer x = 100;
        Integer y = 200;
        System.out.println("x.compareTo(y): " + x.compareTo(y)); // отрицательное
        System.out.println("y.compareTo(x): " + y.compareTo(x)); // положительное
        System.out.println("x.compareTo(x): " + x.compareTo(x)); // 0

        // Сравнение разных числовых типов
        Number num1 = Integer.valueOf(100);
        Number num2 = Double.valueOf(100.0);
        System.out.println("num1.equals(num2): " + num1.equals(num2)); // false - разные классы
    }
}