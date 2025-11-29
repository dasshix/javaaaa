public class StringBuilderBufferDemo {
    public static void main(String[] args) {
        // ПРАКТИКА #1: 10 методов StringBuilder/StringBuffer
        System.out.println("=== ПРАКТИКА #1: Методы StringBuilder/StringBuffer ===");

        StringBuilder sb = new StringBuilder("Hello");
        StringBuffer sbf = new StringBuffer("World");

        System.out.println("Исходные: sb='" + sb + "', sbf='" + sbf + "'");

        // 1. append() - добавить в конец
        sb.append(" Java!");
        System.out.println("1. append(): " + sb); // Hello Java!

        // 2. insert(int offset, String str) - вставить по позиции
        sbf.insert(3, "Beautiful ");
        System.out.println("2. insert(3): " + sbf); // WorBeautiful ld

        // 3. delete(int start, int end) - удалить участок
        sb.delete(5, 10);  // Удаляем " Java"
        System.out.println("3. delete(5,10): " + sb); // Hello!

        // 4. replace(int start, int end, String str) - заменить участок
        sbf.replace(3, 11, "Wonderful");
        System.out.println("4. replace(): " + sbf); // WorWonderfulld

        // 5. reverse() - развернуть строку
        sb.reverse();
        System.out.println("5. reverse(): " + sb); // !olleH

        // 6. setCharAt(int index, char ch) - заменить символ
        sbf.setCharAt(0, 'M');
        System.out.println("6. setCharAt(0): " + sbf); // MorWonderfulld

        // 7. capacity() - текущая емкость буфера
        System.out.println("7. capacity(): sb=" + sb.capacity() + ", sbf=" + sbf.capacity());

        // 8. ensureCapacity(int minimum) - гарантировать емкость
        sb.ensureCapacity(100);
        System.out.println("8. ensureCapacity(100): sb=" + sb.capacity());

        // 9. length() - текущая длина строки
        System.out.println("9. length(): sb=" + sb.length() + ", sbf=" + sbf.length());

        // 10. charAt(int index) - символ по индексу
        System.out.println("10. charAt(0): sb='" + sb.charAt(0) + "', sbf='" + sbf.charAt(0) + "'");

        // ПРАКТИКА #2: Преобразования между классами
        System.out.println("\n=== ПРАКТИКА #2: Преобразования ===");

        // StringBuilder/StringBuffer → String
        String fromSB = sb.toString();
        String fromSBF = sbf.toString();
        System.out.println("→ String: '" + fromSB + "', '" + fromSBF + "'");

        // String → StringBuilder/StringBuffer
        StringBuilder sb2 = new StringBuilder("New StringBuilder");
        StringBuffer sbf2 = new StringBuffer("New StringBuffer");
        System.out.println("String → SB/SBF: '" + sb2 + "', '" + sbf2 + "'");

        // StringBuilder → StringBuffer (через String)
        StringBuffer sbf3 = new StringBuffer(sb.toString());
        System.out.println("SB → SBF: '" + sbf3 + "'");

        // StringBuffer → StringBuilder (через String)
        StringBuilder sb3 = new StringBuilder(sbf.toString());
        System.out.println("SBF → SB: '" + sb3 + "'");

        System.out.println("\n=== ПРОИЗВОДИТЕЛЬНОСТЬ ===");
        // Демонстрация мутабельности
        StringBuilder fast = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            fast.append("★").append(i);
        }
        System.out.println("StringBuilder (быстро): " + fast);

        // StringBuffer - потокобезопасный (медленнее)
        StringBuffer safe = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            safe.append("♦").append(i);
        }
        System.out.println("StringBuffer (безопасно): " + safe);
    }
}
