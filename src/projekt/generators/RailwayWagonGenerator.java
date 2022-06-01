package projekt.generators;

import projekt.model.RailwayWagon;
import projekt.model.konteners.ContainerPrimary;

import java.util.List;

public class RailwayWagonGenerator {
    public static void railwayWagnosGenerator() {
        List<ContainerPrimary> listOfContainers = ContainerPrimary.getContainerPrimaryList();
        RailwayWagon.addContainerToWagon(listOfContainers.get(0));
        RailwayWagon.addContainerToWagon(listOfContainers.get(1));
        RailwayWagon.addContainerToWagon(listOfContainers.get(2));
        RailwayWagon.addContainerToWagon(listOfContainers.get(0));
        RailwayWagon.addContainerToWagon(listOfContainers.get(0));
        RailwayWagon.addContainerToWagon(listOfContainers.get(3));
        RailwayWagon.addContainerToWagon(listOfContainers.get(1));
        RailwayWagon.addContainerToWagon(listOfContainers.get(4));
        RailwayWagon.addContainerToWagon(listOfContainers.get(5));
        RailwayWagon.addContainerToWagon(listOfContainers.get(6));
    }
}
