package projekt;

import projekt.generators.*;
import projekt.services.RailwayWagonService;
import projekt.services.SenderService;
import projekt.services.ShipService;
import projekt.services.WarehouseService;
import projekt.services.containersService.ContainerPrimaryService;
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
                    ShipService.createShip();
                    break;
                case 2:
                    ContainerPrimaryService.makeKontener();
                    break;
                case 3:
                    SenderService.createSender();
                    break;
                case 4:
                    ShipService.chooseOperationToDo();
                    break;
                case 5:
                    WarehouseService.chooseWarehouseToRemoveContainer();
                    break;
                case 6:
                    ShipService.showShipList();
                    break;
                case 7:
                    WarehouseService.showWarehouses();
                    break;
                case 8:
                    RailwayWagonService.showKontenersInWagon();
                    break;
            }
        } while (decisionVariable != 0);
    }


    private static List<String> listOfAvaibleOperations() {
        List<String> list = new ArrayList<>();
        list.add("Wyjdz");
        list.add("Utworz statek");
        list.add("Utworz kontener");
        list.add("Utworz nadawce");
        list.add("Wykonaj operacje na statku");
        list.add("Usun kontener z magazynu");
        list.add("Wyswietl liste dostepnych statkow");
        list.add("Wyswietl liste dostepnych magazynow");
        list.add("Zobacz stan zaladowania wagonu");
        return list;
    }


    private static void showLists(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " - " + list.get(i) + "  ");
        }
        System.out.println();
    }


}
