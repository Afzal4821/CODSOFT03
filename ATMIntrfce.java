import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) { this.balance = initialBalance; }

    public double getBalance() { return balance; }

    public boolean deposit(double amount) {
        if (amount > 0) { balance += amount; return true; }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) { balance -= amount; return true; }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) { this.account = account; }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit\nChoose: ");
            int choice = scanner.nextInt();
            if (choice == 1) System.out.printf("Balance: $%.2f\n", account.getBalance());
            else if (choice == 2) {
                System.out.print("Deposit amount: ");
                System.out.println(account.deposit(scanner.nextDouble()) ? "Deposit successful." : "Invalid amount.");
            } else if (choice == 3) {
                System.out.print("Withdraw amount: ");
                System.out.println(account.withdraw(scanner.nextDouble()) ? "Withdrawal successful." : "Insufficient balance or invalid amount.");
            } else if (choice == 4) { System.out.println("Goodbye!"); break; }
            else System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}

public class ATMIntrfce {
    public static void main(String[] args) {
        new ATM(new BankAccount(300.00)).run();
    }
}
