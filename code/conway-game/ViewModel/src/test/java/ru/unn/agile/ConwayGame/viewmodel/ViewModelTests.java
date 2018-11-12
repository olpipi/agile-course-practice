package ru.unn.agile.ConwayGame.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        assertEquals("", viewModel.rowsNumberProperty().get());
        assertEquals("", viewModel.columnsNumberProperty().get());
        assertEquals("", viewModel.firstGenerationProperty().get());
        assertEquals("Input:", viewModel.inputProperty().get());
        assertEquals("Output:", viewModel.outputProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());

    }

    @Test
    public void statusItWaitingWhenBlankFields() {
        viewModel.calculateNextGeneration();

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void statusIsReadyToSetWhenFieldsAreCorrectlyFilled() {
        setInputSizes();

        assertEquals(Status.READY_TO_SET.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportBadFormat() {
        viewModel.rowsNumberProperty().set("q");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canWaitIfNoAllFieldsAreFilled() {
        viewModel.rowsNumberProperty().set("5");

        assertEquals(Status.WAITING.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void canReportBadFormatWhileSmthgIsBad() {
        viewModel.rowsNumberProperty().set("5");
        viewModel.columnsNumberProperty().set("q");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void isCreateGridDisabledWhileBadFormat() {
        viewModel.rowsNumberProperty().set("5");
        viewModel.columnsNumberProperty().set("q");

        assertTrue(viewModel.creationGridDisabledProperty().get());
    }

    @Test
    public void isCreateGridDisableWhenBlankFields() {
        viewModel.rowsNumberProperty().set("7");

        assertTrue(viewModel.creationGridDisabledProperty().get());
    }

    @Test
    public void isCreateGridDisableWhenBadStatus() {
        viewModel.statusProperty().set(Status.BAD_FORMAT.toString());

        assertTrue(viewModel.creationGridDisabledProperty().get());
    }

    @Test
    public void isCreateGridAbleWithGoodInput() {
        setInputSizes();

        assertFalse(viewModel.creationGridDisabledProperty().get());
    }

    @Test
    public void isSubmitAble() {
        setInputSizesAndData();

        assertFalse(viewModel.submitionDisabledProperty().get());
    }

    @Test
    public void isSubmitDisableWhileGenerationIsEmpty() {
        setInputSizes();
        viewModel.firstGenerationProperty().set("");

        assertTrue(viewModel.submitionDisabledProperty().get());
    }

    @Test
    public void isFirstGenerationLessThenSizes() {
        setInputSizes();
        viewModel.firstGenerationProperty().set("..*");

        assertEquals(Status.READY_TO_SET.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void isFirstGenerationMoreThenSizes() {
        setInputSizes();
        viewModel.firstGenerationProperty().set("..**.");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void isFirstGenerationBadFormat() {
        setInputSizes();
        viewModel.firstGenerationProperty().set("..*k");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void isFirstGenerationGood() {
        setInputSizesAndData();

        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }

    @Test
    public void isSubmitAbleWithGoodData() {
        setInputSizesAndData();

        assertFalse(viewModel.submitionDisabledProperty().get());
    }

    private void setInputSizes() {
        viewModel.rowsNumberProperty().set("2");
        viewModel.columnsNumberProperty().set("2");
    }

    private void setInputSizesAndData() {
        viewModel.rowsNumberProperty().set("2");
        viewModel.columnsNumberProperty().set("2");
        viewModel.firstGenerationProperty().set(".**.");
    }

}
