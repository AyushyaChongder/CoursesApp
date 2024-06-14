package ac.project.coursesapp


import CardAdapter
import ac.project.coursesapp.model.Branch
import ac.project.coursesapp.network.RetrofitClient
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class CoursesActivity : AppCompatActivity() {

    private lateinit var heading: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_courses)

        heading = findViewById(R.id.btechHeading)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val courseId = intent.getIntExtra("COURSE_ID", -1)
        val courseTitle = intent.getStringExtra("COURSE_TITLE")
        heading.text = courseTitle

        if (courseId != -1) {
            fetchBranches(courseId)
        }

        // Find the back button
        val backBtn = findViewById<ImageView>(R.id.backBtn)

        // Set OnClickListener to navigate back to MainActivity
        backBtn.setOnClickListener {
            val intent = Intent(this@CoursesActivity, MainActivity::class.java)
            startActivity(intent)
            // Optionally, you can finish the current activity if you don't want to keep it in the back stack
            finish()
        }
    }

    private fun fetchBranches(courseId: Int) {
        GlobalScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitClient.instance.getBranches(courseId)
                }
                val branchList = response.branches
                withContext(Dispatchers.Main) {
                    // Update RecyclerView with branchList
                    val cardAdapter = CardAdapter(this@CoursesActivity, branchList)
                    recyclerView.adapter = cardAdapter
                }
            } catch (e: HttpException) {
                e.printStackTrace()
                // Handle HTTP exceptions
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle other exceptions
            }
        }
    }
}
