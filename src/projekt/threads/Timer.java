package projekt.threads;

import java.time.LocalDate;

public class Timer extends Thread {

    private static int days = 0;
    private static LocalDate dateInProgram = LocalDate.now();

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
                dateInProgram = dateInProgram.plusDays(1);
                days++;
//                System.out.print("\n" + dateInProgram + " Dni " + days);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getDays() {
        return days;
    }

    public static LocalDate getDateInProgram() {
        return dateInProgram;
    }
}
