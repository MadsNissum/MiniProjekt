package ordination.ordination;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class PN extends Ordination{

    private double antalEnheder;
    private ArrayList<LocalDate> datoer = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, double antal) {
        super(startDen, slutDen, patient, laegemiddel);
        this.antalEnheder = antal;
    }


    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        if (givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen()) ||
                givesDen.isEqual(getStartDen()) && givesDen.isEqual(getSlutDen())) {
            datoer.add(givesDen);
            return true;
        }
        return false;
    }

    public double doegnDosis() {
        return (samletDosis()*antalEnheder)/DAYS.between(getStartDen(), getSlutDen());
    }

    @Override
    public String getType() {
        return "PN Ordination";
    }

    public double samletDosis() {
        return getAntalEnheder()*antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return datoer.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
