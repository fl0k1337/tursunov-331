package bank;

public class VIPAccount extends Account {
    public VIPAccount(String name) {
        super(name);
    }

    public double calculateCashback(double sum) {
        if (sum >= 100000) return sum * 0.10;
        if (sum >= 10000) return sum * 0.05;
        return sum * 0.01;
    }

    public void chargeMonthlyFee() {}
}