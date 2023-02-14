package ordination.ordination;

import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    // TODO

    // Link to Dosis
    private final ArrayList<Dosis> dosisListe = new ArrayList<>();

    public ArrayList<Dosis> getDosisListe() {
        return new ArrayList<>(dosisListe);
    }

    // Methods
    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        dosisListe.add(dosis);
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
}
