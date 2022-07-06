package projekt.threads;

import projekt.models.Ship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Timer extends Thread {

    private static LocalDate dateInProgram = LocalDate.now();
    private static final List<ContainerTimer> activeContainers = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
                dateInProgram = dateInProgram.plusDays(1);
                chceckContainers();
                checkShips();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkShips() {
        List<Ship> shipList = Ship.getShipList();
        for (Ship ship : shipList) {
            if (ship.getTimeOfReturnToPort() != null) {
                if (ship.getTimeOfReturnToPort().equals(dateInProgram)) {
                    ship.setInPort(true);
                    ship.setTimeOfReturnToPort(null);
                }
            }
        }
    }

    public static void chceckContainers() {
        List<ContainerTimer> containersToRemove = new ArrayList<>();
        for (ContainerTimer container : activeContainers) {
            if (container.getDeadline().equals(dateInProgram)) {
                containersToRemove.add(container);
            }
        }
        if (!containersToRemove.isEmpty()) {
            removeAllContainersFromList(containersToRemove);
        }
    }

    private static void removeAllContainersFromList(List<ContainerTimer> containersToRemove) {
        for (ContainerTimer container : containersToRemove) {
            container.remove();
        }
        System.err.println("Dzis " + dateInProgram + " usunieto " + containersToRemove.size() + " kontenerow");
        activeContainers.removeAll(containersToRemove);
    }


    public static void addContainer(ContainerTimer containerTimer) {
        activeContainers.add(containerTimer);
    }

    public static LocalDate getDateInProgram() {
        return dateInProgram;
    }
}
