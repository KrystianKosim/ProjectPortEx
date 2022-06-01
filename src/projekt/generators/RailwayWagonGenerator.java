package projekt.generators;

import projekt.models.konteners.ContainerPrimary;
import projekt.services.RailwayWagonService;

import java.util.List;

public class RailwayWagonGenerator {
    public static void railwayWagnosGenerator() {
        List<ContainerPrimary> listOfContainers = ContainerPrimary.getContainerPrimaryList();
        RailwayWagonService.addContainerToWagon(listOfContainers.get(0));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(1));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(2));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(0));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(0));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(3));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(1));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(4));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(5));
        RailwayWagonService.addContainerToWagon(listOfContainers.get(6));
    }
}
