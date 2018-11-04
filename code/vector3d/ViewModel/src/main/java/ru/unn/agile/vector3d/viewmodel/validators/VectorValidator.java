package ru.unn.agile.vector3d.viewmodel.validators;

import ru.unn.agile.vector3d.viewmodel.ViewModel;

public class VectorValidator implements IValidator {
    @Override
    public void validate(ViewModel viewModel) {
        String x = viewModel.getVectorX();
        String y = viewModel.getVectorY();
        String z = viewModel.getVectorZ();

        if (x.isEmpty() || y.isEmpty() || z.isEmpty()) {
            viewModel.statusProperty().set(ViewModel.Status.WAITING.toString());
            return;
        }

        try {
            Double.parseDouble(x);
            Double.parseDouble(y);
            Double.parseDouble(z);
        } catch (NumberFormatException e) {
            viewModel.statusProperty().set(ViewModel.Status.BAD_FORMAT.toString());
            return;
        }

        viewModel.statusProperty().set(ViewModel.Status.READY.toString());
    }
}
