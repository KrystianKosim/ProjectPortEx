package main.java.projekt.services;

import main.java.projekt.models.Warehouse;
import main.java.projekt.models.konteners.ContainerExplosiveMaterials;
import main.java.projekt.models.konteners.ContainerPrimary;
import main.java.projekt.models.konteners.ContainerToxicLiquidMaterials;
import main.java.projekt.models.konteners.ContainerToxicLooseMaterials;
import main.java.projekt.threads.ContainerTimer;
import main.java.projekt.threads.Timer;

import java.util.List;
import java.util.Scanner;

public class WarehouseService {

    public static void showWarehouses() {
        System.out.println("Wybierz magazyn");
        List<Warehouse> warehouseList = Warehouse.getWarehouseList();
        for (int i = 0; i < warehouseList.size(); i++) {
            System.out.println(i + " - " + warehouseList.get(i));
        }
    }

    private static void showContainersInWarehouse(Warehouse warehouse) {
        System.out.println("Wybierz kontener");
        List<ContainerPrimary> listOfContainers = warehouse.getListOfContainers();
        for (int i = 0; i < listOfContainers.size(); i++) {
            System.out.println(i + " - " + listOfContainers.get(i));
        }
    }

    public static void chooseWarehouseToRemoveContainer() {
        List<Warehouse> warehouseList = Warehouse.getWarehouseList();
        if (!warehouseList.isEmpty()) {
            showWarehouses();
            Scanner scan = new Scanner(System.in);
            int indexOfWarehouse = scan.nextInt();
            while (!(indexOfWarehouse >= 0 && indexOfWarehouse < warehouseList.size())) {
                System.out.println("Bledne numer magazynu, wybierz ponownie:");
                showWarehouses();
                indexOfWarehouse = scan.nextInt();
            }
            Warehouse warehouse = warehouseList.get(indexOfWarehouse);
            if (!warehouse.getListOfContainers().isEmpty()) {
                System.out.println("Wybierz ktory kontener chcesz usunac");
                showContainersInWarehouse(warehouse);
                List<ContainerPrimary> listOfContainers = warehouse.getListOfContainers();
                int indexOfContainerToRemove = scan.nextInt();
                while (!(indexOfContainerToRemove >= 0 && indexOfContainerToRemove < listOfContainers.size())) {
                    System.out.println("Bledny numer kontenera, wybierz ponownie");
                    indexOfContainerToRemove = scan.nextInt();
                }
                ContainerPrimary containerToRemove = listOfContainers.get(indexOfContainerToRemove);
                listOfContainers.remove(indexOfContainerToRemove);
                System.out.println("Usunieto " + containerToRemove);
            } else {
                System.err.println("Magazyn jest pusty!");
            }
        } else {
            System.err.println("W tej chwili nie ma zadnych magazynow");
        }
    }

    public static void chooseWarehouseToAddContainer(ContainerPrimary container) {
        showWarehouses();
        List<Warehouse> warehouseList = Warehouse.getWarehouseList();
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        while (!(decisionVariable >= 0 && decisionVariable < warehouseList.size())) {
            System.out.println("Bledne numer magazynu, wybierz ponownie:");
            showWarehouses();
            decisionVariable = scan.nextInt();
        }
        Warehouse warehouse = warehouseList.get(decisionVariable);
        addContainerToWarehouse(container, warehouse);
    }

    public static void addContainerToWarehouse(ContainerPrimary container, Warehouse warehouse) {
        List<ContainerPrimary> listOfContainers = warehouse.getListOfContainers();
        if (listOfContainers.size() < warehouse.getMaxContainers()) {
            if (container.getSender().getWarnings() <= 3) {
                addContainerAndStartThread(container, warehouse);
            } else {
                System.err.println('\n' + "Nie przyjmuje towaru, nadawca ma zbyt duzo ostrzezen!");
            }
        } else {
            System.err.println('\n' + "Magazyn jest pełny!");
        }
    }

    private static void addContainerAndStartThread(ContainerPrimary container, Warehouse warehouse) {
        List<ContainerPrimary> listOfContainers = warehouse.getListOfContainers();
        if (container instanceof ContainerExplosiveMaterials) {
            ContainerTimer containerTimer = new ContainerTimer(container, 5, warehouse);
            Timer.addContainer(containerTimer);
            listOfContainers.add(container);
        } else if (container instanceof ContainerToxicLiquidMaterials) {
            ContainerTimer containerTimer = new ContainerTimer(container, 10, warehouse);
            Timer.addContainer(containerTimer);
            listOfContainers.add(container);
        } else if (container instanceof ContainerToxicLooseMaterials) {
            ContainerTimer containerTimer = new ContainerTimer(container, 15, warehouse);
            Timer.addContainer(containerTimer);
            listOfContainers.add(container);
        } else {
            listOfContainers.add(container);
        }
    }
}
