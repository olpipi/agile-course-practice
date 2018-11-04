package ru.unn.agile.vector3d.viewmodel.validators;

import ru.unn.agile.vector3d.viewmodel.ViewModel;

public class BothVectorsValidator extends VectorValidator {
    @Override
    public void validate(ViewModel viewModel) {
        super.validate(viewModel);

        if (!ViewModel.Status.READY.toString()
                .equals(viewModel.statusProperty().get())) {
            return;
        }

        String x = viewModel.getOtherVectorX();
        String y = viewModel.getOtherVectorY();
        String z = viewModel.getOtherVectorZ();

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
