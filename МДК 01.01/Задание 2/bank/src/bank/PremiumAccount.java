package bank;

public class PremiumAccount extends Account {
    public PremiumAccount(String name) {
        super(name);
    }

    public double calculateCashback(double sum) {
        if (sum >= 10000) return sum * 0.05;
        return 0;
    }

    public void chargeMonthlyFee() {}
}