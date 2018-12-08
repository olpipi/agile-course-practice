package ru.unn.agile.matrix.infrastructure;

import ru.unn.agile.matrix.viewmodel.ViewModel;
import ru.unn.agile.matrix.viewmodel.ViewModelTest;

public class ViewModelWithTxtLoggerTest extends ViewModelTest {
    @Override
    public void setUp() {
        TxtLogger realLogger =
            new TxtLogger("./MatrixCalc-ViewModelWithTxtLoggerTest.log");
        super.setExternalViewModel(new ViewModel(realLogger));
    }
}
