package ordination.ordination;

import java.time.LocalTime;

public class DagligFast extends Ordination {

    private Dosis[] doser = new Dosis[4];

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
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
    // TODO
}
