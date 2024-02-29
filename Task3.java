import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully. New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully. New Balance: $" + balance);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayOptions() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option, double amount) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                userAccount.deposit(amount);
                break;
            case 3:
                userAccount.withdraw(amount);
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + userAccount.getBalance());
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayOptions();

            System.out.print("Enter your choice (1-4): ");
            int option = scanner.nextInt();

            if (option == 4) {
                System.out.println("Exiting. Thank you!");
                break;
            }

            if (option >= 1 && option <= 3) {
                System.out.print("Enter amount: $");
                double amount = scanner.nextDouble();

                if (amount < 0) {
                    System.out.println("Invalid amount. Please enter a positive value.");
                    continue;
                }

                atm.performTransaction(option, amount);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

