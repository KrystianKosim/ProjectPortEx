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
    private final String city;
    private final int maxContainers;
    private final int warehouseId;
    private static int warehousesId = 0;
    private final List<ContainerPrimary> listOfContainers;
    private static final List<Warehouse> warehouseList = new ArrayList<>();


    private Warehouse(String city, int maxContainers) {
        this.city = city;
        this.maxContainers = maxContainers;
        warehouseId = warehousesId;
        listOfContainers = new ArrayList<>();
        warehouseList.add(this);
        warehousesId++;
    }

    public static void chooseWarehouseToRemoveContainer() {
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
            if (!warehouse.listOfContainers.isEmpty()) {
                System.out.println("Wybierz ktory kontener chcesz usunac");
                warehouse.showContainersInWarehouse();
                int indexOfContainerToRemove = scan.nextInt();
                while (!(indexOfContainerToRemove >= 0 && indexOfContainerToRemove < warehouse.listOfContainers.size())) {
                    System.out.println("Bledny numer kontenera, wybierz ponownie");
                    indexOfContainerToRemove = scan.nextInt();
                }
                ContainerPrimary containerToRemove = warehouse.listOfContainers.get(indexOfContainerToRemove);
                warehouse.listOfContainers.remove(indexOfContainerToRemove);
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

    public static class Builder {
        private String city;
        private int maxContainers;

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder maxContainers(int maxContainers) {
            this.maxContainers = maxContainers;
            return this;
        }

        public Warehouse build() {
            return new Warehouse(city, maxContainers);
        }
    }

    public static void showWarehouses() {
        System.out.println("Wybierz magazyn");
        for (int i = 0; i < warehouseList.size(); i++) {
            System.out.println(i + " - " + warehouseList.get(i));
        }
    }

    private void showContainersInWarehouse() {
        System.out.println("Wybierz kontener");
        for (int i = 0; i < listOfContainers.size(); i++) {
            System.out.println(i + " - " + listOfContainers.get(i));
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
