package ru.unn.agile.vector3d.viewmodel.validators;

import ru.unn.agile.vector3d.viewmodel.ViewModel;

public class FieldValidator {
    public ViewModel.Status validateVector(String x, String y, String z) {
        ViewModel.Status status;

        status = validateSingleField(x);
        if (!ViewModel.Status.READY.equals(status)) {
            return status;
        }
        status = validateSingleField(y);
        if (!ViewModel.Status.READY.equals(status)) {
            return status;
        }

        status = validateSingleField(z);
        if (!ViewModel.Status.READY.equals(status)) {
            return status;
        }

        return ViewModel.Status.READY;
    }

    public ViewModel.Status validateSingleField(String filedValue) {
        if (filedValue.isEmpty()) {
            return ViewModel.Status.WAITING;
        }

        try {
            tryToParseDoubleValue(filedValue);
        } catch (NumberFormatException e) {
            return ViewModel.Status.BAD_FORMAT;
        }

        return ViewModel.Status.READY;
    }

    private void tryToParseDoubleValue(String fieldValue)
            throws NumberFormatException {
        Double.parseDouble(fieldValue);
    }
}
