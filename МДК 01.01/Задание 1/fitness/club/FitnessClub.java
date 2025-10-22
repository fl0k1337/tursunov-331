package fitness.club;


import java.time.LocalDate;
import java.time.LocalTime;
import fitness.subscriptions.Subscription;

public class FitnessClub {
    private static final int CAPACITY_GYM = 100;
    private static final int CAPACITY_POOL = 50;
    private static final int CAPACITY_GROUP = 50;

    private Subscription[] gymRegistered = new Subscription[CAPACITY_GYM];
    private int gymCount = 0;

    private Subscription[] poolRegistered = new Subscription[CAPACITY_POOL];
    private int poolCount = 0;

    private Subscription[] groupRegistered = new Subscription[CAPACITY_GROUP];
    private int groupCount = 0;

    private boolean contains(Subscription[] arr, int count, Subscription s) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == s) return true;
        }
        return false;
    }

    private boolean addToArray(Subscription[] arr, int capacity, int[] countRef, Subscription s) {
        int count = countRef[0];
        if (contains(arr, count, s)) return true;
        if (count >= capacity) return false;
        arr[count] = s;
        countRef[0] = count + 1;
        return true;
    }

    public boolean registerToZone(Subscription s, Zone z) {
        LocalDate today = LocalDate.now();
        if (!s.isActive(today)) return false;
        if (!s.allowsZone(z)) return false;

        int[] ref;
        boolean ok;
        switch (z) {
            case GYM:
                ref = new int[]{gymCount};
                ok = addToArray(gymRegistered, CAPACITY_GYM, ref, s);
                gymCount = ref[0];
                return ok;
            case POOL:
                ref = new int[]{poolCount};
                ok = addToArray(poolRegistered, CAPACITY_POOL, ref, s);
                poolCount = ref[0];
                return ok;
            case GROUP:
                ref = new int[]{groupCount};
                ok = addToArray(groupRegistered, CAPACITY_GROUP, ref, s);
                groupCount = ref[0];
                return ok;
        }
        return false;
    }

    public boolean enterZone(Subscription s, Zone z, LocalDate date, LocalTime time) {
        if (!s.isActive(date)) {
            System.out.println("Абонемент не активен: " + s.getOwner());
            return false;
        }
        if (!s.allowsZone(z)) {
            System.out.println("Доступ в зону запрещён по абонементу: " + z);
            return false;
        }
        LocalTime start = s.getStartTime();
        LocalTime end = s.getEndTime();
        if (time.isBefore(start) || time.isAfter(end)) {
            System.out.println("Нельзя посещать в это время. Часы: " + start + " - " + end);
            return false;
        }

        if (!registerToZone(s, z)) {
            System.out.println("Не удалось зарегистрировать в зоне: " + z);
            return false;
        }

        System.out.println(s.getOwner() + " вошёл в: " + z + " в " + time);
        return true;
    }

    public void closeClub() {
        System.out.println("Клуб закрывается. Все клиенты покидают зоны.");
        for (int i = 0; i < gymCount; i++) gymRegistered[i] = null;
        for (int i = 0; i < poolCount; i++) poolRegistered[i] = null;
        for (int i = 0; i < groupCount; i++) groupRegistered[i] = null;
        gymCount = poolCount = groupCount = 0;
    }
}
