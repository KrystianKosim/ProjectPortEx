package projekt.generators;

import projekt.model.Warehouse;

public class WarehouseGenerator {
    public static void warehouseGenerator(){
        new Warehouse("Gdansk",10);
        new Warehouse("Szczecin",9);
        new Warehouse("Barcelona",20);
        new Warehouse("Szanghaj",50);

    }
}
