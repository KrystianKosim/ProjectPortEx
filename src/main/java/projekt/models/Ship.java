package main.java.projekt.models;

import main.java.projekt.models.konteners.ContainerPrimary;
import main.java.projekt.services.ShipService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final String name;
    private final String nameOfHomePort;
    private final String transportFrom;
    private final String transportTo;
    private final int maximumOfEveryContainers;
    private final int maximumOfHeavyKonteners;
    private final int maximumOfCoolerKonteners;
    private final int maximumOfLiquidMaterialsKonteners;
    private final int maximumOfToxicKontenres;
    private final double maximumWeight;
    private boolean isInPort;
    private LocalDate timeOfReturnToPort;
    private final List<ContainerPrimary> listOfContainers;
    private final int shipId;
    private int id;
    private static final List<Ship> shipList = new ArrayList<>();

    private Ship(String name, String nameOfHomePort, String transportFrom, String transportTo, int maximumOfEveryContainers,
                 int maximumOfHeavyKonteners, int maximumOfCoolerKonteners, int maximumOfLiquidMaterialsKonteners, int maximumOfToxicKontenres,
                 double maximumWeight) {
        this.name = name;
        this.nameOfHomePort = nameOfHomePort;
        this.transportFrom = transportFrom;
        this.transportTo = transportTo;
        this.maximumOfEveryContainers = maximumOfEveryContainers;
        this.maximumOfHeavyKonteners = maximumOfHeavyKonteners;
        this.maximumOfCoolerKonteners = maximumOfCoolerKonteners;
        this.maximumOfLiquidMaterialsKonteners = maximumOfLiquidMaterialsKonteners;
        this.maximumOfToxicKontenres = maximumOfToxicKontenres;
        this.maximumWeight = maximumWeight;
        isInPort = true;
        listOfContainers = new ArrayList<>();
        shipId = id;
        id++;
        shipList.add(this);
    }


    public static class Builder {
        private String name;
        private String nameOfHomePort;
        private String transportFrom;
        private String transportTo;
        private int maximumOfEveryContainers;
        private int maximumOfHeavyKonteners;
        private int maximumOfCoolerKonteners;
        private int maximumOfLiquidMaterialsKonteners;
        private int maximumOfToxicKontenres;
        private double maximumWeight;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder nameOfHomePort(String nameOfHomePort) {
            this.nameOfHomePort = nameOfHomePort;
            return this;
        }

        public Builder transportFrom(String transportFrom) {
            this.transportFrom = transportFrom;
            return this;
        }

        public Builder transportTo(String transportTo) {
            this.transportTo = transportTo;
            return this;
        }

        public Builder maximumOfEveryContainers(int maximumOfEveryContainers) {
            this.maximumOfEveryContainers = maximumOfEveryContainers;
            return this;
        }

        public Builder maximumOfHeavyKonteners(int maximumOfHeavyKonteners) {
            this.maximumOfHeavyKonteners = maximumOfHeavyKonteners;
            return this;
        }

        public Builder maximumOfCoolerKonteners(int maximumOfCoolerKonteners) {
            this.maximumOfCoolerKonteners = maximumOfCoolerKonteners;
            return this;
        }

        public Builder maximumOfLiquidMaterialsKonteners(int maximumOfLiquidMaterialsKonteners) {
            this.maximumOfLiquidMaterialsKonteners = maximumOfLiquidMaterialsKonteners;
            return this;
        }

        public Builder maximumOfToxicKontenres(int maximumOfToxicKontenres) {
            this.maximumOfToxicKontenres = maximumOfToxicKontenres;
            return this;
        }

        public Builder maximumWeight(double maximumWeight) {
            this.maximumWeight = maximumWeight;
            return this;
        }

        public Ship build() {
            return new Ship(name, nameOfHomePort, transportFrom, transportTo, maximumOfEveryContainers, maximumOfHeavyKonteners,
                    maximumOfCoolerKonteners, maximumOfLiquidMaterialsKonteners, maximumOfToxicKontenres, maximumWeight);
        }
    }

    public int getMaximumOfEveryContainers() {
        return maximumOfEveryContainers;
    }

    public int getMaximumOfHeavyKonteners() {
        return maximumOfHeavyKonteners;
    }

    public int getMaximumOfCoolerKonteners() {
        return maximumOfCoolerKonteners;
    }

    public int getMaximumOfLiquidMaterialsKonteners() {
        return maximumOfLiquidMaterialsKonteners;
    }

    public int getMaximumOfToxicKontenres() {
        return maximumOfToxicKontenres;
    }

    public double getMaximumWeight() {
        return maximumWeight;
    }

    public boolean isInPort() {
        return isInPort;
    }

    public List<ContainerPrimary> getListOfContainers() {
        return listOfContainers;
    }

    public static List<Ship> getShipList() {
        return shipList;
    }

    public LocalDate getTimeOfReturnToPort() {
        return timeOfReturnToPort;
    }

    public void setInPort(boolean inPort) {
        isInPort = inPort;
    }

    public void setTimeOfReturnToPort(LocalDate timeOfReturnToPort) {
        this.timeOfReturnToPort = timeOfReturnToPort;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", nameOfHomePort: " + nameOfHomePort +
                ", transportFrom: " + transportFrom +
                ", transportTo: " + transportTo + '\n' +
                " PrimaryKonteners: " + ShipService.countPrimaryKonteners(this) + "/" + maximumOfEveryContainers +
                ", HeavyKonteners: " + ShipService.countHeavyKonteners(this) + "/" + maximumOfHeavyKonteners +
                ", LiquidKonteners: " + ShipService.countLiquidMaterialsKonteners(this) + "/" + maximumOfLiquidMaterialsKonteners +
                ", ToxicKontenres: " + (ShipService.countToxicLiquidKonteners(this) + ShipService.countExplosiveKonteners(this) + ShipService.countToxicLooseKonteners(this)) + "/" + maximumOfToxicKontenres +
                ", CoolerKonteners: " + ShipService.countCoolerKonteners(this) + "/" + maximumOfCoolerKonteners +
                ", EveryKonteners: " + listOfContainers.size() + "/" + maximumOfEveryContainers +
                ", maximumWeight: " + maximumWeight +
                ", listOfKonteners: " + listOfContainers +
                ", shipId: " + shipId;
    }
}
