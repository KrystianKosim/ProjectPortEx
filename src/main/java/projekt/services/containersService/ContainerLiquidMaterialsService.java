package main.java.projekt.services.containersService;

import main.java.projekt.models.Sender;
import main.java.projekt.models.konteners.ContainerLiquidMaterials;
import main.java.projekt.services.SenderService;

import java.util.Scanner;

public class ContainerLiquidMaterialsService {


    public static ContainerLiquidMaterials createContainerLiquid() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = SenderService.chooseSenderToDo();
        System.out.println("Podaj port nadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        System.out.println("Maksymalna pojemnosc w litrach");
        double maxLitersOfLiquid = scanK.nextDouble();
        return new ContainerLiquidMaterials.Builder()
                .sender(sender)
                .homePort(homePort)
                .weightNetto(weightNetto)
                .tara(tara)
                .maxLitersOfLiquid(maxLitersOfLiquid)
                .build();
    }


}
