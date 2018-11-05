package ru.unn.agile.vector3d.viewmodel.validators;

import ru.unn.agile.vector3d.model.Vector3D;
import ru.unn.agile.vector3d.viewmodel.validators.impl.BothVectorsValidator;
import ru.unn.agile.vector3d.viewmodel.validators.impl.MultiplyCoeffValidator;
import ru.unn.agile.vector3d.viewmodel.validators.impl.VectorValidator;

public final class ValidatorFactory {
    private ValidatorFactory() {
    }

    public static IValidator getValidator(final Vector3D.Operation operation) {
        if (Vector3D.Operation.ADD.equals(operation)
                || Vector3D.Operation.SUBTRACT.equals(operation)
                || Vector3D.Operation.DOT.equals(operation)
                || Vector3D.Operation.CROSS.equals(operation)) {
            return new BothVectorsValidator();
        } else if (Vector3D.Operation.MULTIPLY.equals(operation)) {
            return new MultiplyCoeffValidator();
        } else if (Vector3D.Operation.MAGNITUDE.equals(operation)
                || Vector3D.Operation.NORMALIZE.equals(operation)) {
            return new VectorValidator();
        }

        return null;
    }
}
