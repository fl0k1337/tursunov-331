package fitness.club;

import java.time.LocalDate;
import java.time.LocalTime;
import fitness.members.Member;
import fitness.subscriptions.*;

public class Main {
    public static void main(String[] args) {
        Member m1 = new Member("Иван", "Иванов", 1995);
        Member m2 = new Member("Пётр", "Петров", 2000);

        Subscription s1 = new SingleDaySubscription(m1);
        Subscription s2 = new DaytimeSubscription(m2, LocalDate.now().plusMonths(1));

        FitnessClub club = new FitnessClub();

        club.enterZone(s1, Zone.POOL, LocalDate.now(), LocalTime.of(9, 0));
        club.enterZone(s2, Zone.POOL, LocalDate.now(), LocalTime.of(10, 0));
        club.enterZone(s2, Zone.GYM, LocalDate.now(), LocalTime.of(15, 0));
        club.enterZone(s2, Zone.GYM, LocalDate.now(), LocalTime.of(17, 0));

        club.closeClub();
    }
}