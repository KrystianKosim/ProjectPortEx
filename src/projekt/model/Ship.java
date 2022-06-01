package projekt.model;

import projekt.model.konteners.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ship {
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
    private List<ContainerPrimary> listOfContainers;
    private int shipId;
    private int id;
    private static List<Ship> shipList = new ArrayList<>();

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
        listOfContainers = new ArrayList<>();
        shipId = id;
        id++;
        shipList.add(this);
    }



    public boolean addNewKontener(ContainerPrimary container) {
        boolean isPosibletoAddContainer = false;
        if (isEnoughtFreeWeight(container) && isEnoughtPlaceForContainer()) {
            /**
             * Aby dodac container podstawowy wazne jest tylko aby bylo miejsce na statku
             */
            if (container.getClass() == ContainerPrimary.class) {
                isPosibletoAddContainer = isEnoughtPlaceForContainer();
            } else if (container.getClass() == ContainerHeavy.class) {
                isPosibletoAddContainer = countHeavyKonteners() < maximumOfHeavyKonteners;
            } else if (container.getClass() == ContainerLiquidMaterials.class) {
                isPosibletoAddContainer = countLiquidMaterialsKonteners() < maximumOfLiquidMaterialsKonteners;
            } else if (container.getClass() == ContainerCooler.class) {
                isPosibletoAddContainer = countCoolerKonteners() < maximumOfCoolerKonteners;
            } else if (container.getClass() == ContainerExplosiveMaterials.class) {
                isPosibletoAddContainer = countToxicAndExplosiveMaterials() < maximumOfToxicKontenres;
            } else if (container.getClass() == ContainerToxicLiquidMaterials.class) {
                isPosibletoAddContainer = countToxicAndExplosiveMaterials() < maximumOfToxicKontenres;
            } else if (container.getClass() == ContainerToxicLooseMaterials.class) {
                isPosibletoAddContainer = countToxicAndExplosiveMaterials() < maximumOfToxicKontenres;
            }
        }
        if (isPosibletoAddContainer) {
            listOfContainers.add(container);
            return true;
        } else {
            System.out.println("Niemozliwe dodanie nowego kontenera na statek");
            return false;
        }
    }


    private boolean isEnoughtPlaceForContainer() {
        return listOfContainers.size() < maximumOfEveryContainers;
    }

    private boolean isEnoughtFreeWeight(ContainerPrimary kontener) {
        double weightOfKonteners = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            weightOfKonteners += elemenet.getWeighBrutto();
        }
        if (kontener.getWeighBrutto() + weightOfKonteners < maximumWeight) {
            return true;
        } else {
            return false;
        }
    }

    public static Ship createShip() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwe");
        String nameOfShip = scan.nextLine();
        System.out.println("Podaj port macierzysty");
        String nameOfHomePort = scan.nextLine();
        System.out.println("Podaj skad transport");
        String transportFrom = scan.nextLine();
        System.out.println("Podaj dokad transport");
        String transportTo = scan.nextLine();
        System.out.println("Podaj maksymalna ilosc wszystkich kontenerow (liczby calkowite)");
        int maxOfEveryKonteners = scan.nextInt();
        System.out.println("Podaj maksymalna ilosc ciezkich kontenerow (liczby calkowite)");
        int maxOfHeavyKonteners = scan.nextInt();
        System.out.println("Podaj maksymalna ilosc chlodniczych kontenerow (liczby calkowite)");
        int maxOfCoolersKonteners = scan.nextInt();
        System.out.println("Podaj maksymalna ilosc kontenerow na materialy ciekle (liczby calkowite)");
        int maxOfLiquidMaterialsKonteners = scan.nextInt();
        System.out.println("Podaj maksymalna ilosc toksycznych kontenerow (liczby calkowite)");
        int maxOfToxicKonteners = scan.nextInt();
        System.out.println("Podaj maksymalna wage");
        double maxWeightOfKonteners = scan.nextDouble();

        return new Ship(nameOfShip, nameOfHomePort, transportFrom, transportTo, maxOfEveryKonteners, maxOfHeavyKonteners, maxOfCoolersKonteners,
                maxOfLiquidMaterialsKonteners, maxOfToxicKonteners, maxWeightOfKonteners);
    }

    public static void addContainerToShip(ContainerPrimary kontener) {
        if (!shipList.isEmpty()) {
            System.out.println("Na jaki statek chcesz dodac?");
            showShipList();
            Scanner scan = new Scanner(System.in);
            int decisionVariable = scan.nextInt();
            while (!(decisionVariable >= 0 && decisionVariable < shipList.size())) {
                System.err.println("Wybrano niewlasciwy statek, wybierz ponownie z listy:");
                showShipList();
                decisionVariable = scan.nextInt();
            }
            shipList.get(decisionVariable).addNewKontener(kontener);
        } else {
            System.out.println("Brak statkow, czy chcesz utworzyc statek teraz? (yes/no)");
            String decision = new Scanner(System.in).nextLine();
            if (decision.equals("yes")) {
                Ship.createShip();
            }
        }
    }

    public void showKontenersOnShip() {
        for (int i = 0; i < listOfContainers.size(); i++) {
            System.out.println(i + " - " + listOfContainers.get(i));
        }
    }

    public static void whereUnloadKontener(ContainerPrimary kontener) {
        listOptionsToUnload();
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        switch (decisionVariable) {
            case 0:
                break;
            case 1:
                RailwayWagon.addContainerToWagon(kontener);
                break;
            case 2:
                Warehouse.chooseWarehouseToAddContainer(kontener);
                break;
        }
    }

    public static void listOptionsToUnload() {
        List<String> listOptions = new LinkedList<>();
        listOptions.add("Wyjdz");
        listOptions.add("Na wagon");
        listOptions.add("Do magazynu");
        for (int i = 0; i < listOptions.size(); i++) {
            System.out.println(i + " - " + listOptions.get(i));
        }
    }

    public void unloadKontener() {
        if (!listOfContainers.isEmpty()) {
            System.out.println("Wybierz ktory kontener chcesz wyladowac: ");
            showKontenersOnShip();
            Scanner scan = new Scanner(System.in);
            int decisionVariable = scan.nextInt();
            while (!(decisionVariable >= 0 && decisionVariable < listOfContainers.size())) {
                System.err.println("Podano zly numer kontenera, podaj ponownie");
                showKontenersOnShip();
                decisionVariable = scan.nextInt();
            }
            ContainerPrimary kontener = listOfContainers.get(decisionVariable);
            listOfContainers.remove(decisionVariable);
            whereUnloadKontener(kontener);
        } else {
            System.err.println("Brak kontenerow na statku");
        }
    }

    public static void chooseOperationToDo() {
        Ship ship = chooseShip();
        showOperationsToDo();
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        switch (decisionVariable) {
            case 0:
                break;
            case 1:
                ship.unloadKontener();
                break;
            case 2:
                System.out.println("Statek wyplywa");
                break;
        }
    }

    public static void showOperationsToDo() {
        List<String> list = new LinkedList<>();
        list.add("Wyjdz");
        list.add("Wyladuj kontener");
        list.add("Wypusc statek w podroz");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }
    }

    public static Ship chooseShip() {
        Ship shipToReturn;
        if (!shipList.isEmpty()) {
            System.out.println("Na jakim statku chcesz wykonac operacje?");
            showShipList();
            Scanner scan = new Scanner(System.in);
            int decisionVariable = scan.nextInt();
            while (!(decisionVariable >= 0 && decisionVariable < shipList.size())) {
                System.err.println("Wybrano niewlasciwy statek, wybierz ponownie z listy:");
                showShipList();
                decisionVariable = scan.nextInt();
            }
            shipToReturn = shipList.get(decisionVariable);
        } else {
            System.out.println("Brak statkow, utworz statek");
            shipToReturn = Ship.createShip();
        }
        return shipToReturn;
    }

    public static class Builder{
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

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder nameOfHomePort(String nameOfHomePort){
            this.nameOfHomePort = nameOfHomePort;
            return this;
        }

        public Builder transportFrom(String transportFrom){
            this.transportFrom = transportFrom;
            return this;
        }

        public Builder transportTo(String transportTo){
            this.transportTo = transportTo;
            return this;
        }

        public Builder maximumOfEveryContainers(int maximumOfEveryContainers){
            this.maximumOfEveryContainers = maximumOfEveryContainers;
            return this;
        }

        public Builder maximumOfHeavyKonteners(int maximumOfHeavyKonteners){
            this.maximumOfHeavyKonteners = maximumOfHeavyKonteners;
            return this;
        }

        public Builder maximumOfCoolerKonteners(int maximumOfCoolerKonteners){
            this.maximumOfCoolerKonteners = maximumOfCoolerKonteners;
            return this;
        }

        public Builder maximumOfLiquidMaterialsKonteners(int maximumOfLiquidMaterialsKonteners){
            this.maximumOfLiquidMaterialsKonteners = maximumOfLiquidMaterialsKonteners;
            return this;
        }

        public Builder maximumOfToxicKontenres(int maximumOfToxicKontenres){
            this.maximumOfToxicKontenres = maximumOfToxicKontenres;
            return this;
        }

        public Builder maximumWeight(double maximumWeight){
            this.maximumWeight = maximumWeight;
            return this;
        }

        public Ship build(){
            return new Ship(name, nameOfHomePort, transportFrom,transportTo,maximumOfEveryContainers, maximumOfHeavyKonteners,
                    maximumOfCoolerKonteners,maximumOfLiquidMaterialsKonteners,maximumOfToxicKontenres,maximumWeight);
        }
    }

    public static void showShipList() {
        for (int i = 0; i < shipList.size(); i++) {
            System.out.println(i + " - " + shipList.get(i));
        }
    }

    private int countToxicAndExplosiveMaterials() {
        return countExplosiveKonteners() + countToxicLooseKonteners() + countToxicLiquidKonteners();
    }

    private int countPrimaryKonteners() {
        int count = 0;
        for (ContainerPrimary element : listOfContainers) {
            if (element instanceof ContainerPrimary) {
                count++;
            }
        }
        int sumOfOtherKonteners = countHeavyKonteners() + countCoolerKonteners() + countLiquidMaterialsKonteners() +
                countExplosiveKonteners() + countToxicLiquidKonteners() + countToxicLooseKonteners();
        int onlyPrimaryKonteners = count - sumOfOtherKonteners;
        return onlyPrimaryKonteners;
    }

    private int countHeavyKonteners() {
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerHeavy) {
                count++;
            }
        }
        int sumOfOtherKonteners = countCoolerKonteners() + countToxicLooseKonteners() + countExplosiveKonteners();
        int onlyHeavyKonteners = count - sumOfOtherKonteners;
        return onlyHeavyKonteners;
    }

    private int countCoolerKonteners() {
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerCooler) {
                count++;
            }
        }
        return count;
    }

    private int countLiquidMaterialsKonteners() {
        int count = 0;
        for (ContainerPrimary element : listOfContainers) {
            if (element instanceof ContainerLiquidMaterials) {
                count++;
            }
        }
        return count;
    }

    private int countExplosiveKonteners() {
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerExplosiveMaterials) {
                count++;
            }
        }
        return count;
    }

    private int countToxicLiquidKonteners() {
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerToxicLiquidMaterials) {
                count++;
            }
        }
        return count;
    }

    private int countToxicLooseKonteners() {
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerToxicLooseMaterials) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", nameOfHomePort: " + nameOfHomePort +
                ", transportFrom: " + transportFrom +
                ", transportTo: " + transportTo + '\n' +
                " PrimaryKonteners: " + countPrimaryKonteners() + "/" + maximumOfEveryContainers +
                ", HeavyKonteners: " + countHeavyKonteners() + "/" + maximumOfHeavyKonteners +
                ", LiquidKonteners: " + countLiquidMaterialsKonteners() + "/" + maximumOfLiquidMaterialsKonteners +
                ", ToxicKontenres: " + (countToxicLiquidKonteners() + countExplosiveKonteners() + countToxicLooseKonteners()) + "/" + maximumOfToxicKontenres +
                ", CoolerKonteners: " + countCoolerKonteners() + "/" + maximumOfCoolerKonteners +
                ", EveryKonteners: " + listOfContainers.size() + "/" + maximumOfEveryContainers +
                ", maximumWeight: " + maximumWeight +
                ", listOfKonteners: " + listOfContainers +
                ", shipId: " + shipId;
    }
}
