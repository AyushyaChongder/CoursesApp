package ac.project.coursesapp.ui.home

import ac.project.coursesapp.databinding.FragmentHomeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        //        // Binding TextViews
//        final TextView textView2 = binding.name;
//        final TextView textView3 = binding.howText;
//
//
//        // Binding ImageViews
//        final ImageView logoPart1 = binding.logoPart1;
//        final ImageView logoPart2 = binding.logoPart2;

        // Set click listeners for ImageButtons
        binding!!.notifyButton.setOnClickListener {
            // Handle notification button click
        }

        binding!!.searchButton.setOnClickListener {
            // Handle search button click
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
