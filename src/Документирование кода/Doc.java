/**
 * Практическая работа №1 - Демонстрация Javadoc
 */
public class Doc {

    /**
     * Константа для приветственного сообщения
     */
    public static final String GREETING = "Hello, JavaDoc!";

    /**
     * Основной метод программы
     *
     * @param args аргументы командной строки (не используются)
     * @see #calculate(int, int)
     */
    public static void main(String[] args) {
        System.out.println(GREETING);
        int result = calculate(5, 3);
        System.out.println("5 + 3 = " + result);
    }

    /**
     * Вычисляет сумму двух чисел
     *
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма a и b
     * @throws IllegalArgumentException если параметры отрицательные
     * @deprecated используйте {@link Math#addExact(int, int)}
     */
    @Deprecated
    public static int calculate(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Numbers must be positive");
        }
        return a + b;
    }
}
