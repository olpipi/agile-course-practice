package ru.unn.agile.dijkstra.viewModel;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


public class MatrixValidationTest {

    @Test
    public void validateSimpleMatrix() {
        ViewModel viewModel = new ViewModel();
        viewModel.matrixProperty().setValue(getResourceAsString("SimpleMatrix.json"));
        viewModel.calculate();
        assertEquals(new Status(StatusType.SUCCESS).toString(), viewModel.getStatus());
    }

    @Test
    public void validateNonNumericMatrix() {
        ViewModel viewModel = new ViewModel();
        viewModel.matrixProperty().setValue("qq");
        viewModel.calculate();
        assertEquals(new Status(StatusType.BAD_FORMAT).toString(), viewModel.getStatus());
    }


    public  String getResourceAsString(final String path) {
        try {
            URL url = getClass().getResource(path);
            return new String(Files.readAllBytes(Paths.get(url.toURI())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}
