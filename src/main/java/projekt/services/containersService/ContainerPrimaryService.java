package projekt.services.containersService;

import projekt.models.Sender;
import projekt.models.konteners.*;
import projekt.services.RailwayWagonService;
import projekt.services.SenderService;
import projekt.services.ShipService;
import projekt.services.WarehouseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContainerPrimaryService {


    public static ContainerPrimary createContainerPrimary() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = SenderService.chooseSenderToDo();
        System.out.println("Podaj port nadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        return new ContainerPrimary.Builder()
                .sender(sender)
                .homePort(homePort)
                .weightNetto(weightNetto)
                .tara(tara)
                .build();
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

    public static void makeKontener() {
        showLists(listTypesOfKontenersToCreate());
        int decisionVariableKontener = new Scanner(System.in).nextInt();
        switch (decisionVariableKontener) {
            case 0:
                break;
            case 1:
                ContainerPrimary containerPrimary = ContainerPrimaryService.createContainerPrimary();
                ContainerPrimaryService.chooseActionToDoOnNewContainer(containerPrimary);
                break;
            case 2:
                ContainerHeavy containerHeavy = ContainerHeavyService.createContainerHeavy();
                ContainerPrimaryService.chooseActionToDoOnNewContainer(containerHeavy);
                break;
            case 3:
                ContainerCooler kontenerCooler = ContainerCoolerService.createContainerCooler();
                ContainerPrimaryService.chooseActionToDoOnNewContainer(kontenerCooler);
                break;
            case 4:
                ContainerLiquidMaterials containerLiquidMaterials = ContainerLiquidMaterialsService.createContainerLiquid();
                ContainerPrimaryService.chooseActionToDoOnNewContainer(containerLiquidMaterials);
                break;
            case 5:
                ContainerExplosiveMaterials containerExplosiveMaterials = ContainerExplosiveMaterialsService.createContainerExplosiveMaterials();
                ContainerPrimaryService.chooseActionToDoOnNewContainer(containerExplosiveMaterials);
                break;
            case 6:
                ContainerToxicLooseMaterials kontenerToxicLooseMaterials = ContainerToxicLooseMaterialsService.createContainerToxicLooseMaterials();
                ContainerPrimaryService.chooseActionToDoOnNewContainer(kontenerToxicLooseMaterials);
                break;
            case 7:
                ContainerToxicLiquidMaterials kontenerToxicLiquidMaterials = ContainerToxicLiquidMaterialsService.createContainerToxicLiquidMaterials();
                ContainerPrimaryService.chooseActionToDoOnNewContainer(kontenerToxicLiquidMaterials);
                break;
        }
    }


    public static void chooseActionToDoOnNewContainer(ContainerPrimary container) {
        showLists(actionsToDoOnNewContainer());
        Scanner scan = new Scanner(System.in);
        int decisionVariable = scan.nextInt();
        switch (decisionVariable) {
            case 0:
                break;
            case 1:
                ShipService.addContainerToShip(container);
                break;
            case 2:
                RailwayWagonService.addContainerToWagon(container);
                break;
            case 3:
                WarehouseService.chooseWarehouseToAddContainer(container);
                break;
        }
    }

    private static void showLists(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " - " + list.get(i) + "  ");
        }
    }

    private static List<String> actionsToDoOnNewContainer() {
        List<String> list = new ArrayList<>();
        list.add("Wyjdz");
        list.add("Zaladuj kontener na statek");
        list.add("Zaladuj kontener na wagon");
        list.add("Zaladuj kontener do magazynu");
        return list;
    }

}
