public class Array {
    /**
     * Показывает работу с массивами и методы java.util.Arrays.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // ПРАКТИКА #1: Массивы - ссылки на объекты
        System.out.println("=== ПРАКТИКА #1: Массивы как ссылки ===");
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {6, 7, 8, 9, 10};

        System.out.println("a1[0]=" + a1[0] + ", a2[0]=" + a2[0]); // 1, 6

        a1 = a2;  // a1 теперь ссылается на тот же массив, что и a2!

        System.out.println("После a1 = a2:");
        System.out.println("a1[0]=" + a1[0] + ", a2[0]=" + a2[0]); // 6, 6
        System.out.println("a1.length=" + a1.length); // 5

        // Многомерный массив (массив массивов)
        int[][] matrix = {{1, 2}, {3, 4, 5}, {6}};
        System.out.println("matrix[1][1]=" + matrix[1][1]); // 4

        // ПРАКТИКА #2: Методы java.util.Arrays
        System.out.println("\n=== ПРАКТИКА #2: java.util.Arrays ===");
        int[] numbers = {5, 2, 8, 1, 9, 3};

        // toString()
        System.out.println("Arrays.toString(numbers): " +
                java.util.Arrays.toString(numbers));

        // sort()
        java.util.Arrays.sort(numbers);
        System.out.println("После sort(): " +
                java.util.Arrays.toString(numbers));

        // binarySearch() (требует отсортированный массив)
        int pos = java.util.Arrays.binarySearch(numbers, 3);
        System.out.println("binarySearch(3): " + pos); // индекс элемента 3

        // equals()
        int[] copy = {1, 2, 3, 5, 8, 9};
        boolean same = java.util.Arrays.equals(numbers, copy);
        System.out.println("equals(): " + same); // true

        // compare() (Java 9+)
        int cmp = java.util.Arrays.compare(numbers, copy);
        System.out.println("compare(): " + cmp); // 0 если равны
    }
}
