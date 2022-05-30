package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class ContainerExplosiveMaterials extends ContainerHeavy {
    private String certificate;

    public ContainerExplosiveMaterials(Sender sender, String homePort, double weightNetto, double tara,
                                       double volume, String cerficate) {
        super(sender, homePort, weightNetto, tara, volume);
        this.certificate = cerficate;
    }

    public static ContainerExplosiveMaterials createContainerExplosiveMaterials() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = Sender.chooseSenderToDo();
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
        return new ContainerExplosiveMaterials(sender, homePort, weightNetto, tara, volume, certificate);
    }

    @Override
    public String toString() {
        return "Kontener na materialy wybuchowe{" + getSender() +
                ", port nadania " + getHomePort() +
                ", waga netto: " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", objetosc: " + getVolume() +
                ", certyfikat: " + certificate +
                ", ID: " + getContainerID() +
                '}';
    }
}
