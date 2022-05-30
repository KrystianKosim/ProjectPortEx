package projekt.model.konteners;

import projekt.model.RailwayWagon;
import projekt.model.Sender;
import projekt.model.Ship;
import projekt.model.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KontenerPrimary {
    /**
     * name z String zmienione na Sender, zmienic metody tworzenia kontenerow
     */
    private Sender sender;
    private String homePort;
    private double weightNetto;
    private double tara;
    private double weighBrutto;
    private int kontenerID;
    private static int id = 0;
    private static List<KontenerPrimary> kontenerPrimaryList = new ArrayList<>();

    public KontenerPrimary(Sender sender, String homePort, double weightNetto, double tara) {
        this.sender = sender;
        this.homePort = homePort;
        this.weightNetto = weightNetto;
        this.tara = tara;
        weighBrutto = weightNetto + tara;
        kontenerID = id++;
        kontenerPrimaryList.add(this);
    }


    public static KontenerPrimary createKontenerPrimary() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = Sender.chooseSenderToDo();
        System.out.println("Podaj port nadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        return new KontenerPrimary(sender, homePort, weightNetto, tara);
    }

    public static void chooseActionToDoOnNewKontener(KontenerPrimary kontener) {
        showLists(actionsToDoOnNewKontener());
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        switch (decisionVariable) {
            case 0:
                break;
            case 1:
                Ship.addKontenerToShip(kontener);
                break;
            case 2:
                RailwayWagon.addKontenerToWagon(kontener);
                break;
            case 3:
                Warehouse.chooseWarehouseToAddKontener(kontener);
                break;
        }
    }

    private static void showLists(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " - " + list.get(i) + "  ");
        }
    }

    private static List<String> actionsToDoOnNewKontener() {
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

    public int getKontenerID() {
        return kontenerID;
    }

    public double getWeighBrutto() {
        return weighBrutto;
    }

    public Sender getSender() {
        return sender;
    }

    public static List<KontenerPrimary> getKontenerPrimaryList() {
        return kontenerPrimaryList;
    }

    @Override
    public String toString() {
        return "Kontener podstawowy{" +
                sender +
                ", port nadania: " + homePort +
                ", waga netto: " + weightNetto +
                ", tara: " + tara +
                ", waga brutto: " + weighBrutto +
                ", ID: " + kontenerID +
                '}';
    }
}
