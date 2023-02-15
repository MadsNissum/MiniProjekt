package ordination.ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {

    DagligFast dagligFast;

    @BeforeEach
    void setUp() {
        Patient jane = new Patient("290395-1922", "Jane", 75.5);
        Laegemiddel Ibuprofen= new Laegemiddel("Ibuprofen", 2.2, 3.5, 5.0, "stk");
        double[] doser = new double[]{2, 1, 0, 1};
        dagligFast = new DagligFast(LocalDate.of(2023,2,1), LocalDate.of(2023, 2, 10), jane, Ibuprofen, doser);
    }

    @Test
    void samletDosis() {

        //Arrange
        dagligFast.samletDosis();


        //Act

        //Assert

    }

    @Test
    void doegnDosis() {
    }
}