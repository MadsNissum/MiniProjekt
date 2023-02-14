package ordination.ordination;

import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class DagligSkaev extends Ordination {

    // Link to Dosis
    private final ArrayList<Dosis> dosisListe = new ArrayList<>();

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(dosisListe);
    }

    // Methods
    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        dosisListe.add(dosis);
    }

    @Override
    public double samletDosis() {
        double antalDoser = 0;
        for (Dosis d : dosisListe) {
            antalDoser += d.getAntal();
        }
        return antalDoser;
    }

    @Override
    public double doegnDosis() {

        return samletDosis()/DAYS.between(getStartDen(), getSlutDen());
    }

    @Override
    public String getType() {
        return null;
    }

}
