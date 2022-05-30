package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class KontenerToxicLiquidMaterials extends KontenerLiquidMaterials {
    private String cerificateOfToxicLiquidMaterials;

    public KontenerToxicLiquidMaterials(Sender sender, String homePort, double weightNetto, double tara,
                                        double maxLitersOfLiquid, String cerificateOfToxicLiquidMaterials) {
        super(sender, homePort, weightNetto, tara, maxLitersOfLiquid);
        this.cerificateOfToxicLiquidMaterials = cerificateOfToxicLiquidMaterials;
    }

    public static KontenerToxicLiquidMaterials createKontenerToxicLiquidMaterials() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = Sender.chooseSenderToDo();
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
        return new KontenerToxicLiquidMaterials(sender, homePort, weightNetto, tara, maxLitersOfLiquid, cerificateOfToxicLiquidMaterials);
    }

    @Override
    public String toString() {
        return "Kontener na toksyczne materialy ciekle{" +
                getSender() +
                ", port nadania: " + getHomePort() +
                ", waga netto: " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", max. poj. cieczy:  " + getMaxLitersOfLiquid() +
                ", certyfikat: " + cerificateOfToxicLiquidMaterials +
                ", ID: " + getKontenerID() +
                '}';
    }
}

