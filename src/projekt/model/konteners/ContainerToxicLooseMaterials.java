package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class ContainerToxicLooseMaterials extends ContainerHeavy {
    private String certificateOfToxicLoose;

    public ContainerToxicLooseMaterials(Sender sender, String homePort, double weightNetto, double tara,
                                        double volume, String certificateOfToxicLoose) {
        super(sender, homePort, weightNetto, tara, volume);
        this.certificateOfToxicLoose = certificateOfToxicLoose;
    }

    public static ContainerToxicLooseMaterials createContainerToxicLooseMaterials() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = Sender.chooseSenderToDo();
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
        return new ContainerToxicLooseMaterials(sender, homePort, weightNetto, tara, volume, certificateOfToxicLooseMaterials);
    }

    @Override
    public String toString() {
        return "Kontener na toksyczne materialy sypkie{" +
                getSender() +
                ", port nadania: " + getHomePort() +
                ", waga netto:  " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", objetosc: " + getVolume() +
                ", certyfikat: " + certificateOfToxicLoose +
                ", ID: " + getContainerID() +
                '}';
    }
}
