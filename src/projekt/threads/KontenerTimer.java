package projekt.threads;

import projekt.model.konteners.KontenerPrimary;
import projekt.model.Warehouse;

import java.time.LocalDate;

public class KontenerTimer {
    private KontenerPrimary kontener;
    private Warehouse warehouse;
    private LocalDate dateOfArrival;
    private LocalDate deadline;

    public KontenerTimer(KontenerPrimary kontener, int daysInMagazine, Warehouse warehouse) {
        this.kontener = kontener;
        this.warehouse = warehouse;
        dateOfArrival = Timer.getDateInProgram();
        deadline = dateOfArrival.plusDays(daysInMagazine);
    }

    public void remove() {
        kontener.getSender().addWarning();
        warehouse.getListOfKonteners().remove(kontener);
        KontenerPrimary.getKontenerPrimaryList().remove(kontener);
    }

    public KontenerPrimary getKontener() {
        return kontener;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
}
