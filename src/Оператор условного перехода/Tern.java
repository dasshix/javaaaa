public class Tern {
    public static void main(String[] args) {
        int a = 2; // пример значения

        // Исходный код с if-else if-else
        int i1 = 0;
        if (a == 1) {
            i1 = 1;
        } else if (a == 2) {
            i1 = 2;
        } else {
            i1 = 3;
        }
        System.out.println("С if-else: i = " + i1);

        // Преобразование в тернарный оператор
        int i2 = (a == 1) ? 1 : (a == 2) ? 2 : 3;
        System.out.println("С тернарным оператором: i = " + i2);

        // Более читаемый вариант с форматированием
        int i3 = (a == 1) ? 1
                : (a == 2) ? 2
                : 3;
        System.out.println("С форматированным тернарным оператором: i = " + i3);
    }
}