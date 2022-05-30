package projekt.generators;

import projekt.model.Sender;
import projekt.model.konteners.*;

import java.util.List;

public class KontenersGenerator {

    public static void kontenerGenerator() {
        List<Sender> list = Sender.getSenderList();
        ContainerPrimary containerPrimary1 = new ContainerPrimary(list.get(0), "Gdansk", 2000, 120);
        ContainerHeavy containerHeavy1 = new ContainerHeavy(list.get(1), "Hamburg", 10000, 220, 303320);
        ContainerCooler kontenerCooler1 = new ContainerCooler(list.get(0), "Barcelona", 43232, 2312, 100, 1000);
        ContainerLiquidMaterials containerLiquidMaterials1 = new ContainerLiquidMaterials(list.get(2), "Karlskrona", 123000, 203, 10000);
        ContainerExplosiveMaterials containerExplosiveMaterials1 = new ContainerExplosiveMaterials(list.get(3), "Szanghaj", 90000, 500, 200, "XPP");
        ContainerToxicLooseMaterials kontenerToxicLooseMaterials1 = new ContainerToxicLooseMaterials(list.get(4), "Singapur", 9822, 122, 9999, "93-XAR");
        ContainerToxicLiquidMaterials kontenerToxicLiquidMaterials1 = new ContainerToxicLiquidMaterials(list.get(4), "Havre", 200000, 1222, 9801, "999-ASX");

    }

}
