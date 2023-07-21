package uz.nabijonov.otabek.todoapp_bek.ui.screen.add

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.nabijonov.otabek.todoapp_bek.domain.repository.AppRepository
import javax.inject.Inject


@HiltViewModel
class AddViewModelImpl @Inject constructor(
    private val repository: AppRepository
) : AddEditContract.ViewModel, ViewModel() {

    override fun onEventDispatcher(intent: AddEditContract.Intent) {
        when (intent) {
            is AddEditContract.Intent.AddContact -> {
                repository.add(intent.addTodoData)
            }

            is AddEditContract.Intent.UpdateContact -> {
                repository.update(intent.updateTodoData)
            }
        }
    }
}