package fitness.subscriptions;


import java.time.LocalDate;
import java.time.LocalTime;
import fitness.club.Zone;
import fitness.members.Member;

public class DaytimeSubscription extends Subscription {
    public DaytimeSubscription(Member owner, LocalDate endDate) {
        super(owner, endDate);
    }

    @Override
    public boolean allowsZone(Zone z) {
        return z == Zone.GYM || z == Zone.GROUP;
    }

    @Override
    public LocalTime getStartTime() { return LocalTime.of(8, 0); }
    @Override
    public LocalTime getEndTime() { return LocalTime.of(16, 0); }
}
