package main.java.projekt.models;

import main.java.projekt.services.SenderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sender {
    private final String name;
    private final String surname;
    private final String pesel;
    private final String address;
    private final LocalDate birthDate;
    private int warnings;
    private static final List<Sender> senderList = new ArrayList<>();

    private Sender(String name, String surname, String pesel, String address) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
        this.birthDate = SenderService.getAge(pesel);
        warnings = 0;
        senderList.add(this);
    }

    public static class Builder {
        private String name;
        private String surname;
        private String pesel;
        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder pesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Sender build() {
            return new Sender(name, surname, pesel, address);
        }
    }

    public void addWarning() {
        warnings++;
    }

    public static List<Sender> getSenderList() {
        return senderList;
    }

    public int getWarnings() {
        return warnings;
    }

    @Override
    public String toString() {
        return "Nadawca{" +
                "Imie: " + name +
                ", nazwisko: " + surname +
                ", pesel: " + pesel +
                ", adres: " + address +
                ", data urodzenia: " + birthDate +
                ", ostrzezenia: " + warnings +
                '}';
    }
}

