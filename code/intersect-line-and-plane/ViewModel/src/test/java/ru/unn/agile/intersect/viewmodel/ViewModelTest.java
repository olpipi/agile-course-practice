package ru.unn.agile.intersect.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewModelTest {
    private ViewModel viewModel;

    @Before
    public void createViewModel() {
        viewModel = new ViewModel();
    }

    @After
    public void deleteViewModel() {
        viewModel = null;
    }

    @Test
    public void initViewModelWithDefaultValues() {
        assertEquals("", viewModel.getCoordXFirstPlanePoint());
        assertEquals("", viewModel.getCoordYFirstPlanePoint());
        assertEquals("", viewModel.getCoordZFirstPlanePoint());

        assertEquals("", viewModel.getCoordXSecondPlanePoint());
        assertEquals("", viewModel.getCoordYSecondPlanePoint());
        assertEquals("", viewModel.getCoordZSecondPlanePoint());

        assertEquals("", viewModel.getCoordXThirdPlanePoint());
        assertEquals("", viewModel.getCoordYThirdPlanePoint());
        assertEquals("", viewModel.getCoordZThirdPlanePoint());

        assertEquals("", viewModel.getCoordXFirstLinePoint());
        assertEquals("", viewModel.getCoordYFirstLinePoint());
        assertEquals("", viewModel.getCoordZFirstLinePoint());

        assertEquals("", viewModel.getCoordXSecondLinePoint());
        assertEquals("", viewModel.getCoordYSecondLinePoint());
        assertEquals("", viewModel.getCoordZSecondLinePoint());

        assertEquals("", viewModel.getResult());
    }

    @Test
    public void canSetPlaneCoordinates() {
        viewModel.setCoordXFirstPlanePoint("0");
        viewModel.setCoordYFirstPlanePoint("0");
        viewModel.setCoordZFirstPlanePoint("0");

        viewModel.setCoordXSecondPlanePoint("0");
        viewModel.setCoordYSecondPlanePoint("0");
        viewModel.setCoordZSecondPlanePoint("0");

        viewModel.setCoordXThirdPlanePoint("0");
        viewModel.setCoordYThirdPlanePoint("0");
        viewModel.setCoordZThirdPlanePoint("0");

        assertEquals("0", viewModel.getCoordXFirstPlanePoint());
        assertEquals("0", viewModel.getCoordYFirstPlanePoint());
        assertEquals("0", viewModel.getCoordZFirstPlanePoint());

        assertEquals("0", viewModel.getCoordXSecondPlanePoint());
        assertEquals("0", viewModel.getCoordYSecondPlanePoint());
        assertEquals("0", viewModel.getCoordZSecondPlanePoint());

        assertEquals("0", viewModel.getCoordXThirdPlanePoint());
        assertEquals("0", viewModel.getCoordYThirdPlanePoint());
        assertEquals("0", viewModel.getCoordZThirdPlanePoint());
    }

    @Test
    public void canSetLineCoordinates() {
        viewModel.setCoordXFirstLinePoint("0");
        viewModel.setCoordYFirstLinePoint("0");
        viewModel.setCoordZFirstLinePoint("0");

        viewModel.setCoordXSecondLinePoint("0");
        viewModel.setCoordYSecondLinePoint("0");
        viewModel.setCoordZSecondLinePoint("0");

        assertEquals("0", viewModel.getCoordXFirstLinePoint());
        assertEquals("0", viewModel.getCoordYFirstLinePoint());
        assertEquals("0", viewModel.getCoordZFirstLinePoint());

        assertEquals("0", viewModel.getCoordXSecondLinePoint());
        assertEquals("0", viewModel.getCoordYSecondLinePoint());
        assertEquals("0", viewModel.getCoordZSecondLinePoint());
    }

    @Test
    public void canSetDefaultStatus() {
        assertEquals("Waiting for input", viewModel.getStatus());
    }
}
