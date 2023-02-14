package ordination.ordination;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class PN extends Ordination{

    private double antalEnheder;
    private int antalGivet;
    private ArrayList<LocalDate> datoer;

    public PN(double antalEnheder, ArrayList<LocalDate> datoer) {
        this.antalEnheder = antalEnheder;
        this.datoer = datoer;
        this.antalGivet = 0;
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
        return samletDosis()/DAYS.between(getStartDen(), getSlutDen());
    }

    @Override
    public String getType() {
        return null;
    }

    public double samletDosis() {
        return getAntalGangeGivet()*antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return-1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
