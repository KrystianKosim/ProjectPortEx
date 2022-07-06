package main.java.projekt.models.konteners;

import main.java.projekt.models.Sender;

public class ContainerLiquidMaterials extends ContainerPrimary {
    private final double maxLitersOfLiquid;

    protected ContainerLiquidMaterials(Sender sender, String homePort, double weightNetto, double tara, double maxLitersOfLiquid) {
        super(sender, homePort, weightNetto, tara);
        this.maxLitersOfLiquid = maxLitersOfLiquid;
    }

    public static class Builder {
        private Sender sender;
        private String homePort;
        private double weightNetto;
        private double tara;
        private double maxLitersOfLiquid;

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

        public ContainerLiquidMaterials build() {
            return new ContainerLiquidMaterials(sender, homePort, weightNetto, tara, maxLitersOfLiquid);
        }
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
