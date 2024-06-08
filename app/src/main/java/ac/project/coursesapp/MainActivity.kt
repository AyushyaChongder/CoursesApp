package ac.project.coursesapp

import ac.project.coursesapp.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration

import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_courses,
            R.id.navigation_watchlist,
            R.id.navigation_profile
        )
            .build()
        val navController = findNavController(this, R.id.nav_host_fragment_activity_main)
        setupWithNavController(binding!!.navView, navController)

        // Find the ConstraintLayout for the B.tech course
        val btechCourseLayout = findViewById<ConstraintLayout>(R.id.btechCourse)

        // Set OnClickListener for the B.tech course layout
        btechCourseLayout.setOnClickListener { // Handle click event here, for example, start a new activity
            val intent = Intent(this@MainActivity, BtechCoursesActivity::class.java)
            startActivity(intent)
        }
    }
}
