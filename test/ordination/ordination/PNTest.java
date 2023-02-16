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


    // Ordination test
    @Test
    void TC1_antalDage() {
        //Arrange
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");
        pn = new PN(LocalDate.of(2023, 2, 20), LocalDate.of(2023,2,27), patient, laegemiddel, 5);

        //Act
        int result = pn.antalDage();

        //Assert
        int forventetAntal = 7;
    }

    @Test
    void TC2_antalDage() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");
        pn = new PN(LocalDate.of(2023, 2, 27), LocalDate.of(2023,2,20), patient, laegemiddel, 5);

        //Act
        int result = pn.antalDage();

        //Assert
        int forventetAntal = 7;
    }

    @Test
    void TC3_antalDage() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");
        pn = new PN(null, LocalDate.of(2023,2,20), patient, laegemiddel, 5);

        //Act
        Exception exception = assertThrows(RuntimeException.class, ()-> {
            pn.antalDage();
        });

        //Assert
        assertEquals("Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"temporal1Inclusive\" is null", exception.getMessage());
    }

}
