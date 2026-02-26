package fitness;

import java.time.LocalTime;

public class FitnessService {
    public static String canEnter(String name, String type, String zone) {
        int h = LocalTime.now().getHour();
        if (h < 8 || h >= 22) return "Закрыто";
        if (type.equals("дневной")) {
            if (h >= 16) return "После 16:00 нельзя";
            if (zone.equals("бассейн")) return "Нет доступа в бассейн";
        }
        if (type.equals("разовый") && zone.equals("групповые")) return "Нет доступа";
        return name + " зашел в " + zone;
    }
}