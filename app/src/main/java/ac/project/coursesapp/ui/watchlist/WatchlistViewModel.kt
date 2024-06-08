package ac.project.coursesapp.ui.watchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WatchlistViewModel : ViewModel() {
    private val mText = MutableLiveData<String>()

    init {
        mText.value = "This is watchlist fragment"
    }

    val text: LiveData<String>
        get() = mText
}