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
    private int maximumOfEveryKonteners;
    private int maximumOfHeavyKonteners;
    private int maximumOfCoolerKonteners;
    private int maximumOfLiquidMaterialsKonteners;
    private int maximumOfToxicKontenres;
    private double maximumWeight;
    private List<KontenerPrimary> listOfKonteners;
    private int shipId;
    private int id;
    private static List<Ship> shipList = new ArrayList<>();

    public Ship(String name, String nameOfHomePort, String transportFrom, String transportTo, int maximumOfEveryKonteners,
                int maximumOfHeavyKonteners, int maximumOfCoolerKonteners, int maximumOfLiquidMaterialsKonteners, int maximumOfToxicKontenres,
                double maximumWeight) {
        this.name = name;
        this.nameOfHomePort = nameOfHomePort;
        this.transportFrom = transportFrom;
        this.transportTo = transportTo;
        this.maximumOfEveryKonteners = maximumOfEveryKonteners;
        this.maximumOfHeavyKonteners = maximumOfHeavyKonteners;
        this.maximumOfCoolerKonteners = maximumOfCoolerKonteners;
        this.maximumOfLiquidMaterialsKonteners = maximumOfLiquidMaterialsKonteners;
        this.maximumOfToxicKontenres = maximumOfToxicKontenres;
        this.maximumWeight = maximumWeight;
        listOfKonteners = new ArrayList<>();
        shipId = id;
        id++;
        shipList.add(this);
    }

    public boolean addNewKontener(KontenerPrimary kontener) {
        boolean isPosibletoAddKontener = false;
        if (isEnoughtFreeWeight(kontener) && isEnoughtPlaceForKontener()) {
            /**
             * Aby dodac kontener podstawowy wazne jest tylko aby bylo miejsce na statku
             */
            if (kontener.getClass() == KontenerPrimary.class) {
                isPosibletoAddKontener = isEnoughtPlaceForKontener();
            } else if (kontener.getClass() == KontenerHeavy.class) {
                isPosibletoAddKontener = countHeavyKonteners() < maximumOfHeavyKonteners;
            } else if (kontener.getClass() == KontenerLiquidMaterials.class) {
                isPosibletoAddKontener = countLiquidMaterialsKonteners() < maximumOfLiquidMaterialsKonteners;
            } else if (kontener.getClass() == KontenerCooler.class) {
                isPosibletoAddKontener = countCoolerKonteners() < maximumOfCoolerKonteners;
            } else if (kontener.getClass() == KontenerExplosiveMaterials.class) {
                isPosibletoAddKontener = countToxicAndExplosiveMaterials() < maximumOfToxicKontenres;
            } else if (kontener.getClass() == KontenerToxicLiquidMaterials.class) {
                isPosibletoAddKontener = countToxicAndExplosiveMaterials() < maximumOfToxicKontenres;
            } else if (kontener.getClass() == KontenerToxicLooseMaterials.class) {
                isPosibletoAddKontener = countToxicAndExplosiveMaterials() < maximumOfToxicKontenres;
            }
        }
        if (isPosibletoAddKontener) {
            listOfKonteners.add(kontener);
            return true;
        } else {
            System.out.println("Niemozliwe dodanie nowego kontenera na statek");
            return false;
        }
    }


    private boolean isEnoughtPlaceForKontener() {
        return listOfKonteners.size() < maximumOfEveryKonteners;
    }

    private boolean isEnoughtFreeWeight(KontenerPrimary kontener) {
        double weightOfKonteners = 0;
        for (KontenerPrimary elemenet : listOfKonteners) {
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

    public static void addKontenerToShip(KontenerPrimary kontener) {
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
        for (int i = 0; i < listOfKonteners.size(); i++) {
            System.out.println(i + " - " + listOfKonteners.get(i));
        }
    }

    public static void whereUnloadKontener(KontenerPrimary kontener) {
        listOptionsToUnload();
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        switch (decisionVariable) {
            case 0:
                break;
            case 1:
                RailwayWagon.addKontenerToWagon(kontener);
                break;
            case 2:
                Warehouse.chooseWarehouseToAddKontener(kontener);
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
        if (!listOfKonteners.isEmpty()) {
            System.out.println("Wybierz ktory kontener chcesz wyladowac: ");
            showKontenersOnShip();
            Scanner scan = new Scanner(System.in);
            int decisionVariable = scan.nextInt();
            while (!(decisionVariable >= 0 && decisionVariable < listOfKonteners.size())) {
                System.err.println("Podano zly numer kontenera, podaj ponownie");
                showKontenersOnShip();
                decisionVariable = scan.nextInt();
            }
            KontenerPrimary kontener = listOfKonteners.get(decisionVariable);
            listOfKonteners.remove(decisionVariable);
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
        for (KontenerPrimary element : listOfKonteners) {
            if (element instanceof KontenerPrimary) {
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
        for (KontenerPrimary elemenet : listOfKonteners) {
            if (elemenet instanceof KontenerHeavy) {
                count++;
            }
        }
        int sumOfOtherKonteners = countCoolerKonteners() + countToxicLooseKonteners() + countExplosiveKonteners();
        int onlyHeavyKonteners = count - sumOfOtherKonteners;
        return onlyHeavyKonteners;
    }

    private int countCoolerKonteners() {
        int count = 0;
        for (KontenerPrimary elemenet : listOfKonteners) {
            if (elemenet instanceof KontenerCooler) {
                count++;
            }
        }
        return count;
    }

    private int countLiquidMaterialsKonteners() {
        int count = 0;
        for (KontenerPrimary element : listOfKonteners) {
            if (element instanceof KontenerLiquidMaterials) {
                count++;
            }
        }
        return count;
    }

    private int countExplosiveKonteners() {
        int count = 0;
        for (KontenerPrimary elemenet : listOfKonteners) {
            if (elemenet instanceof KontenerExplosiveMaterials) {
                count++;
            }
        }
        return count;
    }

    private int countToxicLiquidKonteners() {
        int count = 0;
        for (KontenerPrimary elemenet : listOfKonteners) {
            if (elemenet instanceof KontenerToxicLiquidMaterials) {
                count++;
            }
        }
        return count;
    }

    private int countToxicLooseKonteners() {
        int count = 0;
        for (KontenerPrimary elemenet : listOfKonteners) {
            if (elemenet instanceof KontenerToxicLooseMaterials) {
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
                " PrimaryKonteners: " + countPrimaryKonteners() + "/" + maximumOfEveryKonteners +
                ", HeavyKonteners: " + countHeavyKonteners() + "/" + maximumOfHeavyKonteners +
                ", LiquidKonteners: " + countLiquidMaterialsKonteners() + "/" + maximumOfLiquidMaterialsKonteners +
                ", ToxicKontenres: " + (countToxicLiquidKonteners() + countExplosiveKonteners() + countToxicLooseKonteners()) + "/" + maximumOfToxicKontenres +
                ", CoolerKonteners: " + countCoolerKonteners() + "/" + maximumOfCoolerKonteners +
                ", EveryKonteners: " + listOfKonteners.size() + "/" + maximumOfEveryKonteners +
                ", maximumWeight: " + maximumWeight +
                ", listOfKonteners: " + listOfKonteners +
                ", shipId: " + shipId;
    }
}
