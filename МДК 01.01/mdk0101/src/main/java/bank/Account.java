package bank;

public class Account {
    public String num, name, type;
    public double balance;
    public boolean first;

    public Account(String num, String name, double balance, String type, boolean first) {
        this.num = num; this.name = name; this.balance = balance; this.type = type; this.first = first;
    }
}