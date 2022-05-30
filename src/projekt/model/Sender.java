package projekt.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sender {
    private String name;
    private String surname;
    private String pesel;
    private String address;
    private LocalDate birthDate;
    private int warnings;
    private static List<Sender> senderList = new ArrayList<>();

    public Sender(String name, String surname, String pesel, String address) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
        this.birthDate = getAge();
        warnings = 0;
        senderList.add(this);
    }

    public LocalDate getAge() {
        int year = getIntFromString(pesel.substring(0, 2));
        int month = getIntFromString(pesel.substring(2, 4));
        int day = getIntFromString(pesel.substring(4, 6));

        if (month > 12) {
            month -= 20;
            year += 2000;
        } else {
            if (year % 10 == 0) {
                year /= 2;
            }
            year += 1900;
        }

        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    static int getIntFromString(String stringText) {
        int valToReturn = 0;
        int valFromSwitch = 0;
        int count = 0;
        while (count <= 1) {
            switch (stringText.charAt(count)) {
                case '0':
                    break;
                case '1':
                    valFromSwitch = 1;
                    break;
                case '2':
                    valFromSwitch = 2;
                    break;
                case '3':
                    valFromSwitch = 3;
                    break;
                case '4':
                    valFromSwitch = 4;
                    break;
                case '5':
                    valFromSwitch = 5;
                    break;
                case '6':
                    valFromSwitch = 6;
                    break;
                case '7':
                    valFromSwitch = 7;
                    break;
                case '8':
                    valFromSwitch = 8;
                    break;
                case '9':
                    valFromSwitch = 9;
                    break;
            }
            if (count == 0) {
                valFromSwitch *= 10;
                valToReturn = valFromSwitch;
            } else {
                valToReturn += valFromSwitch;
            }
            count++;
        }
        return valToReturn;
    }

    public static Sender chooseSenderToDo() {
        optionsToDo();
        int decisionVariable = new Scanner(System.in).nextInt();
        Sender senderToReturn = null;
        while (senderToReturn == null) {
            switch (decisionVariable) {
                case 0:
                    break;
                case 1:
                    senderToReturn = chooseSender();
                    break;
                case 2:
                    senderToReturn = createSender();
                    break;
            }
        }
        return senderToReturn;
    }

    private static Sender createSender() {
        System.out.println("Podaj imie nadawcy");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Podaj nazwisko nadawcy");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("Podaj pesel nadawcy");
        String pesel = new Scanner(System.in).nextLine();
        System.out.println("Podaj adres nadawcy");
        String address = new Scanner(System.in).nextLine();
        return new Sender(name, surname, pesel, address);
    }

    private static Sender chooseSender() {
        if (!senderList.isEmpty()) {
            showSendersList();
            Scanner scan = new Scanner(System.in);
            int decisionVariable = scan.nextInt();
            Sender senderToReturn;
            while (!(decisionVariable >= 0 && decisionVariable < senderList.size())) {
                System.out.println("Bledny numer nadawcy, wproawdz ponownie numer nadawcy");
                decisionVariable = scan.nextInt();
            }
            senderToReturn = senderList.get(decisionVariable);
            return senderToReturn;
        } else {
            System.out.println("Nie ma zadnego nadawcy,trzeba utworzyc nowego nadawce");
            return createSender();
        }
    }

    private static void showSendersList() {
        for (int i = 0; i < senderList.size(); i++) {
            System.out.println(i + " " + senderList.get(i));
        }
    }

    private static void optionsToDo() {
        List<String> list = new ArrayList<>();
        list.add("Wyjdz");
        list.add("Wybierz istniejacego nadawce");
        list.add("Utworz nowego nadawce");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " - " + list.get(i) + "  ");
        }
    }

    public int getWarnings() {
        return warnings;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }

    public static List<Sender> getSenderList() {
        return senderList;
    }

    @Override
    public String toString() {
        return "Nadawca{" +
                "Imie: " + name +
                ", nazwisko: " + surname +
                ", pesel: " + pesel +
                ", adres: " + address +
                ", data urodzenia: " + birthDate +
                '}';
    }
}

