package projekt.generators;

import projekt.model.RailwayWagon;
import projekt.model.konteners.ContainerPrimary;

import java.util.List;

public class RailwayWagonGenerator {
    public static void railwayWagnosGenerator() {
        List<ContainerPrimary> list = ContainerPrimary.getContainerPrimaryList();

        RailwayWagon.addContainerToWagon(list.get(0));
        RailwayWagon.addContainerToWagon(list.get(1));
        RailwayWagon.addContainerToWagon(list.get(2));
        RailwayWagon.addContainerToWagon(list.get(0));
        RailwayWagon.addContainerToWagon(list.get(0));
        RailwayWagon.addContainerToWagon(list.get(3));
        RailwayWagon.addContainerToWagon(list.get(1));
        RailwayWagon.addContainerToWagon(list.get(4));
        RailwayWagon.addContainerToWagon(list.get(5));
        RailwayWagon.addContainerToWagon(list.get(6));
    }
}
