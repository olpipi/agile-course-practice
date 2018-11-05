package ru.unn.agile.vector3d.viewmodel.actions;

import ru.unn.agile.vector3d.model.Vector3D;

public final class ActionFactory {
    private ActionFactory() {
    }

    public static IAction getAction(final Vector3D.Operation operation) {
        if (Vector3D.Operation.ADD.equals(operation)) {
            return new AddAction();
        } else if (Vector3D.Operation.SUBTRACT.equals(operation)) {
            return new SubtractAction();
        } else if (Vector3D.Operation.DOT.equals(operation)) {
            return new DotAction();
        } else if (Vector3D.Operation.MULTIPLY.equals(operation)) {
            return new MultiplyAction();
        } else if (Vector3D.Operation.MAGNITUDE.equals(operation)) {
            return new MagnitudeAction();
        } else if (Vector3D.Operation.NORMALIZE.equals(operation)) {
            return new NormalizeAction();
        } else if (Vector3D.Operation.CROSS.equals(operation)) {
            return new CrossAction();
        }
        return null;
    }
}
