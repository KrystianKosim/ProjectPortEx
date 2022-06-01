package projekt.services.containersService;

import projekt.models.Sender;
import projekt.models.konteners.ContainerExplosiveMaterials;
import projekt.services.SenderService;

import java.util.Scanner;

public class ContainerExplosiveMaterialsService {

    public static ContainerExplosiveMaterials createContainerExplosiveMaterials() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = SenderService.chooseSenderToDo();
        System.out.println("Podaj port nadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        System.out.println("Podaj objetosc");
        double volume = scanK.nextDouble();
        System.out.println("Podaj certyfikat bezpieczenstwa");
        String certificate = new Scanner(System.in).nextLine();
        return new ContainerExplosiveMaterials.Builder()
                .sender(sender)
                .homePort(homePort)
                .weightNetto(weightNetto)
                .tara(tara)
                .volume(volume)
                .certificate(certificate)
                .build();
    }

}
