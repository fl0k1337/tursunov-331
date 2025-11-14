package bank;

import java.util.Random;

public abstract class Account {
    protected String fullName;
    protected String accountNumber;
    protected double balance;
    protected boolean isFirstPaymentDone;
    private static Random rand = new Random();

    public Account(String fullName) {
        this.fullName = fullName;
        this.accountNumber = generateRandomAccountNumber();
        this.balance = 0.0;
        this.isFirstPaymentDone = false;
    }

    private String generateRandomAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        if (balance < amount) {
            throw new IllegalStateException("Недостаточно средств");
        }
        balance -= amount;
    }

    public void transfer(Account to, double amount) {
        withdraw(amount);
        to.deposit(amount);
    }

    public void payService(double amount) {
        withdraw(amount);
        double cashback = calculateCashback(amount);
        balance += cashback;
        if (!isFirstPaymentDone) {
            balance += 1000;
            isFirstPaymentDone = true;
        }
    }

    public abstract double calculateCashback(double amount);
    public abstract void chargeMonthlyFee();

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return fullName + " | Счёт: " + accountNumber + " | Баланс: " + balance;
    }
}