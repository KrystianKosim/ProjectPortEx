package projekt;

import projekt.generators.*;
import projekt.model.RailwayWagon;
import projekt.model.Ship;
import projekt.model.Warehouse;
import projekt.model.konteners.*;
import projekt.threads.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();

        SenderGenerator.sendersGenerator();
        ShipGenerator.shipGenerator();
        KontenersGenerator.kontenerGenerator();
        RailwayWagonGenerator.railwayWagnosGenerator();
        WarehouseGenerator.warehouseGenerator();


        menu();


    }

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int decisionVariable;
        do {
            System.out.println('\n' + "Jaka operacje chcesz wykonac?");
            showLists(listOfAvaibleOperations());
            decisionVariable = scan.nextInt();
            switch (decisionVariable) {
                case 0:
                    break;
                case 1:
                    Ship.createShip();
                    break;
                case 2:
                    makeKontener();
                    break;
                case 3:
                    Ship.chooseOperationToDo();
                    break;
                case 4:
                    Ship.showShipList();
                    break;
                case 5:
                    Warehouse.showWarehouses();
                    break;
                case 6:
                    RailwayWagon.showKontenersInWagon();
            }
        } while (decisionVariable != 0);
    }


    private static List<String> listOfAvaibleOperations() {
        List<String> list = new ArrayList<>();
        list.add("Wyjdz");
        list.add("Utworz statek");
        list.add("Utworz kontener");
        list.add("Wykonaj operacje na statku");
        list.add("Wyswietl liste dostepnych statkow");
        list.add("wybierz istniejacy magazyn");
        list.add("Zobacz stan zaladowania wagonu");
        return list;
    }

    private static List<String> listTypesOfKontenersToCreate() {
        List<String> list = new ArrayList<>();
        list.add("Wyjdz");
        list.add("Podstawowy");
        list.add("Ciezki");
        list.add("Chlodniczy");
        list.add("Na materialy ciekle");
        list.add("Na materialy wybuchowe");
        list.add("Na toksyczne materialy sypkie");
        list.add("Na toksyczne materialy ciekle");
        return list;
    }

    private static void makeKontener() {
        showLists(listTypesOfKontenersToCreate());
        int decisionVariableKontener = new Scanner(System.in).nextInt();
        switch (decisionVariableKontener) {
            case 0:
                break;
            case 1:
                ContainerPrimary containerPrimary = ContainerPrimary.createContainerPrimary();
                ContainerPrimary.chooseActionToDoOnNewContainer(containerPrimary);
                break;
            case 2:
                ContainerHeavy containerHeavy = ContainerHeavy.createContainerHeavy();
                ContainerPrimary.chooseActionToDoOnNewContainer(containerHeavy);
                break;
            case 3:
                ContainerCooler kontenerCooler = ContainerCooler.createContainerCooler();
                ContainerPrimary.chooseActionToDoOnNewContainer(kontenerCooler);
                break;
            case 4:
                ContainerLiquidMaterials containerLiquidMaterials = ContainerLiquidMaterials.createContainerLiquid();
                ContainerPrimary.chooseActionToDoOnNewContainer(containerLiquidMaterials);
                break;
            case 5:
                ContainerExplosiveMaterials containerExplosiveMaterials = ContainerExplosiveMaterials.createContainerExplosiveMaterials();
                ContainerPrimary.chooseActionToDoOnNewContainer(containerExplosiveMaterials);
                break;
            case 6:
                ContainerToxicLooseMaterials kontenerToxicLooseMaterials = ContainerToxicLooseMaterials.createContainerToxicLooseMaterials();
                ContainerPrimary.chooseActionToDoOnNewContainer(kontenerToxicLooseMaterials);
                break;
            case 7:
                ContainerToxicLiquidMaterials kontenerToxicLiquidMaterials = ContainerToxicLiquidMaterials.createContainerToxicLiquidMaterials();
                ContainerPrimary.chooseActionToDoOnNewContainer(kontenerToxicLiquidMaterials);
                break;
        }
    }

    private static void showLists(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " - " + list.get(i) + "  ");
        }
        System.out.println();
    }


}
