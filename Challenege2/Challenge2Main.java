package com.app.Challenege2;

import java.util.ArrayList;

public class Challenge2Main {
    public static void main(String[] args) {
        ArrayList<Mappable> mappables = new ArrayList<>();

        mappables.add(new Building("Tallinna Raekoda", UsageType.GOVERNMENT));
        mappables.add(new Building("Sakala keskus", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Kalevi Keskstaadion", UsageType.SPORTS));
        mappables.add(new UtilityLine("Tallinna Teletorn", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Ülemiste järv", UtilityType.WATER));

        for (var m : mappables) {
            Mappable.mapIt(m);
        }
    }
}
