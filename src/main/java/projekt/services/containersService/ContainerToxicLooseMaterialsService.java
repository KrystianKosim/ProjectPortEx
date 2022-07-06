package projekt.services.containersService;

import projekt.models.Sender;
import projekt.models.konteners.ContainerToxicLooseMaterials;
import projekt.services.SenderService;

import java.util.Scanner;

public class ContainerToxicLooseMaterialsService {


    public static ContainerToxicLooseMaterials createContainerToxicLooseMaterials() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = SenderService.chooseSenderToDo();
        System.out.println("Podaj portnadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        System.out.println("Podaj pojemnosc");
        double volume = scanK.nextDouble();
        System.out.println("Podaj certyfikat dla materialow sypkich");
        String certificateOfToxicLooseMaterials = scanK.nextLine();
        return new ContainerToxicLooseMaterials.Builder()
                .sender(sender)
                .homePort(homePort)
                .weightNetto(weightNetto)
                .tara(tara)
                .volume(volume)
                .certificateOfToxicLoose(certificateOfToxicLooseMaterials)
                .build();
    }

}
