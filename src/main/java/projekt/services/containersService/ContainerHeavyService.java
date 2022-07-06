package projekt.services.containersService;

import projekt.models.Sender;
import projekt.models.konteners.ContainerHeavy;
import projekt.services.SenderService;

import java.util.Scanner;

public class ContainerHeavyService {
    public static ContainerHeavy createContainerHeavy() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = SenderService.chooseSenderToDo();
        System.out.println("Podaj portnadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        System.out.println("Podaj objetosc");
        double volume = scanK.nextDouble();
        return new ContainerHeavy.Builder()
                .sender(sender)
                .homePort(homePort)
                .weightNetto(weightNetto)
                .tara(tara)
                .volume(volume)
                .build();
    }
}
