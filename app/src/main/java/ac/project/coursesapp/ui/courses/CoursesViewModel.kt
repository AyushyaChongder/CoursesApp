package ac.project.coursesapp.ui.courses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoursesViewModel : ViewModel() {
    private val mText = MutableLiveData<String>()

    init {
        mText.value = "This is courses fragment"
    }

    val text: LiveData<String>
        get() = mText
}