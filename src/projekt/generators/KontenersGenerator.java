package projekt.generators;

import projekt.model.Sender;
import projekt.model.konteners.*;

import java.util.List;

public class KontenersGenerator {

    public static void kontenerGenerator() {
        List<Sender> list = Sender.getSenderList();
        KontenerPrimary kontenerPrimary1 = new KontenerPrimary(list.get(0), "Gdansk", 2000, 120);
        KontenerHeavy kontenerHeavy1 = new KontenerHeavy(list.get(1), "Hamburg", 10000, 220, 303320);
        KontenerCooler kontenerCooler1 = new KontenerCooler(list.get(0), "Barcelona", 43232, 2312, 100, 1000);
        KontenerLiquidMaterials kontenerLiquidMaterials1 = new KontenerLiquidMaterials(list.get(2), "Karlskrona", 123000, 203, 10000);
        KontenerExplosiveMaterials kontenerExplosiveMaterials1 = new KontenerExplosiveMaterials(list.get(3), "Szanghaj", 90000, 500, 200, "XPP");
        KontenerToxicLooseMaterials kontenerToxicLooseMaterials1 = new KontenerToxicLooseMaterials(list.get(4), "Singapur", 9822, 122, 9999, "93-XAR");
        KontenerToxicLiquidMaterials kontenerToxicLiquidMaterials1 = new KontenerToxicLiquidMaterials(list.get(4), "Havre", 200000, 1222, 9801, "999-ASX");

    }

}
