package ru.unn.agile.primenumber.viewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.primenumber.model.PrimeNumber;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

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
    public void isSearchButtonDisableByDefault() {
        assertEquals(true, viewModel.searchDisabledProperty().get());
    }

    @Test
    public void isSearchButtonEnabledWhenInputOnlyLeftBound() {
        viewModel.leftBoundProperty().set("1");

        assertEquals(true, viewModel.searchDisabledProperty().get());
    }

    @Test
    public void isSearchButtonEnabledWhenInputOnlyRightBound() {
        viewModel.rightBoundProperty().set("2");

        assertEquals(true, viewModel.searchDisabledProperty().get());
    }

    @Test
    public void isSearchButtonEnabledWhenInputNotNumberInLeftBound() {
        viewModel.leftBoundProperty().set("a");
        viewModel.rightBoundProperty().set("2");

        assertEquals(true, viewModel.searchDisabledProperty().get());
    }

    @Test
    public void isStatusOfEmptyValueRight() {
        viewModel.rightBoundProperty().set("");

        viewModel.searchPrimeNumber();

        assertEquals("empty String", viewModel.getStatus());
    }

    @Test
    public void isStatusOfEmptyValueLeft() {
        viewModel.searchPrimeNumber();

        assertEquals("empty String", viewModel.getStatus());
    }

    @Test
    public void isSearchButtonEnabledWhenInputNotNumberInRightBound() {
        viewModel.leftBoundProperty().set("1");
        viewModel.rightBoundProperty().set("b");

        assertEquals(true, viewModel.searchDisabledProperty().get());
    }

    @Test
    public void isStatusCorrectOnInvalidRightValue() {
        viewModel.leftBoundProperty().set("1");
        viewModel.rightBoundProperty().set("b");

        viewModel.searchDisabledProperty().get();

        assertEquals("Input values are invalid", viewModel.getStatus());
    }

    @Test
    public void isStatusCorrectOnInvalidLeftValue() {
        viewModel.leftBoundProperty().set("zxc");
        viewModel.rightBoundProperty().set("12");

        viewModel.searchDisabledProperty().get();

        assertEquals("Input values are invalid", viewModel.getStatus());
    }

    @Test
    public void isStatusCorrectOnInvalidBothValue() {
        viewModel.leftBoundProperty().set("a");
        viewModel.rightBoundProperty().set("b");

        viewModel.searchDisabledProperty().get();

        assertEquals("Input values are invalid", viewModel.getStatus());
    }

    @Test
    public void testConstructorIsPrivate()
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<PrimeNumber> constructor = PrimeNumber.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void isSearchButtonEnabledWhenBoundersInput() {
        viewModel.leftBoundProperty().set("1");
        viewModel.rightBoundProperty().set("2");

        assertEquals(false, viewModel.searchDisabledProperty().get());
    }

    @Test
    public void isResultOfSearchCorrect() {
        viewModel.leftBoundProperty().set("1");
        viewModel.rightBoundProperty().set("10");

        viewModel.searchPrimeNumber();

        assertEquals("Success", viewModel.getStatus());
    }

    @Test
    public void isStatusOfSearchCorrect() {
        viewModel.leftBoundProperty().set("1");
        viewModel.rightBoundProperty().set("10");

        viewModel.searchPrimeNumber();

        assertEquals("2, 3, 5, 7", viewModel.getResult());
    }

    @Test
    public void isStatusInvalidValueCorrect() {
        viewModel.leftBoundProperty().set("10");
        viewModel.rightBoundProperty().set("1");

        viewModel.searchPrimeNumber();

        assertEquals("Last value must be more or equal to first value!", viewModel.getStatus());
    }

    @Test
    public void isResultOfEqualsValueCorrect() {
        viewModel.leftBoundProperty().set("2");
        viewModel.rightBoundProperty().set("2");

        viewModel.searchPrimeNumber();

        assertEquals("2", viewModel.getResult());
    }

    @Test
    public void isStatusOfNotFoundNumbersCorrect() {
        viewModel.leftBoundProperty().set("14");
        viewModel.rightBoundProperty().set("16");

        viewModel.searchPrimeNumber();

        assertEquals("Primary numbers are not found", viewModel.getResult());
    }

    @Test
    public void isStatusCorrectOnNegativeValue() {
        viewModel.leftBoundProperty().set("-1");
        viewModel.rightBoundProperty().set("10");

        viewModel.searchPrimeNumber();

        assertEquals("2, 3, 5, 7", viewModel.getResult());
    }

    @Test
    public void isSetStatusCorrect() {
        viewModel.setStatus("Success");

        assertEquals("Success", viewModel.getStatus());

    }

    @Test
    public void isResultPropertyCorrect() {
        viewModel.leftBoundProperty().set("1");
        viewModel.rightBoundProperty().set("2");

        viewModel.searchPrimeNumber();

        assertEquals("2", viewModel.resultProperty().get());
    }

    @Test
    public void isGetRightBoundCorrect() {
        viewModel.rightBoundProperty().set("2");

        viewModel.searchPrimeNumber();

        assertEquals("2", viewModel.getRightBound());
    }

    @Test
    public void isGetLeftBoundCorrect() {
        viewModel.leftBoundProperty().set("2");

        viewModel.searchPrimeNumber();

        assertEquals("2", viewModel.getLeftBound());
    }

}
