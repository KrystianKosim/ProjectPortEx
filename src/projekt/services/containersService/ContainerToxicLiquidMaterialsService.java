package projekt.services.containersService;

import projekt.models.Sender;
import projekt.models.konteners.ContainerToxicLiquidMaterials;
import projekt.services.SenderService;

import java.util.Scanner;

public class ContainerToxicLiquidMaterialsService {

    public static ContainerToxicLiquidMaterials createContainerToxicLiquidMaterials() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = SenderService.chooseSenderToDo();
        System.out.println("Podaj portnadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        System.out.println("Maksymalna pojemnosc w litrach");
        double maxLitersOfLiquid = scanK.nextDouble();
        System.out.println("Certyfikat dla toksycznych materialow cieklych");
        String cerificateOfToxicLiquidMaterials = scanK.nextLine();
        return new ContainerToxicLiquidMaterials.Builder()
                .sender(sender)
                .homePort(homePort)
                .weightNetto(weightNetto)
                .tara(tara)
                .maxLitersOfLiquid(maxLitersOfLiquid)
                .cerificateOfToxicLiquidMaterials(cerificateOfToxicLiquidMaterials)
                .build();
    }
}
