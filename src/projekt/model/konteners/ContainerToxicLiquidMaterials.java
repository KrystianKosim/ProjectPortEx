package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class ContainerToxicLiquidMaterials extends ContainerLiquidMaterials {
    private String cerificateOfToxicLiquidMaterials;

    protected ContainerToxicLiquidMaterials(Sender sender, String homePort, double weightNetto, double tara,
                                         double maxLitersOfLiquid, String cerificateOfToxicLiquidMaterials) {
        super(sender, homePort, weightNetto, tara, maxLitersOfLiquid);
        this.cerificateOfToxicLiquidMaterials = cerificateOfToxicLiquidMaterials;
    }

    public static ContainerToxicLiquidMaterials createContainerToxicLiquidMaterials() {
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
        return new ContainerToxicLiquidMaterials(sender, homePort, weightNetto, tara, maxLitersOfLiquid, cerificateOfToxicLiquidMaterials);
    }

    public static class Builder {
        private Sender sender;
        private String homePort;
        private double weightNetto;
        private double tara;
        private double maxLitersOfLiquid;
        private String cerificateOfToxicLiquidMaterials;

        public Builder sender(Sender sender) {
            this.sender = sender;
            return this;
        }

        public Builder homePort(String homePort) {
            this.homePort = homePort;
            return this;
        }

        public Builder weightNetto(double weightNetto) {
            this.weightNetto = weightNetto;
            return this;
        }

        public Builder tara(double tara) {
            this.tara = tara;
            return this;
        }

        public Builder maxLitersOfLiquid(double maxLitersOfLiquid) {
            this.maxLitersOfLiquid = maxLitersOfLiquid;
            return this;
        }

        public Builder cerificateOfToxicLiquidMaterials(String cerificateOfToxicLiquidMaterials){
            this.cerificateOfToxicLiquidMaterials = cerificateOfToxicLiquidMaterials;
            return this;
        }

        public ContainerToxicLiquidMaterials build() {
            return new ContainerToxicLiquidMaterials(sender, homePort, weightNetto, tara, maxLitersOfLiquid,cerificateOfToxicLiquidMaterials);
        }
    }

    @Override
    public String toString() {
        return "Kontener na toksyczne materialy ciekle{" + getSender() +
                ", port nadania: " + getHomePort() +
                ", waga netto: " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", max. poj. cieczy:  " + getMaxLitersOfLiquid() +
                ", certyfikat: " + cerificateOfToxicLiquidMaterials +
                ", ID: " + getContainerID() +
                '}';
    }
}

