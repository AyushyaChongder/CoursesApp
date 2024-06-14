package ac.project.coursesapp.ui.home

import Course
import CourseAdapter
import ac.project.coursesapp.CoursesActivity
import ac.project.coursesapp.databinding.FragmentHomeBinding
import ac.project.coursesapp.network.RetrofitClient
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var courseAdapter: CourseAdapter
    private lateinit var courseList: MutableList<Course>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root

        val recyclerViewCourses = binding.recyclerViewCourses
        recyclerViewCourses.layoutManager = GridLayoutManager(requireContext(), 2)

        fetchCategories()

        return root
    }

    private fun fetchCategories() {
        lifecycleScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitClient.instance.getCategories()
                }
                courseList = response.categories.map { category ->
                    Course(
                        id = category.id,
                        name = category.name,
                        shortForm = category.short_form,
                        allowWebAccess = category.allow_web_access,
                        allowUnlimitedUnlocks = category.allow_unlimited_unlocks
                    )
                }.toMutableList()
                setupRecyclerView()
            } catch (e: HttpException) {
                e.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun setupRecyclerView() {
        courseAdapter = CourseAdapter(courseList) { course ->
            val intent = Intent(requireContext(), CoursesActivity::class.java)
            intent.putExtra("COURSE_ID", course.id) // Pass the course ID
            intent.putExtra("COURSE_TITLE", course.name)
            startActivity(intent)
        }
        binding.recyclerViewCourses.adapter = courseAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
