/**
 * Практическая работа по базовым типам данных в Java
 *
 * @author Student
 * @version 1.0
 * @since 1.8
 */
public class Pr1 {

    /**
     * Практика #1 - Примеры всех базовых типов данных
     */

    // Переменные-члены класса (инициализируются нулевыми значениями по умолчанию)
    private byte defaultByte;        // 0
    private short defaultShort;      // 0
    private int defaultInt;          // 0
    private long defaultLong;        // 0L
    private float defaultFloat;      // 0.0f
    private double defaultDouble;    // 0.0d
    private char defaultChar;        // '\u0000'
    private boolean defaultBoolean;  // false

    /**
     * Демонстрация всех практических работ
     */
    public static void main(String[] args) {
        // Практика #1 - Примеры всех типов данных
        practice1();

        // Практика #2 - Имя в Unicode
        practice2();

        // Практика #3 - Область видимости переменных
        practice3();

        // Практика #4 - Перегруженный оператор +
        practice4();

        // Практика #5 - Арифметические операции с разными типами
        practice5();

        // Практика #6 - Сужающее преобразование типов
        practice6();

        // Практика #7 - Преобразование типов в выражениях
        practice7();

        // Практика #8 - Type inference с var
        practice8();
    }

    /**
     * Практика #1 - Примеры всех базовых типов данных
     */
    public static void practice1() {
        System.out.println("=== Практика #1 ===");

        // Локальные переменные должны быть инициализированы
        byte b = 127;                    // 8 бит
        short s = 32767;                 // 16 бит
        int i = 2147483647;              // 32 бит
        long l = 9223372036854775807L;   // 64 бит
        float f = 3.14f;                 // 32 бит
        double d = 3.141592653589793;    // 64 бит
        char c = 'A';                    // 16 бит (Unicode)
        boolean bool = true;             // 1 бит (в теории)

        // Нулевые значения
        byte zeroByte = 0;
        short zeroShort = 0;
        int zeroInt = 0;
        long zeroLong = 0L;
        float zeroFloat = 0.0f;
        double zeroDouble = 0.0;
        char zeroChar = '\u0000';
        boolean falseBoolean = false;

        System.out.println("byte: " + b + ", нулевое: " + zeroByte);
        System.out.println("short: " + s + ", нулевое: " + zeroShort);
        System.out.println("int: " + i + ", нулевое: " + zeroInt);
        System.out.println("long: " + l + ", нулевое: " + zeroLong);
        System.out.println("float: " + f + ", нулевое: " + zeroFloat);
        System.out.println("double: " + d + ", нулевое: " + zeroDouble);
        System.out.println("char: '" + c + "', нулевое: '" + zeroChar + "'");
        System.out.println("boolean: " + bool + ", нулевое: " + falseBoolean);
        System.out.println();
    }

    /**
     * Практика #2 - Имя в Unicode
     */
    public static void practice2() {
        System.out.println("=== Практика #2 ===");

        // Имя "Анна" в Unicode
        char a = '\u0410';  // А
        char n = '\u043D';  // н
        char n2 = '\u043D'; // н
        char a2 = '\u0430'; // а

        System.out.println("Моё имя в Unicode: " + a + n + n2 + a2);
        System.out.println();
    }

    /**
     * Практика #3 - Область видимости переменных
     */
    public static void practice3() {
        System.out.println("=== Практика #3 ===");

        int a = 1;
        {
            int b = 2;
            // Внутри блока доступны обе переменные
            System.out.println("Внутри блока: a = " + a + ", b = " + b);
        }
        // int c = a + b; // ОШИБКА КОМПИЛЯЦИИ!

        System.out.println("Переменная b не видна вне своего блока {}");
        System.out.println("Область действия b ограничена блоком, где она объявлена");
        System.out.println();
    }

    /**
     * Практика #4 - Перегруженный оператор + с String
     */
    public static void practice4() {
        System.out.println("=== Практика #4 ===");

        String name = "Иван";
        int age = 25;
        double height = 1.75;
        boolean isStudent = true;
        Object obj = new Object();

        // Конкатенация строк с разными типами
        String result1 = "Имя: " + name;
        String result2 = "Возраст: " + age;
        String result3 = "Рост: " + height + " м";
        String result4 = "Студент: " + isStudent;
        String result5 = "Объект: " + obj;
        String result6 = name + " - " + age + " лет, рост: " + height;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println();
    }

