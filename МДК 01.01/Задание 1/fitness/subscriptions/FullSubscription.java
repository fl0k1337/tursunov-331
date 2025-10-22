package fitness.subscriptions;

import java.time.LocalDate;
import java.time.LocalTime;
import fitness.club.Zone;
import fitness.members.Member;

public class FullSubscription extends Subscription {
    public FullSubscription(Member owner, LocalDate endDate) {
        super(owner, endDate);
    }

    @Override
    public boolean allowsZone(Zone z) {
        return z == Zone.GYM || z == Zone.GROUP || z == Zone.POOL;
    }

    @Override
    public LocalTime getStartTime() { return LocalTime.of(8, 0); }
    @Override
    public LocalTime getEndTime() { return LocalTime.of(22, 0); }
}