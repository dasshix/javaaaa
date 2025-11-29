// ПРАКТИКА #1: Собственный класс исключения InsufficientFundsException
public class InsufficientFundsException extends Exception {
    private final double attemptedAmount;
    private final double currentBalance;

    // 1. Конструктор без аргументов (стандартный)
    public InsufficientFundsException() {
        super("Недостаточно средств на счете");
        this.attemptedAmount = 0.0;
        this.currentBalance = 0.0;
    }

    // 2. Конструктор с сообщением (основной)
    public InsufficientFundsException(String message) {
        super(message);
        this.attemptedAmount = 0.0;
        this.currentBalance = 0.0;
    }

    // 3. Конструктор с причиной (cause)
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
        this.attemptedAmount = 0.0;
        this.currentBalance = 0.0;
    }

    // 4. Полный конструктор с контекстом (дополнительные данные)
    public InsufficientFundsException(double attemptedAmount, double currentBalance) {
        super(String.format("Недостаточно средств! Запрошено: %.2f, На счете: %.2f",
                attemptedAmount, currentBalance));
        this.attemptedAmount = attemptedAmount;
        this.currentBalance = currentBalance;
    }

    // 5. Геттеры для дополнительной информации
    public double getAttemptedAmount() {
        return attemptedAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    // Переопределение toString() для детального вывода
    @Override
    public String toString() {
        return String.format("%s{запрошено=%.2f, баланс=%.2f}",
                super.toString(), attemptedAmount, currentBalance);
    }
}

// Демонстрация использования
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            // Генерация собственного исключения с контекстом
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
        System.out.println("✓ Снято: " + amount + ", Остаток: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

class CustomExceptionDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Собственное исключение InsufficientFundsException ===");

        BankAccount account = new BankAccount(1000.0);
        System.out.println("Начальный баланс: " + account.getBalance());

        try {
            // 1. Успешное снятие
            account.withdraw(300.0);

            // 2. Недостаточно средств - выброс исключения
            System.out.println("\nПопытка снять 800 руб. (баланс 700):");
            account.withdraw(800.0);

        } catch (InsufficientFundsException e) {
            System.out.println("\n✓ ПЕРЕХВАЧЕНО собственное исключение:");
            System.out.println("  Тип: " + e.getClass().getSimpleName());
            System.out.println("  Сообщение: " + e.getMessage());
            System.out.println("  Детали: " + e);
            System.out.println("  Баланс остался: " + account.getBalance());
        }

        System.out.println("\n=== ТЕСТИРОВАНИЕ КОНСТРУКТОРОВ ===");
        testAllConstructors();
    }

    static void testAllConstructors() {
        try {
            // Тест всех конструкторов
            throw new InsufficientFundsException();
        } catch (InsufficientFundsException e) {
            System.out.println("1. Пустой конструктор: " + e.getMessage());
        }

        try {
            throw new InsufficientFundsException("Кастомное сообщение");
        } catch (InsufficientFundsException e) {
            System.out.println("2. Сообщение: " + e.getMessage());
        }

        try {
            throw new InsufficientFundsException(500.0, 200.0);
        } catch (InsufficientFundsException e) {
            System.out.println("3. Контекст: " + e);
        }
    }
}
