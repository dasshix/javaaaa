// ПРАКТИКА #1: Интерфейс для банковских операций
interface BankAccount {
    double calculateInterest(double principal);

    default void printStatement() {
        System.out.println("Выписка по счету сформирована");
    }

    static double getTaxRate() {
        return 0.13;
    }

    default void closeAccount() {
        System.out.println("Счет закрыт по умолчанию");
    }
}

class SavingsAccount implements BankAccount {
    private String accountNumber;

    public SavingsAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public double calculateInterest(double principal) {
        return principal * 0.05;
    }

    @Override
    public void printStatement() {
        System.out.println("Выписка сберегательного счета " + accountNumber);
    }
}

class CreditAccount implements BankAccount {
    @Override
    public double calculateInterest(double principal) {
        return principal * 0.15;
    }
}

// ПРАКTIКА #2: ИСПРАВЛЕННЫЙ конфликт
interface OnlinePayment {
    void processPayment(double amount);

    default String getStatus() {
        return "Оплата обработана через онлайн-банк";
    }
}

interface TerminalPayment {
    void processPayment(double amount);

    default String getStatus() {
        return "Оплата через терминал";
    }
}

class UniversalPayment implements OnlinePayment, TerminalPayment {
    private double amount;

    public UniversalPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Обработка платежа: " + amount + " руб.");
    }

    @Override
    public String getStatus() {
        return "Гибридная оплата: " + amount + " руб.";
    }
}

public class BankInterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Банковские операции ===");
        System.out.println("Налоговая ставка: " + BankAccount.getTaxRate());

        BankAccount savings = new SavingsAccount("SAV-12345");
        BankAccount credit = new CreditAccount();

        System.out.println("\n--- Сберегательный счет ---");
        System.out.println("Процент по 10000: " + savings.calculateInterest(10000));
        savings.printStatement();
        savings.closeAccount();

        System.out.println("\n--- Кредитный счет ---");
        System.out.println("Процент по 5000: " + credit.calculateInterest(5000));
        credit.printStatement();
        credit.closeAccount();

        System.out.println("\n=== ПРАКТИКА #2: ИСПРАВЛЕННЫЙ конфликт ===");
        UniversalPayment up = new UniversalPayment(1000);
        
        System.out.println("\nРЕШЕНИЕ 1: ЯВНЫЙ ВЫБОР через приведение типа");
        OnlinePayment online = up;           // Приведение к OnlinePayment
        TerminalPayment terminal = up;       // Приведение к TerminalPayment
        System.out.println("Онлайн статус: " + online.getStatus());
        System.out.println("Терминал статус: " + terminal.getStatus());

        System.out.println("\nРЕШЕНИЕ 2: Собственное переопределение");
        System.out.println("Универсальный статус: " + up.getStatus());
    }
}
