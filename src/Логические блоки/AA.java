public class AA {
    {
        System.out.println("logic (1) id= " + this.id);  // 0 (значение по умолчанию)
    }

    static {
        System.out.println("static logic");              // Выполняется ПЕРВЫМ!
    }

    private int id = 1;  // Инициализация ПОЗЖЕ

    public AA(int id) {
        this.id = id;  // 100
        System.out.println("ctor id= " + id);
    }

    {
        System.out.println("logic (2) id= " + id);       // 1 (поле уже инициализировано)
    }
}

class Mainn {
    public static void main(String[] args) {
        System.out.println("=== Создание new A(100) ===");
        new AA(100);
    }
}
