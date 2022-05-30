package projekt.model.konteners;

import projekt.model.Sender;

import java.util.Scanner;

public class KontenerHeavy extends KontenerPrimary {
    private double volume;

    public KontenerHeavy(Sender sender, String homePort, double weightNetto, double tara, double volume) {
        super(sender, homePort, weightNetto, tara);
        this.volume = volume;
    }

    public static KontenerHeavy createKontenerHeavy() {
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
        return new KontenerHeavy(sender, homePort, weightNetto, tara, volume);
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Kontener ciezki{" +
                getSender() +
                ", port nadania: " + getHomePort() +
                ", waga netto: " + getWeightNetto() +
                ", tara: " + getTara() +
                ", waga brutto: " + getWeighBrutto() +
                ", objetosc: " + volume +
                ", ID: " + getKontenerID() +
                '}';
    }
}
