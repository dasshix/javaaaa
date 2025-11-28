public class Loops {
    public static void main(String[] args) {
        // Практика #1: Бесконечный цикл while
        System.out.println("Бесконечный цикл while с условием true:");
        int count = 0;
        while (true) {
            System.out.println("while: " + count);
            count++;
            if (count >= 5) break; // выход из цикла
        }

        // Практика #1: Бесконечный цикл do-while
        System.out.println("\nБесконечный цикл do-while с условием true:");
        count = 0;
        do {
            System.out.println("do-while: " + count);
            count++;
            if (count >= 5) break; // выход из цикла
        } while (true);

        // Практика #2: Использование break и continue в цикле for
        System.out.println("\nЦикл for с break и continue:");
        int[] arr = {1, 2, 3, 4, 5};
        for (int elem : arr) {
            if (elem == 3) {
                System.out.println("Пропускаем элемент: " + elem);
                continue; // пропускаем итерацию с elem=3
            }
            if (elem == 5) {
                System.out.println("Прерываем цикл на элементе: " + elem);
                break; // завершаем цикл при elem=5
            }
            System.out.println("Текущий элемент: " + elem);
        }
    }
}
