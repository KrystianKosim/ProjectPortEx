package main.java.projekt.services.containersService;

import main.java.projekt.models.Sender;
import main.java.projekt.models.konteners.ContainerCooler;
import main.java.projekt.services.SenderService;

import java.util.Scanner;

public class ContainerCoolerService {

    public static ContainerCooler createContainerCooler() {
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
        System.out.println("Podaj moc instalacji elektrycznej");
        double powerOfElectricityInstalation = scanK.nextDouble();
        return new ContainerCooler.Builder()
                .sender(sender)
                .homePort(homePort)
                .weightNetto(weightNetto)
                .tara(tara)
                .volume(volume)
                .powerOfElectricityInstalation(powerOfElectricityInstalation)
                .build();
    }
}
