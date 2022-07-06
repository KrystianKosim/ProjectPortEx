package projekt.generators;

import projekt.models.Sender;
import projekt.models.konteners.*;

import java.util.List;

public class KontenersGenerator {

    public static void kontenerGenerator() {
        List<Sender> senders = Sender.getSenderList();
        new ContainerPrimary.Builder()
                .sender(senders.get(0))
                .homePort("Gdansk")
                .weightNetto(2000)
                .tara(120)
                .build();
        new ContainerHeavy.Builder()
                .sender(senders.get(1))
                .homePort("Hamburg")
                .weightNetto(10000)
                .tara(220)
                .volume(303320)
                .build();
        new ContainerCooler.Builder()
                .sender(senders.get(0))
                .homePort("Barcelona")
                .weightNetto(43232)
                .tara(2312)
                .volume(100)
                .powerOfElectricityInstalation(1000)
                .build();
        new ContainerLiquidMaterials.Builder()
                .sender(senders.get(2))
                .homePort("Karlskrona")
                .weightNetto(123000)
                .tara(203)
                .maxLitersOfLiquid(10000)
                .build();
        new ContainerExplosiveMaterials.Builder()
                .sender(senders.get(3))
                .homePort("Szanghaj")
                .weightNetto(90000)
                .tara(500)
                .volume(300)
                .certificate("XPP")
                .build();
        new ContainerToxicLooseMaterials.Builder()
                .sender(senders.get(4))
                .homePort("Singapur")
                .weightNetto(9822)
                .tara(122)
                .volume(9999)
                .certificateOfToxicLoose("93-XAR")
                .build();
        new ContainerToxicLiquidMaterials.Builder()
                .sender(senders.get(4))
                .homePort("Havre")
                .weightNetto(200000)
                .tara(1222)
                .maxLitersOfLiquid(9801)
                .cerificateOfToxicLiquidMaterials("999-ASX")
                .build();
    }

}
