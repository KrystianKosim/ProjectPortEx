package projekt.generators;

import projekt.model.Ship;

public class ShipGenerator {
    public static void shipGenerator(){
        Ship ship1 = new Ship("Felicity","Gdansk","Algeciras","Havre",90,50,20,10,10,2952330);
        Ship ship2 = new Ship("Cabot","Szanghaj","Singapur","Szczecin",150,100,5,15,5,932000);
        Ship ship3 = new Ship("Investigator","Hamburg","Triest","Karlskrona",123,20,20,10,10,12000000);
        Ship ship4 = new Ship("Polruan","Karlskrona","Hamburg","Barcelona",100,10,10,70,5,5000000);
        Ship ship5 = new Ship("Amelia","Barcelona","Barcelona","Szanghaj",90,50,20,10,10,2000000);
    }
}
