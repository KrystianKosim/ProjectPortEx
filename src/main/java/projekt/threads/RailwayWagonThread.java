package projekt.threads;

public class RailwayWagonThread extends Thread {

    private int time;

    public RailwayWagonThread(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= time) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Czas " + i++);
        }

    }
}
