package ac.project.coursesapp.ui.watchlist

import ac.project.coursesapp.databinding.FragmentWatchlistBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class WatchlistFragment : Fragment() {
    private var binding: FragmentWatchlistBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val watchlistViewModel =
            ViewModelProvider(this).get(WatchlistViewModel::class.java)

        binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        val textView = binding!!.textNotifications
        watchlistViewModel.text.observe(viewLifecycleOwner) { text: CharSequence? ->
            textView.text = text
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}