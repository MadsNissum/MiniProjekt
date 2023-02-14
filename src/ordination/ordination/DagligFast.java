package ordination.ordination;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class DagligFast extends Ordination {

    private final Dosis[] doser = new Dosis[4];

    public Dosis[] getDoser() {
        return doser;
    }

    public void createDoser(double[] doser) {
       this.doser[0] = new Dosis(LocalTime.of(6, 0), doser[0]);
       this.doser[1] = new Dosis(LocalTime.NOON, doser[1]);
       this.doser[2] = new Dosis(LocalTime.of(18,0), doser[2]);
       this.doser[3] = new Dosis(LocalTime.MIDNIGHT, doser[3]);
    }

    @Override
    public double samletDosis() {
        double samletDosis = 0;
        for (Dosis dosis : doser) {
            samletDosis += dosis.getAntal();
        }
        return samletDosis;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / DAYS.between(getStartDen(), getSlutDen());
    }

    @Override
    public String getType() {
        return "Fast Ordination";
    }
}
