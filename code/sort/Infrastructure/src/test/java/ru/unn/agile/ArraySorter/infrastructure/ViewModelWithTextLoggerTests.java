package ru.unn.agile.ArraySorter.infrastructure;

import ru.unn.agile.ArraySorter.viewmodel.ViewModel;
import ru.unn.agile.ArraySorter.viewmodel.ViewModelTests;

public class ViewModelWithTextLoggerTests extends ViewModelTests {

    @Override
    public void setUp() {
        TextLogger realLogger = new TextLogger("./ViewModelWithTextLoggerTests.log");
        super.setViewModel(new ViewModel(realLogger));
    }
}
