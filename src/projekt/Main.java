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
                    Ship.chooseShip();
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
                KontenerPrimary kontenerPrimary = KontenerPrimary.createKontenerPrimary();
                KontenerPrimary.chooseActionToDoOnNewKontener(kontenerPrimary);
                break;
            case 2:
                KontenerHeavy kontenerHeavy = KontenerHeavy.createKontenerHeavy();
                KontenerPrimary.chooseActionToDoOnNewKontener(kontenerHeavy);
                break;
            case 3:
                KontenerCooler kontenerCooler = KontenerCooler.createKontenerCooler();
                KontenerPrimary.chooseActionToDoOnNewKontener(kontenerCooler);
                break;
            case 4:
                KontenerLiquidMaterials kontenerLiquidMaterials = KontenerLiquidMaterials.createKontenerLiquid();
                KontenerPrimary.chooseActionToDoOnNewKontener(kontenerLiquidMaterials);
                break;
            case 5:
                KontenerExplosiveMaterials kontenerExplosiveMaterials = KontenerExplosiveMaterials.createKontenerExplosiveMaterials();
                KontenerPrimary.chooseActionToDoOnNewKontener(kontenerExplosiveMaterials);
                break;
            case 6:
                KontenerToxicLooseMaterials kontenerToxicLooseMaterials = KontenerToxicLooseMaterials.createKontenerToxicLooseMaterials();
                KontenerPrimary.chooseActionToDoOnNewKontener(kontenerToxicLooseMaterials);
                break;
            case 7:
                KontenerToxicLiquidMaterials kontenerToxicLiquidMaterials = KontenerToxicLiquidMaterials.createKontenerToxicLiquidMaterials();
                KontenerPrimary.chooseActionToDoOnNewKontener(kontenerToxicLiquidMaterials);
                break;
        }
    }

    private static void showLists(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " - " + list.get(i) + "  ");
        }
    }




}
