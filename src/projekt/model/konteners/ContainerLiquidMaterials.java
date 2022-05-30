package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class ContainerLiquidMaterials extends ContainerPrimary {
    private double maxLitersOfLiquid;

    public ContainerLiquidMaterials(Sender sender, String homePort, double weightNetto, double tara, double maxLitersOfLiquid) {
        super(sender, homePort, weightNetto, tara);
        this.maxLitersOfLiquid = maxLitersOfLiquid;
    }

    public static ContainerLiquidMaterials createContainerLiquid() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = Sender.chooseSenderToDo();
        System.out.println("Podaj port nadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        System.out.println("Maksymalna pojemnosc w litrach");
        double maxLitersOfLiquid = scanK.nextDouble();
        return new ContainerLiquidMaterials(sender, homePort, weightNetto, tara, maxLitersOfLiquid);
    }

    public double getMaxLitersOfLiquid() {
        return maxLitersOfLiquid;
    }

    @Override
    public String toString() {
        return "Kontener na ciekle materialy{" + getSender() +
                ", port nadania: " + getHomePort() +
                ", waga netto: " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", max. poj. cieczy: " + maxLitersOfLiquid +
                ", ID: " + getContainerID() +
                '}';
    }
}
