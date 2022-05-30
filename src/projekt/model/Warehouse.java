package projekt.model;

import projekt.model.konteners.KontenerExplosiveMaterials;
import projekt.model.konteners.KontenerPrimary;
import projekt.model.konteners.KontenerToxicLiquidMaterials;
import projekt.model.konteners.KontenerToxicLooseMaterials;
import projekt.threads.KontenerTimer;
import projekt.threads.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Warehouse {
    private String city;
    private int maxKonteners;
    private int warehouseId;
    private static int warehousesId = 0;
    private List<KontenerPrimary> listOfKonteners;
    private static List<Warehouse> warehouseList = new ArrayList<>();


    public Warehouse(String city, int maxKonteners) {
        this.city = city;
        this.maxKonteners = maxKonteners;
        warehouseId = warehousesId;
        listOfKonteners = new ArrayList<>();
        warehouseList.add(this);
        warehousesId++;
    }

    public static void chooseWarehouseToAddKontener(KontenerPrimary kontener) {
        showWarehouses();
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        while (!(decisionVariable >= 0 && decisionVariable < warehouseList.size())) {
            System.out.println("Bledne numer magazynu, wybierz ponownie:");
            showWarehouses();
            decisionVariable = scan.nextInt();
        }
        warehouseList.get(decisionVariable).addKontenerToWarehouse(kontener);
    }

    public void addKontenerToWarehouse(KontenerPrimary kontener) {
        if (listOfKonteners.size() < maxKonteners) {
            if (kontener.getSender().getWarnings() <= 3) {
                addKontenerAndStartThread(kontener);
            } else {
                System.err.println('\n' + "Nie przyjmuje towaru, nadawca ma zbyt duzo ostrzezen!");
            }
        } else {
            System.err.println('\n' + "Magazyn jest pełny!");
        }
    }

    private void addKontenerAndStartThread(KontenerPrimary kontener) {
        if (kontener instanceof KontenerExplosiveMaterials) {
            KontenerTimer kontenerTimer = new KontenerTimer(kontener, 2, this);
            Timer.addKontener(kontenerTimer);
            listOfKonteners.add(kontener);
        } else if (kontener instanceof KontenerToxicLiquidMaterials) {
            KontenerTimer kontenerTimer = new KontenerTimer(kontener, 10, this);
            Timer.addKontener(kontenerTimer);
            listOfKonteners.add(kontener);
        } else if (kontener instanceof KontenerToxicLooseMaterials) {
            KontenerTimer kontenerTimer = new KontenerTimer(kontener, 15, this);
            Timer.addKontener(kontenerTimer);
            listOfKonteners.add(kontener);
        } else {
            listOfKonteners.add(kontener);
        }
    }

    public static void showWarehouses() {
        for (int i = 0; i < warehouseList.size(); i++) {
            System.out.println(i + " - " + warehouseList.get(i));
        }
    }

    public List<KontenerPrimary> getListOfKonteners() {
        return listOfKonteners;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "maxKonteners=" + maxKonteners +
                ", warehouseId=" + warehouseId +
                ", konteners=" + listOfKonteners.size() +
                '}';
    }
}
