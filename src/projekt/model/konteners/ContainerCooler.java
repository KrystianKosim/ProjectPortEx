package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class ContainerCooler extends ContainerHeavy {
    private double powerOfElectricityInstalation;

    public ContainerCooler(Sender sender, String homePort, double weightNetto, double tara, double volume, double powerOfElectricityInstalation) {
        super(sender, homePort, weightNetto, tara, volume);
        this.powerOfElectricityInstalation = powerOfElectricityInstalation;
    }

    public static ContainerCooler createContainerCooler() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = Sender.chooseSenderToDo();
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
        return new ContainerCooler(sender, homePort, weightNetto, tara, volume, powerOfElectricityInstalation);
    }

    @Override
    public String toString() {
        return "Kontener chlodzacy{" + getSender() +
                ", port nadania: " + getHomePort() +
                ", waga netto: " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", objetosc: " + getVolume() +
                ", moc instalacji elektrycznej: " + powerOfElectricityInstalation +
                ", ID: " + getContainerID() +
                '}';
    }
}

