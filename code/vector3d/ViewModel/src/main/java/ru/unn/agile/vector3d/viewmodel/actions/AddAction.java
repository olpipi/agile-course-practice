package ru.unn.agile.vector3d.viewmodel.actions;

import ru.unn.agile.vector3d.model.Vector3D;
import ru.unn.agile.vector3d.viewmodel.ViewModel;

public class AddAction implements IAction {
    @Override
    public void execute(ViewModel viewModel) {
        Vector3D vector = new Vector3D(viewModel.getVectorX(),
                viewModel.getVectorY(), viewModel.getVectorZ());
        Vector3D other = new Vector3D(viewModel.getOtherVectorX(),
                viewModel.getOtherVectorY(), viewModel.getOtherVectorZ());

        viewModel.resultProperty().set(vector.add(other).toString());
        viewModel.statusProperty().set(ViewModel.Status.SUCCESS.toString());
    }
}
