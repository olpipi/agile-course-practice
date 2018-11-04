package ru.unn.agile.vector3d.viewmodel.validators;

import ru.unn.agile.vector3d.model.Vector3D;

public class ValidatorFactory {
    public static IValidator getValidator(Vector3D.Operation operation) {
        if (Vector3D.Operation.ADD.equals(operation)
                || Vector3D.Operation.SUBTRACT.equals(operation)) {
            return new BothVectorsValidator();
        }
        return null;
    }
}
