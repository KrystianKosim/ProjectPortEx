package projekt.models.konteners;

import projekt.models.Sender;

public class ContainerExplosiveMaterials extends ContainerHeavy {
    private final String certificate;

    protected ContainerExplosiveMaterials(Sender sender, String homePort, double weightNetto, double tara,
                                          double volume, String cerficate) {
        super(sender, homePort, weightNetto, tara, volume);
        this.certificate = cerficate;
    }

    public static class Builder {
        private Sender sender;
        private String homePort;
        private double weightNetto;
        private double tara;
        private double volume;
        private String certificate;

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

        public Builder certificate(String certificate) {
            this.certificate = certificate;
            return this;
        }

        public ContainerExplosiveMaterials build() {
            return new ContainerExplosiveMaterials(sender, homePort, weightNetto, tara, volume, certificate);
        }
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
