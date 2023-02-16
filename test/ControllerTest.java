import ordination.controller.Controller;
import ordination.ordination.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setup() {
        controller = Controller.getTestController();
    }

    @Test
    void TC1_anbefaletDosis_Let() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        double result = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        assertEquals(10, result);
    }

    @Test
    void TC2_anbefaletDosis_normalLavGraense() {
        Patient patient = new Patient("", "", 25);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        double result = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        assertEquals(37.5, result);
    }

    @Test
    void TC3_anbefaletDosis_normalHoejGraense() {
        Patient patient = new Patient("", "", 120);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        double result = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        assertEquals(180, result);
    }

    @Test
    void TC4_anbefaletDosis_tung() {
        Patient patient = new Patient("", "", 130);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        double result = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        assertEquals(260, result);
    }


    @Test
    void TC1_opretPNOrdiantion() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");


        PN result = controller.opretPNOrdination(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 14), patient, laegemiddel, 10);

        assertEquals(0, result.samletDosis());
        assertEquals(14, result.antalDage());
    }

    @Test
    void TC2_opretPNOrdiantion_exception() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");


        Exception exception = assertThrows(RuntimeException.class, () -> {
            controller.opretPNOrdination(LocalDate.of(2023, 1, 14), LocalDate.of(2023, 1, 1), patient, laegemiddel, 10);
        });

        assertEquals("Slutdato ligger efter startdato", exception.getMessage());
    }

    @Test
    void TC1_opretDagligFastOrdiantion() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        DagligFast result = controller.opretDagligFastOrdination(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 14), patient, laegemiddel, new double[]{1,3,4,0});

        assertEquals(8, result.samletDosis());
        assertEquals(14, result.antalDage());
    }

    @Test
    void TC2_opretDagligFastOrdiantion_exception() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");


        Exception exception = assertThrows(RuntimeException.class, () -> {
            controller.opretDagligFastOrdination(LocalDate.of(2023, 1, 14), LocalDate.of(2023, 1, 1), patient, laegemiddel, new double[]{1,3,4,0});
        });

        assertEquals("Slutdato ligger efter startdato", exception.getMessage());
    }

    @Test
    void TC1_opretDagligSkaevOrdiantion() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");
        LocalTime[] klokkeslet = new LocalTime[]{LocalTime.of(12,0), LocalTime.of(18,30)};
        double[] antalEnheder = new double[]{2,5};

        DagligSkaev result = controller.opretDagligSkaevOrdination(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 14), patient, laegemiddel, klokkeslet, antalEnheder);

        assertEquals(7, result.samletDosis());
        assertEquals(14, result.antalDage());
    }

    @Test
    void TC2_opretDagligSkaevOrdiantion_exception() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");
        LocalTime[] klokkeslet = new LocalTime[]{LocalTime.of(12,0), LocalTime.of(18,30)};
        double[] antalEnheder = new double[]{2,5};

        Exception exception = assertThrows(RuntimeException.class, () -> {
            controller.opretDagligSkaevOrdination(LocalDate.of(2023, 1, 14), LocalDate.of(2023, 1, 1), patient, laegemiddel, klokkeslet, antalEnheder);
        });

        assertEquals("Slutdato ligger efter startdato", exception.getMessage());
    }



}
