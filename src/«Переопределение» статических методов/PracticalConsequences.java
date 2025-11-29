public class PracticalConsequences {
    public static void main(String[] args) {
        System.out.println("=== Практические следствия ===\n");

        Database db = new MySQLDatabase();

        System.out.println("1. Неправильно - статический метод:");
        db.connect(); // Вызовет Database.connect() - ОШИБКА!

        System.out.println("\n2. Правильно - через класс:");
        MySQLDatabase.connect(); // Вызовет MySQLDatabase.connect()

        System.out.println("\n3. Экземплярный метод работает правильно:");
        db.executeQuery("SELECT * FROM users"); // Вызовет MySQLDatabase.executeQuery()
    }
}

class Database {
    public static void connect() {
        System.out.println("Подключение к базе данных...");
    }

    public void executeQuery(String query) {
        System.out.println("Выполняю запрос: " + query);
    }
}

class MySQLDatabase extends Database {
    public static void connect() {
        System.out.println("Подключение к MySQL...");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Выполняю MySQL запрос: " + query);
    }
}