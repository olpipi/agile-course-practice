package ru.unn.agile.vector3d.viewmodel.actions.impl;

import ru.unn.agile.vector3d.model.Vector3D;
import ru.unn.agile.vector3d.viewmodel.ViewModel;
import ru.unn.agile.vector3d.viewmodel.actions.IAction;

public class SubtractAction implements IAction {
    @Override
    public void execute(final ViewModel viewModel) {
        Vector3D vector = new Vector3D(viewModel.getVectorX(),
                viewModel.getVectorY(), viewModel.getVectorZ());
        Vector3D subVector = new Vector3D(viewModel.getOtherVectorX(),
                viewModel.getOtherVectorY(), viewModel.getOtherVectorZ());

        viewModel.resultProperty().set(vector.subtract(subVector).toString());
        viewModel.statusProperty().set(ViewModel.Status.SUCCESS.toString());
    }
}
