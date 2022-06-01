package projekt.generators;

import projekt.model.Warehouse;

public class WarehouseGenerator {
    public static void warehouseGenerator() {
        new Warehouse.Builder()
                .city("Gdansk")
                .maxContainers(10)
                .build();
        new Warehouse.Builder()
                .city("Szczecin")
                .maxContainers(9)
                .build();
        new Warehouse.Builder()
                .city("Barcelona")
                .maxContainers(20)
                .build();
        new Warehouse.Builder()
                .city("Szanghaj")
                .maxContainers(50)
                .build();
    }
}
