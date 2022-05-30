package projekt.threads;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Timer extends Thread {

    private static LocalDate dateInProgram = LocalDate.now();
    private static List<KontenerTimer> activeKonteners = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            try {
                sleep(10000);
                dateInProgram = dateInProgram.plusDays(1);
                chceckKonteners();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void chceckKonteners() {
        List<KontenerTimer> kontenersToRemove = new ArrayList<>();
        for (KontenerTimer kontener : activeKonteners) {
            if (kontener.getDeadline().equals(dateInProgram)) {
                kontenersToRemove.add(kontener);
            }
        }
        if (!kontenersToRemove.isEmpty()) {
            removeAllKontenersFromList(kontenersToRemove);
        }
    }

    private static void removeAllKontenersFromList(List<KontenerTimer> kontenersToRemove) {
        for (KontenerTimer kontener : kontenersToRemove) {
            kontener.remove();
        }
        System.err.println("Dzis " + dateInProgram + " usunieto " + kontenersToRemove.size() + " kontenerow");
        activeKonteners.removeAll(kontenersToRemove);
    }


    public static void addKontener(KontenerTimer kontenerTimer) {
        activeKonteners.add(kontenerTimer);
    }

    public static LocalDate getDateInProgram() {
        return dateInProgram;
    }
}
