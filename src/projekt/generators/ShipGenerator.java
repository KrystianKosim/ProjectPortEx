package projekt.generators;

import projekt.model.Ship;

public class ShipGenerator {
    public static void shipGenerator() {
        new Ship.Builder()
                .name("Felicity")
                .nameOfHomePort("Gdansk")
                .transportFrom("Algeciras")
                .transportTo("Havre")
                .maximumOfEveryContainers(90)
                .maximumOfHeavyKonteners(50)
                .maximumOfCoolerKonteners(20)
                .maximumOfLiquidMaterialsKonteners(10)
                .maximumOfToxicKontenres(10)
                .maximumWeight(2952330)
                .build();
        new Ship.Builder()
                .name("Cabot")
                .nameOfHomePort("Szanghaj")
                .transportFrom("Singapur")
                .transportTo("Szczecin")
                .maximumWeight(932000)
                .maximumOfEveryContainers(150)
                .maximumOfHeavyKonteners(100)
                .maximumOfCoolerKonteners(5)
                .maximumOfLiquidMaterialsKonteners(15)
                .maximumOfToxicKontenres(5)
                .build();
        new Ship.Builder()
                .name("Investigator")
                .nameOfHomePort("Hamburg")
                .transportFrom("Triest")
                .transportTo("Karlskrona")
                .maximumOfEveryContainers(123)
                .maximumOfHeavyKonteners(20)
                .maximumOfCoolerKonteners(20)
                .maximumOfLiquidMaterialsKonteners(10)
                .maximumOfToxicKontenres(10)
                .maximumWeight(12000000)
                .build();
        new Ship.Builder()
                .name("Polruan")
                .nameOfHomePort("Karlskrona")
                .transportFrom("Hamburg")
                .transportTo("Barcelona")
                .maximumOfEveryContainers(100)
                .maximumOfHeavyKonteners(10)
                .maximumOfCoolerKonteners(10)
                .maximumOfLiquidMaterialsKonteners(70)
                .maximumOfToxicKontenres(5)
                .maximumWeight(5000000)
                .build();
        new Ship.Builder()
                .name("Amelia")
                .nameOfHomePort("Barcelona")
                .transportFrom("Barcelona")
                .transportTo("Szanghaj")
                .maximumOfEveryContainers(90)
                .maximumOfHeavyKonteners(50)
                .maximumOfCoolerKonteners(20)
                .maximumOfLiquidMaterialsKonteners(10)
                .maximumOfToxicKontenres(10)
                .maximumWeight(2000000)
                .build();
    }
}
