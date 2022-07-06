package main.java.projekt.services;

import main.java.projekt.models.Ship;
import main.java.projekt.models.konteners.*;
import main.java.projekt.threads.Timer;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShipService {

    public static boolean addNewKontener(ContainerPrimary container, Ship ship) {
        boolean isPosibletoAddContainer = false;
        if (isEnoughtFreeWeight(container, ship) && isEnoughtPlaceForContainer(ship)) {
            /**
             * Aby dodac container podstawowy wazne jest tylko aby bylo miejsce na statku
             */
            if (container.getClass() == ContainerPrimary.class) {
                isPosibletoAddContainer = isEnoughtPlaceForContainer(ship);
            } else if (container.getClass() == ContainerHeavy.class) {
                isPosibletoAddContainer = countHeavyKonteners(ship) < ship.getMaximumOfHeavyKonteners();
            } else if (container.getClass() == ContainerLiquidMaterials.class) {
                isPosibletoAddContainer = countLiquidMaterialsKonteners(ship) < ship.getMaximumOfLiquidMaterialsKonteners();
            } else if (container.getClass() == ContainerCooler.class) {
                isPosibletoAddContainer = countCoolerKonteners(ship) < ship.getMaximumOfCoolerKonteners();
            } else if (container.getClass() == ContainerExplosiveMaterials.class) {
                isPosibletoAddContainer = countToxicAndExplosiveMaterials(ship) < ship.getMaximumOfToxicKontenres();
            } else if (container.getClass() == ContainerToxicLiquidMaterials.class) {
                isPosibletoAddContainer = countToxicAndExplosiveMaterials(ship) < ship.getMaximumOfToxicKontenres();
            } else if (container.getClass() == ContainerToxicLooseMaterials.class) {
                isPosibletoAddContainer = countToxicAndExplosiveMaterials(ship) < ship.getMaximumOfToxicKontenres();
            }
        }
        if (isPosibletoAddContainer) {
            List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
            listOfContainers.add(container);
            return true;
        } else {
            System.err.println("Niemozliwe dodanie nowego kontenera na statek");
            return false;
        }
    }


    private static boolean isEnoughtPlaceForContainer(Ship ship) {
        return ship.getListOfContainers().size() < ship.getMaximumOfEveryContainers();
    }

    private static boolean isEnoughtFreeWeight(ContainerPrimary kontener, Ship ship) {
        double weightOfKonteners = 0;
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        for (ContainerPrimary elemenet : listOfContainers) {
            weightOfKonteners += elemenet.getWeighBrutto();
        }
        return kontener.getWeighBrutto() + weightOfKonteners < ship.getMaximumWeight();
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

        return new Ship.Builder()
                .name(nameOfShip)
                .nameOfHomePort(nameOfHomePort)
                .transportFrom(transportFrom)
                .transportTo(transportTo)
                .maximumOfEveryContainers(maxOfEveryKonteners)
                .maximumOfHeavyKonteners(maxOfHeavyKonteners)
                .maximumOfCoolerKonteners(maxOfCoolersKonteners)
                .maximumOfLiquidMaterialsKonteners(maxOfLiquidMaterialsKonteners)
                .maximumOfToxicKontenres(maxOfToxicKonteners)
                .maximumWeight(maxWeightOfKonteners)
                .build();
    }

    public static void addContainerToShip(ContainerPrimary kontener) {
        List<Ship> shipList = Ship.getShipList();
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
            Ship ship = shipList.get(decisionVariable);
            addNewKontener(kontener, ship);
        } else {
            System.out.println("Brak statkow, czy chcesz utworzyc statek teraz? (yes/no)");
            String decision = new Scanner(System.in).nextLine();
            if (decision.equals("yes")) {
                ShipService.createShip();
            }
        }
    }

    public static void showKontenersOnShip(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        for (int i = 0; i < listOfContainers.size(); i++) {
            System.out.println(i + " - " + listOfContainers.get(i));
        }
    }

    public static void whereUnloadKontener(ContainerPrimary container) {
        listOptionsToUnload();
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        switch (decisionVariable) {
            case 0:
                break;
            case 1:
                RailwayWagonService.addContainerToWagon(container);
                break;
            case 2:
                WarehouseService.chooseWarehouseToAddContainer(container);
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

    public static void unloadKontener(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        if (!listOfContainers.isEmpty()) {
            System.out.println("Wybierz ktory kontener chcesz wyladowac: ");
            showKontenersOnShip(ship);
            Scanner scan = new Scanner(System.in);
            int decisionVariable = scan.nextInt();
            while (!(decisionVariable >= 0 && decisionVariable < listOfContainers.size())) {
                System.err.println("Podano zly numer kontenera, podaj ponownie");
                showKontenersOnShip(ship);
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
        while (!(decisionVariable >= 0 && decisionVariable <= 2)) {
            System.err.println("Bledna wartosc, podaj ponownie poprawna wartosc");
            decisionVariable = scan.nextInt();
        }
        switch (decisionVariable) {
            case 0:
                break;
            case 1:
                unloadKontener(ship);
                break;
            case 2:
                ShipService.relaseTheShipOnJourney(ship);
                break;
        }
    }

    public static void relaseTheShipOnJourney(Ship ship) {
        System.out.println("Podaj czas podrozy statku");
        Scanner scan = new Scanner(System.in);
        int journeyTime = scan.nextInt();
        while (!(journeyTime > 0)) {
            System.err.println("Bledna wartosc podrozy, podaj poprawna wartosc");
            journeyTime = scan.nextInt();
        }
        LocalDate dateInProgram = Timer.getDateInProgram();
        ship.setTimeOfReturnToPort(dateInProgram.plusDays(journeyTime));
        ship.setInPort(false);
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
        List<Ship> shipList = Ship.getShipList();
        Ship shipToReturn;
        if (!shipList.isEmpty()) {
            System.out.println("Na jakim statku chcesz wykonac operacje?");
            showShipList();
            Scanner scan = new Scanner(System.in);
            int decisionVariable = scan.nextInt();
            while (!(decisionVariable >= 0 && decisionVariable < shipList.size() && shipList.get(decisionVariable).isInPort())) {
                System.err.println("Wybrano niewlasciwy statek, wybierz ponownie z listy:");
                showShipList();
                decisionVariable = scan.nextInt();
            }
            shipToReturn = shipList.get(decisionVariable);
        } else {
            System.out.println("Brak statkow, utworz statek");
            shipToReturn = ShipService.createShip();
        }
        return shipToReturn;
    }

    public static void showShipList() {
        List<Ship> shipList = Ship.getShipList();
        for (int i = 0; i < shipList.size(); i++) {
            if (!shipList.get(i).isInPort()) {
                System.out.print("STATEK JEST POZA PORTEM ");
            } else
                System.out.println(i + " - " + shipList.get(i));
        }
    }

    public static int countToxicAndExplosiveMaterials(Ship ship) {
        return countExplosiveKonteners(ship) + countToxicLooseKonteners(ship) + countToxicLiquidKonteners(ship);
    }

    public static int countPrimaryKonteners(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        int count = 0;
        for (ContainerPrimary element : listOfContainers) {
            if (element instanceof ContainerPrimary) {
                count++;
            }
        }
        int sumOfOtherKonteners = countHeavyKonteners(ship) + countCoolerKonteners(ship) + countLiquidMaterialsKonteners(ship) +
                countExplosiveKonteners(ship) + countToxicLiquidKonteners(ship) + countToxicLooseKonteners(ship);
        int onlyPrimaryKonteners = count - sumOfOtherKonteners;
        return onlyPrimaryKonteners;
    }

    public static int countHeavyKonteners(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerHeavy) {
                count++;
            }
        }
        int sumOfOtherKonteners = countCoolerKonteners(ship) + countToxicLooseKonteners(ship) + countExplosiveKonteners(ship);
        int onlyHeavyKonteners = count - sumOfOtherKonteners;
        return onlyHeavyKonteners;
    }

    public static int countCoolerKonteners(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerCooler) {
                count++;
            }
        }
        return count;
    }

    public static int countLiquidMaterialsKonteners(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        int count = 0;
        for (ContainerPrimary element : listOfContainers) {
            if (element instanceof ContainerLiquidMaterials) {
                count++;
            }
        }
        return count;
    }

    public static int countExplosiveKonteners(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerExplosiveMaterials) {
                count++;
            }
        }
        return count;
    }

    public static int countToxicLiquidKonteners(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerToxicLiquidMaterials) {
                count++;
            }
        }
        return count;
    }

    public static int countToxicLooseKonteners(Ship ship) {
        List<ContainerPrimary> listOfContainers = ship.getListOfContainers();
        int count = 0;
        for (ContainerPrimary elemenet : listOfContainers) {
            if (elemenet instanceof ContainerToxicLooseMaterials) {
                count++;
            }
        }
        return count;
    }
}
