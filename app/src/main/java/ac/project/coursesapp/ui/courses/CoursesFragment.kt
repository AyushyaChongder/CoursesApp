package ac.project.coursesapp.ui.courses

import ac.project.coursesapp.databinding.FragmentCoursesBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class CoursesFragment : Fragment() {
    private var binding: FragmentCoursesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val coursesViewModel =
            ViewModelProvider(this).get(CoursesViewModel::class.java)

        binding = FragmentCoursesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        val textView = binding!!.textCourses
        coursesViewModel.text.observe(viewLifecycleOwner) { text: CharSequence? ->
            textView.text = text
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}