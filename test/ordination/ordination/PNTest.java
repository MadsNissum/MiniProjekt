package ordination.ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PNTest {

    private PN pn;

    @BeforeEach
    void setup() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");
        pn = new PN(LocalDate.of(2023, 2, 10), LocalDate.of(2023,2,20), patient, laegemiddel, 5);
    }

    @Test
    void TC1_givDosis() {
        boolean result = pn.givDosis(LocalDate.of(2023, 2, 15));

        assertTrue(result);
    }

    @Test
    void TC2_givDosis() {
        boolean result = pn.givDosis(LocalDate.of(1500, 1, 1));

        assertFalse(result);
    }

    @Test
    void TC3_givDosis() {
        boolean result = pn.givDosis(null);

        assertFalse(result);
    }


}