    /**
     * Практика #5 - Арифметические операции с разными типами
     */
    public static void practice5() {
        System.out.println("=== Практика #5 ===");

        byte b = 10;
        short s = 20;
        int i = 30;
        long l = 40L;
        float f = 50.5f;
        double d = 60.6;

        // Автоматическое расширение типов
        int result1 = b + s;     // byte + short → int
        long result2 = i + l;    // int + long → long
        float result3 = l + f;   // long + float → float
        double result4 = f + d;  // float + double → double
        double result5 = b + s + i + l + f + d; // всё → double

        System.out.println("byte + short = int: " + b + " + " + s + " = " + result1);
        System.out.println("int + long = long: " + i + " + " + l + " = " + result2);
        System.out.println("long + float = float: " + l + " + " + f + " = " + result3);
        System.out.println("float + double = double: " + f + " + " + d + " = " + result4);
        System.out.println("все типы → double: " + result5);
        System.out.println();
    }

    /**
     * Практика #6 - Сужающее преобразование типов
     */
    public static void practice6() {
        System.out.println("=== Практика #6 ===");

        int i1 = 100;
        int i2 = 200;
        int i3 = 300;
        double d1 = 123.456;
        float f1 = 456.789f;

        // Явное сужающее преобразование
        byte b1 = (byte) i1;      // 100
        byte b2 = (byte) i2;      // -56 (потеря данных!)
        byte b3 = (byte) i3;      // 44 (потеря данных!)
        int i4 = (int) d1;        // 123
        int i5 = (int) f1;        // 456
        short s1 = (short) i2;    // 200

        System.out.println("(byte) 100 = " + b1);
        System.out.println("(byte) 200 = " + b2 + " (потеря данных!)");
        System.out.println("(byte) 300 = " + b3 + " (потеря данных!)");
        System.out.println("(int) 123.456 = " + i4);
        System.out.println("(int) 456.789f = " + i5);
        System.out.println("(short) 200 = " + s1);
        System.out.println();
    }

    /**
     * Практика #7 - Преобразование типов в выражениях
     */
    public static void practice7() {
        System.out.println("=== Практика #7 ===");

        int a = 120;

        // byte b = a + 10; // ОШИБКА КОМПИЛЯЦИИ!
        // Причина: результат a + 10 имеет тип int, который не помещается в byte без явного преобразования

        byte c = (byte)(a + 10); // 130
        // byte d = a + 1; // ОШИБКА КОМПИЛЯЦИИ!

        System.out.println("int a = " + a);
        System.out.println("byte b = a + 10; // Ошибка компиляции - требуется явное преобразование");
        System.out.println("byte c = (byte)(a + 10) = " + c);
        System.out.println("byte d = a + 1; // Ошибка компиляции - требуется явное преобразование");
        System.out.println();
    }

    /**
     * Практика #8 - Type inference с var (Java 10+)
     */
    public static void practice8() {
        System.out.println("=== Практика #8 ===");

        // Type inference - компилятор сам определяет тип
        var name = "Анна";                    // String
        var age = 25;                         // int
        var height = 1.75;                    // double
        var isStudent = true;                 // boolean
        var list = new java.util.ArrayList<String>(); // ArrayList<String>
        var number = 100L;                    // long

        System.out.println("var name = \"Анна\" → " + name.getClass().getSimpleName());
        System.out.println("var age = 25 → int");
        System.out.println("var height = 1.75 → double");
        System.out.println("var isStudent = true → boolean");
        System.out.println("var list = new ArrayList<>() → " + list.getClass().getSimpleName());
        System.out.println("var number = 100L → long");

        // Преимущества var
        var longClassName = new java.util.concurrent.ConcurrentHashMap<String, Integer>();
        // Вместо: ConcurrentHashMap<String, Integer> longClassName = new ConcurrentHashMap<>();

        System.out.println("\nПреимущества var:");
        System.out.println("- Уменьшает избыточность кода");
        System.out.println("- Упрощает чтение сложных generic типов");
        System.out.println("- Тип выводится на этапе компиляции, сохраняя типобезопасность");
    }
}