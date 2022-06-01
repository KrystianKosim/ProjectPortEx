package projekt.models.konteners;

import projekt.models.Sender;

import java.util.ArrayList;
import java.util.List;

public class ContainerPrimary {
    /**
     * name z String zmienione na Sender, zmienic metody tworzenia kontenerow
     */
    private final Sender sender;
    private final String homePort;
    private final double weightNetto;
    private final double tara;
    private final double weighBrutto;
    private final int containerID;
    private static int id = 0;
    private static final List<ContainerPrimary> containerPrimaryList = new ArrayList<>();

    protected ContainerPrimary(Sender sender, String homePort, double weightNetto, double tara) {
        this.sender = sender;
        this.homePort = homePort;
        this.weightNetto = weightNetto;
        this.tara = tara;
        weighBrutto = weightNetto + tara;
        containerID = id++;
        containerPrimaryList.add(this);
    }

    public static class Builder {
        private Sender sender;
        private String homePort;
        private double weightNetto;
        private double tara;

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

        public ContainerPrimary build() {
            return new ContainerPrimary(sender, homePort, weightNetto, tara);
        }
    }


    public String getHomePort() {
        return homePort;
    }

    public double getWeightNetto() {
        return weightNetto;
    }

    public double getTara() {
        return tara;
    }

    public int getContainerID() {
        return containerID;
    }

    public double getWeighBrutto() {
        return weighBrutto;
    }

    public Sender getSender() {
        return sender;
    }

    public static List<ContainerPrimary> getContainerPrimaryList() {
        return containerPrimaryList;
    }

    @Override
    public String toString() {
        return "Kontener podstawowy{" + sender +
                ", port nadania: " + homePort +
                ", waga netto: " + weightNetto +
                ", tara: " + tara +
                ", waga brutto: " + weighBrutto +
                ", ID: " + containerID +
                '}';
    }
}
