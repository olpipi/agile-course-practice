package ru.unn.agile.VectorDistance.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.unn.agile.VectorDistance.model.VectorDistance.Distance;

import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetDefaultValues() {
        assertEquals("", viewModel.vectorXProperty().get());
        assertEquals("", viewModel.vectorYProperty().get());
        assertEquals(Distance.L1, viewModel.distanceProperty().get());
        assertEquals("", viewModel.resultProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canSetL1DistanceCalculation() {
        viewModel.distanceProperty().set(Distance.L1);

        assertEquals(Distance.L1, viewModel.distanceProperty().get());
    }

    @Test
    public void L1DistanceIsDefaultDistance() {
        assertEquals(Distance.L1, viewModel.distanceProperty().get());
    }

    @Test
    public void statusIsWaitingWhenCalculateWithEmptyFields() {
        viewModel.calculate();

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void isCalculationButtonDisabledInitially() {
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void canSetVectorX() {
        viewModel.vectorXProperty().set("1 2 3");

        assertEquals(viewModel.vectorXProperty().get(), "1 2 3");
    }

    @Test
    public void canSetVectorY() {
        viewModel.vectorYProperty().set("1 2 3");

        assertEquals(viewModel.vectorYProperty().get(), "1 2 3");
    }

    @Test
    public void canCalculateL1Distance() {
        viewModel.vectorXProperty().set("1 2 3");
        viewModel.vectorYProperty().set("4 5 6");
        viewModel.calculate();

        assertEquals("9.0", viewModel.resultProperty().get());
    }

    @Test
    public void canCalculateWithNegativeNumbers() {
        viewModel.vectorXProperty().set("-1");
        viewModel.vectorYProperty().set("-4");
        viewModel.calculate();

        assertEquals("3.0", viewModel.resultProperty().get());
    }

    @Test
    public void canReportBadFormatWhenSetVectorX() {
        viewModel.vectorXProperty().set("a");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportBadFormatWhenSetVectorY() {
        viewModel.vectorYProperty().set("a");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }


    @Test
    public void canReportBadFormatIfOnlyOneVectorPassed() {
        viewModel.vectorXProperty().set("1");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportReady() {
        setInputData();

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }
    @Test
    public void calculateButtonIsDisabledWhenNoData() {
        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    @Test
    public void calculateButtonIsDisabledWhenFormatIsBad() {
        setInputData();
        viewModel.vectorXProperty().set("trash");

        assertTrue(viewModel.calculationDisabledProperty().get());
    }

    private void setInputData() {
        viewModel.vectorXProperty().set("1");
        viewModel.vectorYProperty().set("1");
    }

    @Test
    public void canReportCalculationErrors() {
        setInputData();
        viewModel.vectorXProperty().set("1 2");

        viewModel.calculate();

        assertEquals("", viewModel.resultProperty().get());
    }

}
