package projekt.model;

import projekt.Main;
import projekt.model.konteners.KontenerPrimary;
import projekt.threads.RailwayWagonThread;

import java.util.ArrayList;
import java.util.List;

public class RailwayWagon {
    private static List<KontenerPrimary> listOfKonteners = new ArrayList<>();
    private static int maxKonteners = 10;

    public static void addKontenerToWagon(KontenerPrimary kontener) {
        if (isFreePlaceOnWagon()) {
            listOfKonteners.add(kontener);
        } else {
            System.err.println("Oczekiwanie na odjazd zaladowanego wagonu");
            /**
             * utworzenie obiektu klasy RailwayWagonThread oraz ustawienie czasu oczekiwania na odjazd wagonu na 30 sekund
             */
            listOfKonteners.removeAll(listOfKonteners);
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
        if (!listOfKonteners.isEmpty()) {
            for (int i = 0; i < listOfKonteners.size(); i++) {
                System.out.println(i + " " + listOfKonteners.get(i));
            }
        } else {
            System.err.println("Wagon jest pusty" + "\n");
            Main.menu();
        }
    }

    private static boolean isFreePlaceOnWagon() {
        return listOfKonteners.size() < maxKonteners;
    }
}
