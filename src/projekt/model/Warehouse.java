package projekt.model;

import projekt.model.konteners.ContainerExplosiveMaterials;
import projekt.model.konteners.ContainerPrimary;
import projekt.model.konteners.ContainerToxicLiquidMaterials;
import projekt.model.konteners.ContainerToxicLooseMaterials;
import projekt.threads.ContainerTimer;
import projekt.threads.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Warehouse {
    private String city;
    private int maxContainers;
    private int warehouseId;
    private static int warehousesId = 0;
    private List<ContainerPrimary> listOfContainers;
    private static List<Warehouse> warehouseList = new ArrayList<>();


    public Warehouse(String city, int maxContainers) {
        this.city = city;
        this.maxContainers = maxContainers;
        warehouseId = warehousesId;
        listOfContainers = new ArrayList<>();
        warehouseList.add(this);
        warehousesId++;
    }

    public static void chooseWarehouseToAddContainer(ContainerPrimary container) {
        showWarehouses();
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        while (!(decisionVariable >= 0 && decisionVariable < warehouseList.size())) {
            System.out.println("Bledne numer magazynu, wybierz ponownie:");
            showWarehouses();
            decisionVariable = scan.nextInt();
        }
        warehouseList.get(decisionVariable).addContainerToWarehouse(container);
    }

    public void addContainerToWarehouse(ContainerPrimary container) {
        if (listOfContainers.size() < maxContainers) {
            if (container.getSender().getWarnings() <= 3) {
                addContainerAndStartThread(container);
            } else {
                System.err.println('\n' + "Nie przyjmuje towaru, nadawca ma zbyt duzo ostrzezen!");
            }
        } else {
            System.err.println('\n' + "Magazyn jest pełny!");
        }
    }

    private void addContainerAndStartThread(ContainerPrimary container) {
        if (container instanceof ContainerExplosiveMaterials) {
            ContainerTimer containerTimer = new ContainerTimer(container, 5, this);
            Timer.addContainer(containerTimer);
            listOfContainers.add(container);
        } else if (container instanceof ContainerToxicLiquidMaterials) {
            ContainerTimer containerTimer = new ContainerTimer(container, 10, this);
            Timer.addContainer(containerTimer);
            listOfContainers.add(container);
        } else if (container instanceof ContainerToxicLooseMaterials) {
            ContainerTimer containerTimer = new ContainerTimer(container, 15, this);
            Timer.addContainer(containerTimer);
            listOfContainers.add(container);
        } else {
            listOfContainers.add(container);
        }
    }

    public static void showWarehouses() {
        for (int i = 0; i < warehouseList.size(); i++) {
            System.out.println(i + " - " + warehouseList.get(i));
        }
    }

    public List<ContainerPrimary> getListOfContainers() {
        return listOfContainers;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "maxKonteners=" + maxContainers +
                ", warehouseId=" + warehouseId +
                ", konteners=" + listOfContainers.size() +
                '}';
    }
}
