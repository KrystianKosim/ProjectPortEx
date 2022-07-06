package main.java.projekt.models;

import main.java.projekt.models.konteners.ContainerPrimary;

import java.util.ArrayList;
import java.util.List;

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

    public List<ContainerPrimary> getListOfContainers() {
        return listOfContainers;
    }

    public static List<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public int getMaxContainers() {
        return maxContainers;
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
