package ordination.ordination;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Ordination {
    private final LocalDate startDen;
    private final LocalDate slutDen;

    private Laegemiddel laegemiddel;

    public Ordination(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel) {
        this.startDen = startDen;
        this.slutDen = slutDen;
        this.laegemiddel = laegemiddel;
        patient.addOrdination(this);
    }

    public Laegemiddel getLaegemiddel() {
        return laegemiddel;
    }
    public void setLaegemiddel(Laegemiddel laegemiddel) {
        if (this.laegemiddel != laegemiddel) {
            this.laegemiddel = laegemiddel;
        }
    }
    public LocalDate getStartDen() {
        return startDen;
    }	

    public LocalDate getSlutDen() {
        return slutDen;
    }

    /**
     * Antal hele dage mellem startdato og slutdato. Begge dage inklusive.
     * @return antal dage ordinationen gælder for
     */
    public int antalDage() {
        return (int) DAYS.between(startDen, slutDen) + 1;
    }

    @Override
    public String toString() {
        return startDen.toString();
    }

    /**
     * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     */
    public abstract double samletDosis();

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     */
    public double doegnDosis() {
        return samletDosis()/antalDage();
    }

    /**
     * Returnerer ordinationstypen som en String
     */
    public abstract String getType();
}
