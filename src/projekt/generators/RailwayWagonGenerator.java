package projekt.generators;

import projekt.model.RailwayWagon;
import projekt.model.konteners.KontenerPrimary;

import java.util.List;

public class RailwayWagonGenerator {
    public static void railwayWagnosGenerator() {
        List<KontenerPrimary> list = KontenerPrimary.getKontenerPrimaryList();

        RailwayWagon.addKontenerToWagon(list.get(0));
        RailwayWagon.addKontenerToWagon(list.get(1));
        RailwayWagon.addKontenerToWagon(list.get(2));
        RailwayWagon.addKontenerToWagon(list.get(0));
        RailwayWagon.addKontenerToWagon(list.get(0));
        RailwayWagon.addKontenerToWagon(list.get(3));
        RailwayWagon.addKontenerToWagon(list.get(1));
        RailwayWagon.addKontenerToWagon(list.get(4));
        RailwayWagon.addKontenerToWagon(list.get(5));
        RailwayWagon.addKontenerToWagon(list.get(6));
    }
}
