package ordination.ordination;

public class DagligFast extends Ordination {

    private Dosis[] doser = new Dosis[4];

    public Dosis[] getDoser() {
        return doser;
    }

    public void setDoser(Dosis[] doser) {
        this.doser = doser;
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
