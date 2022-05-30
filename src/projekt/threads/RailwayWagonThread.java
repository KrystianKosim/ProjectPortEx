package projekt.threads;

public class RailwayWagonThread extends Thread{

    int time;

    public RailwayWagonThread(int time){
        this.time = time;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= time) {
            try{
                /**
                 * sleep(1000)
                 */
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Czas " + i++);
        }

    }
}
