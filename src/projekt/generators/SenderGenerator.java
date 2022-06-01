package projekt.generators;

import projekt.model.Sender;

public class SenderGenerator {
    public static void sendersGenerator() {
        new Sender.Builder()
                .name("Jan")
                .surname("Kowalski")
                .pesel("00221110231")
                .address("Warszawa")
                .build();
        new Sender.Builder()
                .name("Adam")
                .surname("Nowak")
                .pesel("92111211111")
                .address("Gdansk")
                .build();
        new Sender.Builder()
                .surname("Lewandowska")
                .name("Anna")
                .address("Krakow")
                .pesel("80082212321")
                .build();
        new Sender.Builder()
                .name("Katarzyna")
                .surname("Zielinska")
                .pesel("03210398732")
                .address("Wroclaw")
                .build();
        new Sender.Builder()
                .name("Joanna")
                .surname("Zielinska")
                .pesel("64110135946")
                .address("Lublin")
                .build();
        new Sender.Builder()
                .name("Ewelina")
                .surname("Kaminska")
                .pesel("57021832873")
                .address("Bialystok")
                .build();
        new Sender.Builder()
                .name("Robert")
                .surname("Jankowski")
                .pesel("02230224915")
                .address("Rzeszow")
                .build();
        new Sender.Builder()
                .name("Krystian")
                .surname("Szymanski")
                .pesel("97110919368")
                .address("Kielce")
                .build();
        new Sender.Builder()
                .name("Karolina")
                .surname("Nowicka")
                .pesel("99091688259")
                .address("Olsztyn")
                .build();
        new Sender.Builder()
                .name("Alicja")
                .surname("Pawlak")
                .pesel("92051627271")
                .address("Warszawa")
                .build();
        new Sender.Builder()
                .name("Krzysztof")
                .surname("Kaczmarek")
                .pesel("00222783637")
                .address("Kalisz")
                .build();
        new Sender.Builder()
                .name("Marcin")
                .surname("Krawczyk")
                .pesel("96071547485")
                .address("Opole")
                .build();
        new Sender.Builder()
                .name("Mariusz")
                .surname("Dudek")
                .pesel("75031596817")
                .address("Tychy")
                .build();
        new Sender.Builder()
                .name("Maciej")
                .surname("Zalewski")
                .pesel("86012831528")
                .address("Poznan")
                .build();
        new Sender.Builder()
                .name("Arkadiusz")
                .surname("Borkowski")
                .pesel("71040663847")
                .address("Szczecin")
                .build();
        new Sender.Builder()
                .name("Patryk")
                .surname("Jakubowski")
                .pesel("47080598874")
                .address("Katowice")
                .build();
    }
}
