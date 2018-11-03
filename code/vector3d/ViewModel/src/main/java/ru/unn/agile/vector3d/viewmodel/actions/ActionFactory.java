package ru.unn.agile.vector3d.viewmodel.actions;

import ru.unn.agile.vector3d.model.Vector3D;

public class ActionFactory {
    public static IAction getAction(Vector3D.Operation operation) {
        if (Vector3D.Operation.ADD.equals(operation)) {
            return new AddAction();
        } else if (Vector3D.Operation.SUBTRACT.equals(operation)) {
            return new SubtractAction();
        }
        return null;
    }
}
