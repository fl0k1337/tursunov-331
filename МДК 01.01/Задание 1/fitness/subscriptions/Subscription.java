package fitness.subscriptions;

import java.time.LocalDate;
import java.time.LocalTime;
import fitness.members.Member;
import fitness.club.Zone;

public abstract class Subscription {
    protected Member owner;
    protected LocalDate regDate;
    protected LocalDate endDate;

    public Subscription(Member owner, LocalDate endDate) {
        this.owner = owner;
        this.regDate = LocalDate.now();
        this.endDate = endDate;
    }

    public Member getOwner() { return owner; }
    public LocalDate getRegDate() { return regDate; }
    public LocalDate getEndDate() { return endDate; }

    public boolean isActive(LocalDate date) {
        return (date.isEqual(regDate) || date.isAfter(regDate))
                && (date.isEqual(endDate) || date.isBefore(endDate));
    }

    public abstract boolean allowsZone(Zone z);
    public abstract LocalTime getStartTime();
    public abstract LocalTime getEndTime();
}
