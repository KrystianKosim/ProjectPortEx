package projekt.services;

import projekt.Main;
import projekt.models.RailwayWagon;
import projekt.models.konteners.ContainerPrimary;
import projekt.threads.RailwayWagonThread;

import java.util.List;

public class RailwayWagonService {

    public static void addContainerToWagon(ContainerPrimary container) {
        List<ContainerPrimary> listOfContainers = RailwayWagon.getListOfContainers();
        if (isFreePlaceOnWagon()) {
            listOfContainers.add(container);
        } else {
            System.err.println("Oczekiwanie na odjazd zaladowanego wagonu");
            /**
             * utworzenie obiektu klasy RailwayWagonThread oraz ustawienie czasu oczekiwania na odjazd wagonu na 30 sekund
             */
            listOfContainers.removeAll(listOfContainers);
            RailwayWagonThread railwayWagonThread = new RailwayWagonThread(30);
            railwayWagonThread.start();
            try {
                railwayWagonThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void showKontenersInWagon() {
        List<ContainerPrimary> listOfContainers = RailwayWagon.getListOfContainers();
        if (!listOfContainers.isEmpty()) {
            for (int i = 0; i < listOfContainers.size(); i++) {
                System.out.println(i + " " + listOfContainers.get(i));
            }
        } else {
            System.err.println("Wagon jest pusty" + "\n");
            Main.menu();
        }
    }

    private static boolean isFreePlaceOnWagon() {
        List<ContainerPrimary> listOfContainers = RailwayWagon.getListOfContainers();
        int maxContainers = RailwayWagon.getMaxContainers();
        return listOfContainers.size() < maxContainers;
    }
}
