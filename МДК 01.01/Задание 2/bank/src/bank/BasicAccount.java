package bank;

public class BasicAccount extends Account {
    public BasicAccount(String name) {
        super(name);
    }

    public double calculateCashback(double sum) {
        if (sum >= 10000) return sum * 0.01;
        return 0;
    }

    public void chargeMonthlyFee() {
        if (balance < 100) {
            throw new IllegalStateException("Нет денег на комиссию");
        }
        balance -= 100;
    }
}