package projekt.model;

import projekt.Main;
import projekt.model.konteners.ContainerPrimary;
import projekt.threads.RailwayWagonThread;

import java.util.ArrayList;
import java.util.List;

public class RailwayWagon {
    private static List<ContainerPrimary> listOfContainers = new ArrayList<>();
    private static int maxContainers = 10;

    public static void addContainerToWagon(ContainerPrimary container) {
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
        return listOfContainers.size() < maxContainers;
    }
}
