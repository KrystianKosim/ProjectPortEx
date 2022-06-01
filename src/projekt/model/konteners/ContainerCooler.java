package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class ContainerCooler extends ContainerHeavy {
    private final double powerOfElectricityInstalation;

    protected ContainerCooler(Sender sender, String homePort, double weightNetto, double tara, double volume, double powerOfElectricityInstalation) {
        super(sender, homePort, weightNetto, tara, volume);
        this.powerOfElectricityInstalation = powerOfElectricityInstalation;
    }

    public static ContainerCooler createContainerCooler() {
        Scanner scanK = new Scanner(System.in);
        System.out.println("Nadawca");
        Sender sender = Sender.chooseSenderToDo();
        System.out.println("Podaj portnadania");
        String homePort = scanK.nextLine();
        System.out.println("Podaj wage netto");
        double weightNetto = scanK.nextDouble();
        System.out.println("Podaj tare");
        double tara = scanK.nextDouble();
        System.out.println("Podaj objetosc");
        double volume = scanK.nextDouble();
        System.out.println("Podaj moc instalacji elektrycznej");
        double powerOfElectricityInstalation = scanK.nextDouble();
        return new ContainerCooler(sender, homePort, weightNetto, tara, volume, powerOfElectricityInstalation);
    }

    public static class Builder {
        private Sender sender;
        private String homePort;
        private double weightNetto;
        private double tara;
        private double volume;
        private double powerOfElectricityInstalation;

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

        public Builder powerOfElectricityInstalation(double powerOfElectricityInstalation) {
            this.powerOfElectricityInstalation = powerOfElectricityInstalation;
            return this;
        }

        public ContainerCooler build() {
            return new ContainerCooler(sender, homePort, weightNetto, tara, volume, powerOfElectricityInstalation);
        }
    }

    @Override
    public String toString() {
        return "Kontener chlodzacy{" + getSender() +
                ", port nadania: " + getHomePort() +
                ", waga netto: " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", objetosc: " + getVolume() +
                ", moc instalacji elektrycznej: " + powerOfElectricityInstalation +
                ", ID: " + getContainerID() +
                '}';
    }
}

