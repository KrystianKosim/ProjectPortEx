package projekt.model;

import projekt.model.konteners.KontenerPrimary;

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
            listOfKonteners.add(kontener);
        } else {
            System.err.println("Magazyn jest pełny!");
        }
    }

    public static void showWarehouses() {
        for (int i = 0; i < warehouseList.size(); i++) {
            System.out.println(i + " - " + warehouseList.get(i));
        }
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
