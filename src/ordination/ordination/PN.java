package ordination.ordination;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class PN extends Ordination{

    private double antalEnheder;


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
        return antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return-1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
