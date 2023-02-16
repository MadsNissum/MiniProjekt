package ordination.ordination;

import ordination.ordination.DagligFast;
import ordination.ordination.Dosis;
import ordination.ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {


    private DagligFast dagligFast;

    @Test
    void TC1_samletDosisTest() {
        dagligFast = new DagligFast(null, null, new Patient("","",10), null, new double[]{1,0,0,0});

        Dosis[] doses = new Dosis[4];

        doses[0] = new Dosis(LocalTime.of(6, 0), 1);
        doses[1] = new Dosis(LocalTime.NOON, 0);
        doses[2] = new Dosis(LocalTime.of(18,0), 0);
        doses[3] = new Dosis(LocalTime.MIDNIGHT, 0);

        assertEquals(doses[0].getAntal(), dagligFast.getDoser()[0].getAntal());
        assertEquals(doses[1].getAntal(), dagligFast.getDoser()[1].getAntal());
        assertEquals(doses[2].getAntal(), dagligFast.getDoser()[2].getAntal());
        assertEquals(doses[3].getAntal(), dagligFast.getDoser()[3].getAntal());
    }

    @Test
    void TC2_samletDosisTest() {
        dagligFast = new DagligFast(null, null, new Patient("","",10), null, new double[]{-1,0,0,0});

        Dosis[] doses = new Dosis[4];

        doses[0] = new Dosis(LocalTime.of(6, 0), 0);
        doses[1] = new Dosis(LocalTime.NOON, 0);
        doses[2] = new Dosis(LocalTime.of(18,0), 0);
        doses[3] = new Dosis(LocalTime.MIDNIGHT, 0);

        assertEquals(doses[0].getAntal(), dagligFast.getDoser()[0].getAntal());
        assertEquals(doses[1].getAntal(), dagligFast.getDoser()[1].getAntal());
        assertEquals(doses[2].getAntal(), dagligFast.getDoser()[2].getAntal());
        assertEquals(doses[3].getAntal(), dagligFast.getDoser()[3].getAntal());
    }
}