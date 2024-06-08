package ac.project.coursesapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val mText = MutableLiveData<String>()

    init {
        mText.value = "This is profile fragment"
    }

    val text: LiveData<String>
        get() = mText
}
