package fitness.subscriptions;

import java.time.LocalDate;
import java.time.LocalTime;
import fitness.club.Zone;
import fitness.members.Member;

public class SingleDaySubscription extends Subscription {
    public SingleDaySubscription(Member owner) {
        super(owner, LocalDate.now());
    }

    @Override
    public boolean allowsZone(Zone z) {
        return z == Zone.POOL || z == Zone.GYM;
    }

    @Override
    public LocalTime getStartTime() { return LocalTime.of(8, 0); }
    @Override
    public LocalTime getEndTime() { return LocalTime.of(22, 0); }
}
