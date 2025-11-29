import java.io.*;
import java.util.*;

// Узел дерева Хаффмана
class HuffmanNode implements Comparable<HuffmanNode> {
    byte data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(byte data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

// Основной класс для кодирования/декодирования Хаффмана
public class HuffmanCoder {
    private Map<Byte, String> huffmanCodes;
    private HuffmanNode root;

    public HuffmanCoder() {
        huffmanCodes = new HashMap<>();
    }

    // Кодирование файла
    public void encode(String inputFile, String outputFile) throws IOException {
        // Чтение входного файла
        byte[] fileData = readFile(inputFile);

        // Построение частотной таблицы
        Map<Byte, Integer> frequencyMap = buildFrequencyMap(fileData);

        // Построение дерева Хаффмана
        root = buildHuffmanTree(frequencyMap);

        // Генерация кодов
        generateCodes(root, "");

        // Кодирование данных
        String encodedBits = encodeData(fileData);
        byte[] encodedBytes = bitsToBytes(encodedBits);

        // Запись в файл
        writeEncodedFile(outputFile, frequencyMap, encodedBytes, encodedBits.length());
    }

    // Декодирование файла
    public void decode(String inputFile, String outputFile) throws IOException {
        // Чтение закодированного файла
        DataInputStream dis = new DataInputStream(new FileInputStream(inputFile));

        // Чтение частотной таблицы
        int mapSize = dis.readInt();
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < mapSize; i++) {
            byte b = dis.readByte();
            int freq = dis.readInt();
            frequencyMap.put(b, freq);
        }

        // Чтение количества битов данных
        int bitCount = dis.readInt();

        // Чтение закодированных данных
        byte[] encodedData = new byte[dis.available()];
        dis.readFully(encodedData);
        dis.close();

        // Восстановление дерева Хаффмана
        root = buildHuffmanTree(frequencyMap);

        // Декодирование данных
        String bitString = bytesToBits(encodedData, bitCount);
        byte[] decodedData = decodeData(bitString);

        // Запись декодированного файла
        writeFile(outputFile, decodedData);
    }

    // Вспомогательные методы
    private byte[] readFile(String filename) throws IOException {
        File file = new File(filename);
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        fis.close();
        return data;
    }

    private void writeFile(String filename, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(data);
        fos.close();
    }

    private Map<Byte, Integer> buildFrequencyMap(byte[] data) {
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (byte b : data) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }
        return frequencyMap;
    }

    private HuffmanNode buildHuffmanTree(Map<Byte, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        // Создание листьев для каждого символа
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Построение дерева
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency, left, right);
            pq.offer(parent);
        }

        return pq.poll();
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            huffmanCodes.put(node.data, code);
        } else {
            generateCodes(node.left, code + "0");
            generateCodes(node.right, code + "1");
        }
    }

    private String encodeData(byte[] data) {
        StringBuilder encoded = new StringBuilder();
        for (byte b : data) {
            encoded.append(huffmanCodes.get(b));
        }
        return encoded.toString();
    }

    private byte[] decodeData(String bitString) {
        List<Byte> decoded = new ArrayList<>();
        HuffmanNode current = root;

        for (char bit : bitString.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.isLeaf()) {
                decoded.add(current.data);
                current = root;
            }
        }

        // Конвертация списка в массив
        byte[] result = new byte[decoded.size()];
        for (int i = 0; i < decoded.size(); i++) {
            result[i] = decoded.get(i);
        }
        return result;
    }

    private byte[] bitsToBytes(String bits) {
        int byteCount = (bits.length() + 7) / 8;
        byte[] bytes = new byte[byteCount];

        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                bytes[i / 8] |= (1 << (7 - (i % 8)));
            }
        }

        return bytes;
    }

    private String bytesToBits(byte[] bytes, int bitCount) {
        StringBuilder bits = new StringBuilder();

        for (int i = 0; i < bitCount; i++) {
            int byteIndex = i / 8;
            int bitIndex = 7 - (i % 8);
            boolean isSet = (bytes[byteIndex] & (1 << bitIndex)) != 0;
            bits.append(isSet ? '1' : '0');
        }

        return bits.toString();
    }

    private void writeEncodedFile(String filename, Map<Byte, Integer> frequencyMap,
                                  byte[] encodedData, int bitCount) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));

        // Запись частотной таблицы
        dos.writeInt(frequencyMap.size());
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            dos.writeByte(entry.getKey());
            dos.writeInt(entry.getValue());
        }

        // Запись количества битов
        dos.writeInt(bitCount);

        // Запись закодированных данных
        dos.write(encodedData);
        dos.close();
    }

    // Главный метод для работы из командной строки
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Использование:");
            System.out.println("  Кодирование: java HuffmanCoder encode <входной_файл> <выходной_файл>");
            System.out.println("  Декодирование: java HuffmanCoder decode <входной_файл> <выходной_файл>");
            return;
        }

        String operation = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        HuffmanCoder coder = new HuffmanCoder();

        try {
            if ("encode".equals(operation)) {
                coder.encode(inputFile, outputFile);
                System.out.println("Файл успешно закодирован: " + outputFile);
            } else if ("decode".equals(operation)) {
                coder.decode(inputFile, outputFile);
                System.out.println("Файл успешно декодирован: " + outputFile);
            } else {
                System.out.println("Неизвестная операция: " + operation);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
