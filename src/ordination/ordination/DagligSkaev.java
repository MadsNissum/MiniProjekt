package ordination.ordination;

import ordination.gui.TypeOrdination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    private TypeOrdination typeOrdination;

    // Link to Dosis
    private final ArrayList<Dosis> dosisListe = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, LocalTime[] klokkeSlet, double[] antalEnheder) {
        super(startDen, slutDen, patient, laegemiddel);
        for (int i = 0; i < klokkeSlet.length; i++) {
            opretDosis(klokkeSlet[i], antalEnheder[i]);
        }
    }

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
    public String getType() {
        return typeOrdination.toString();
    }
    public void setTypeOrdination(TypeOrdination typeOrdination) {
        this.typeOrdination = typeOrdination;
    }
}
