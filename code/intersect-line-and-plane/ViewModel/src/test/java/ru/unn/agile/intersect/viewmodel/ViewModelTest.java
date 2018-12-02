package ru.unn.agile.intersect.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertEquals("Waiting for input", viewModel.getPlaneStatus());
        assertEquals("Waiting for input", viewModel.getLineStatus());
    }

    @Test
    public void canCreatePlane() {
        viewModel.setCoordXFirstPlanePoint("1");
        viewModel.setCoordYFirstPlanePoint("2");
        viewModel.setCoordZFirstPlanePoint("1");

        viewModel.setCoordXSecondPlanePoint("2");
        viewModel.setCoordYSecondPlanePoint("1");
        viewModel.setCoordZSecondPlanePoint("2");

        viewModel.setCoordXThirdPlanePoint("3");
        viewModel.setCoordYThirdPlanePoint("0");
        viewModel.setCoordZThirdPlanePoint("1");

        viewModel.createPlane();

        assertEquals("Correct input", viewModel.getPlaneStatus());
    }

    @Test
    public void canCreateLine() {
        viewModel.setCoordXFirstLinePoint("1");
        viewModel.setCoordYFirstLinePoint("2");
        viewModel.setCoordZFirstLinePoint("3");

        viewModel.setCoordXSecondLinePoint("2");
        viewModel.setCoordYSecondLinePoint("3");
        viewModel.setCoordZSecondLinePoint("4");

        viewModel.createLine();

        assertEquals("Correct input", viewModel.getLineStatus());
    }

    @Test
    public void canNotAddNullValueForPlaneCoordinates() {
        viewModel.setCoordXFirstPlanePoint("");
        viewModel.setCoordYFirstPlanePoint("2");
        viewModel.setCoordZFirstPlanePoint("1");

        viewModel.setCoordXSecondPlanePoint("2");
        viewModel.setCoordYSecondPlanePoint("1");
        viewModel.setCoordZSecondPlanePoint("2");

        viewModel.setCoordXThirdPlanePoint("1");
        viewModel.setCoordYThirdPlanePoint("0");
        viewModel.setCoordZThirdPlanePoint("1");

        viewModel.createPlane();

        assertEquals("Input error: empty string", viewModel.getPlaneStatus());
    }

    @Test
    public void canNotAddNullValueForLineCoordinates() {
        viewModel.setCoordXFirstLinePoint("");
        viewModel.setCoordYFirstLinePoint("2");
        viewModel.setCoordZFirstLinePoint("3");

        viewModel.setCoordXSecondLinePoint("2");
        viewModel.setCoordYSecondLinePoint("3");
        viewModel.setCoordZSecondLinePoint("4");

        viewModel.createLine();

        assertEquals("Input error: empty string", viewModel.getLineStatus());
    }

    @Test
    public void canNotAddInvalidValueForPlaneCoordinates() {
        viewModel.setCoordXFirstPlanePoint("aa");
        viewModel.setCoordYFirstPlanePoint("2");
        viewModel.setCoordZFirstPlanePoint("1");

        viewModel.setCoordXSecondPlanePoint("2");
        viewModel.setCoordYSecondPlanePoint("1");
        viewModel.setCoordZSecondPlanePoint("2");

        viewModel.setCoordXThirdPlanePoint("1");
        viewModel.setCoordYThirdPlanePoint("0");
        viewModel.setCoordZThirdPlanePoint("1");

        viewModel.createPlane();

        assertEquals("Input error: for input string: \"aa\"", viewModel.getPlaneStatus());
    }

    @Test
    public void canNotAddInvalidValueForLineCoordinates() {
        viewModel.setCoordXFirstLinePoint("bb");
        viewModel.setCoordYFirstLinePoint("2");
        viewModel.setCoordZFirstLinePoint("3");

        viewModel.setCoordXSecondLinePoint("2");
        viewModel.setCoordYSecondLinePoint("3");
        viewModel.setCoordZSecondLinePoint("dd");

        viewModel.createLine();

        assertEquals("Input error: for input string: \"bb\"", viewModel.getLineStatus());
    }

    @Test
    public void canNotAddIdenticalPointCoordinatesForPlane() {
        viewModel.setCoordXFirstPlanePoint("1");
        viewModel.setCoordYFirstPlanePoint("2");
        viewModel.setCoordZFirstPlanePoint("3");

        viewModel.setCoordXSecondPlanePoint("1");
        viewModel.setCoordYSecondPlanePoint("2");
        viewModel.setCoordZSecondPlanePoint("3");

        viewModel.setCoordXThirdPlanePoint("1");
        viewModel.setCoordYThirdPlanePoint("2");
        viewModel.setCoordZThirdPlanePoint("3");

        viewModel.createPlane();

        assertEquals("Input error: points must not have identical coordinates", viewModel.getPlaneStatus());
    }

    @Test
    public void canNotAddIdenticalPointCoordinatesForLine() {
        viewModel.setCoordXFirstLinePoint("1");
        viewModel.setCoordYFirstLinePoint("2");
        viewModel.setCoordZFirstLinePoint("3");

        viewModel.setCoordXSecondLinePoint("1");
        viewModel.setCoordYSecondLinePoint("2");
        viewModel.setCoordZSecondLinePoint("3");

        viewModel.createLine();

        assertEquals("Input error: points must not have identical coordinates", viewModel.getLineStatus());
    }
}
