package main.java.projekt.models.konteners;

import main.java.projekt.models.Sender;

public class ContainerToxicLooseMaterials extends ContainerHeavy {
    private final String certificateOfToxicLoose;

    protected ContainerToxicLooseMaterials(Sender sender, String homePort, double weightNetto, double tara,
                                           double volume, String certificateOfToxicLoose) {
        super(sender, homePort, weightNetto, tara, volume);
        this.certificateOfToxicLoose = certificateOfToxicLoose;
    }

    public static class Builder {
        private Sender sender;
        private String homePort;
        private double weightNetto;
        private double tara;
        private double volume;
        private String certificateOfToxicLoose;

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

        public Builder certificateOfToxicLoose(String certificateOfToxicLoose) {
            this.certificateOfToxicLoose = certificateOfToxicLoose;
            return this;
        }

        public ContainerToxicLooseMaterials build() {
            return new ContainerToxicLooseMaterials(sender, homePort, weightNetto, tara, volume, certificateOfToxicLoose);
        }
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
