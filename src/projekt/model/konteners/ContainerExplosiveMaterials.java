package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class ContainerExplosiveMaterials extends ContainerHeavy {
    private String certificate;

    protected ContainerExplosiveMaterials(Sender sender, String homePort, double weightNetto, double tara,
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

        public Builder volume(double volume){
            this.volume = volume;
            return this;
        }

        public Builder certificate(String certificate){
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
