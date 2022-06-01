package projekt.model.konteners;

import projekt.model.RailwayWagon;
import projekt.model.Sender;
import projekt.model.Ship;
import projekt.model.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContainerPrimary {
    /**
     * name z String zmienione na Sender, zmienic metody tworzenia kontenerow
     */
    private final Sender sender;
    private final String homePort;
    private final double weightNetto;
    private final double tara;
    private final double weighBrutto;
    private final int containerID;
    private static int id = 0;
    private static final List<ContainerPrimary> containerPrimaryList = new ArrayList<>();

    protected ContainerPrimary(Sender sender, String homePort, double weightNetto, double tara) {
        this.sender = sender;
        this.homePort = homePort;
        this.weightNetto = weightNetto;
        this.tara = tara;
        weighBrutto = weightNetto + tara;
        containerID = id++;
        containerPrimaryList.add(this);
    }

    public static ContainerPrimary createContainerPrimary() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = Sender.chooseSenderToDo();
        System.out.println("Podaj port nadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        return new ContainerPrimary(sender, homePort, weightNetto, tara);
    }

    public static void chooseActionToDoOnNewContainer(ContainerPrimary container) {
        showLists(actionsToDoOnNewContainer());
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        switch (decisionVariable) {
            case 0:
                break;
            case 1:
                Ship.addContainerToShip(container);
                break;
            case 2:
                RailwayWagon.addContainerToWagon(container);
                break;
            case 3:
                Warehouse.chooseWarehouseToAddContainer(container);
                break;
        }
    }

    public static class Builder {
        private Sender sender;
        private String homePort;
        private double weightNetto;
        private double tara;

        public Builder sender(Sender sender) {
            this.sender = sender;
            return this;
        }

        public Builder homePort(String homePort) {
            this.homePort = homePort;
            return this;
        }

        public Builder weightNetto(double weightNetto) {
            this.weightNetto = weightNetto;
            return this;
        }

        public Builder tara(double tara) {
            this.tara = tara;
            return this;
        }

        public ContainerPrimary build() {
            return new ContainerPrimary(sender, homePort, weightNetto, tara);
        }
    }

    private static void showLists(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " - " + list.get(i) + "  ");
        }
    }

    private static List<String> actionsToDoOnNewContainer() {
        List<String> list = new ArrayList<>();
        list.add("Wyjdz");
        list.add("Zaladuj kontener na statek");
        list.add("Zaladuj kontener na wagon");
        list.add("Zaladuj kontener do magazynu");
        return list;
    }


    public String getHomePort() {
        return homePort;
    }

    public double getWeightNetto() {
        return weightNetto;
    }

    public double getTara() {
        return tara;
    }

    public int getContainerID() {
        return containerID;
    }

    public double getWeighBrutto() {
        return weighBrutto;
    }

    public Sender getSender() {
        return sender;
    }

    public static List<ContainerPrimary> getContainerPrimaryList() {
        return containerPrimaryList;
    }

    @Override
    public String toString() {
        return "Kontener podstawowy{" + sender +
                ", port nadania: " + homePort +
                ", waga netto: " + weightNetto +
                ", tara: " + tara +
                ", waga brutto: " + weighBrutto +
                ", ID: " + containerID +
                '}';
    }
}
