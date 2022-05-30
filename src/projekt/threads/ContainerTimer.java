package projekt.threads;

import projekt.model.Warehouse;
import projekt.model.konteners.ContainerPrimary;

import java.time.LocalDate;

public class ContainerTimer {
    private ContainerPrimary kontener;
    private Warehouse warehouse;
    private LocalDate dateOfArrival;
    private LocalDate deadline;

    public ContainerTimer(ContainerPrimary kontener, int daysInMagazine, Warehouse warehouse) {
        this.kontener = kontener;
        this.warehouse = warehouse;
        dateOfArrival = Timer.getDateInProgram();
        deadline = dateOfArrival.plusDays(daysInMagazine);
    }

    public void remove() {
        kontener.getSender().addWarning();
        warehouse.getListOfContainers().remove(kontener);
        ContainerPrimary.getContainerPrimaryList().remove(kontener);
    }

    public ContainerPrimary getKontener() {
        return kontener;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
}
