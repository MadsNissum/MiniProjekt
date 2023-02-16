import ordination.controller.Controller;
import ordination.ordination.Laegemiddel;
import ordination.ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setup() {
        controller = Controller.getTestController();
    }

    @Test
    void TC1_anbefaletDosis() {
        Patient patient = new Patient("", "", 10);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        double result = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        assertEquals(10, result);
    }

    @Test
    void TC2_anbefaletDosis() {
        Patient patient = new Patient("", "", 25);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        double result = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        assertEquals(37.5, result);
    }

    @Test
    void TC3_anbefaletDosis() {
        Patient patient = new Patient("", "", 120);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        double result = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        assertEquals(180, result);
    }

    @Test
    void TC4_anbefaletDosis() {
        Patient patient = new Patient("", "", 130);
        Laegemiddel laegemiddel = new Laegemiddel("", 1, 1.5, 2, "");

        double result = controller.anbefaletDosisPrDoegn(patient, laegemiddel);

        assertEquals(260, result);
    }

}
