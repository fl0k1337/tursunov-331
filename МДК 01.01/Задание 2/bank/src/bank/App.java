package bank;

import java.util.ArrayList;

public class App {
    public void run() {
        var accounts = new ArrayList<Account>();

        for (int i = 1; i <= 5; i++) accounts.add(new BasicAccount("Баз " + i));
        for (int i = 1; i <= 5; i++) accounts.add(new PremiumAccount("Прем " + i));
        for (int i = 1; i <= 5; i++) accounts.add(new VIPAccount("VIP " + i));

        for (var a : accounts) a.deposit(20000);

        accounts.get(0).payService(10000);
        accounts.get(5).payService(12000);
        accounts.get(10).payService(8000);

        accounts.get(0).transfer(accounts.get(1), 500);

        for (int i = 0; i < 5; i++) accounts.get(i).chargeMonthlyFee();

        for (var a : accounts) System.out.println(a);
    }
}