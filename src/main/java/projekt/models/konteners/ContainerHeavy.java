package main.java.projekt.models.konteners;

import main.java.projekt.models.Sender;

public class ContainerHeavy extends ContainerPrimary {
    private final double volume;

    protected ContainerHeavy(Sender sender, String homePort, double weightNetto, double tara, double volume) {
        super(sender, homePort, weightNetto, tara);
        this.volume = volume;
    }

    public static class Builder {
        private Sender sender;
        private String homePort;
        private double weightNetto;
        private double tara;
        private double volume;

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

        public Builder volume(double volume) {
            this.volume = volume;
            return this;
        }

        public ContainerHeavy build() {
            return new ContainerHeavy(sender, homePort, weightNetto, tara, volume);
        }
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Kontener ciezki{" + getSender() +
                ", port nadania: " + getHomePort() +
                ", waga netto: " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", objetosc: " + volume +
                ", ID: " + getContainerID() +
                '}';
    }
}
