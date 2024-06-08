package ac.project.coursesapp

import ac.project.coursesapp.adapter.CardAdapter
import ac.project.coursesapp.model.CardData
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BtechCoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_btech_courses)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val cardDataList: MutableList<CardData> = ArrayList()
        cardDataList.add(
            CardData(
                "MECH",
                "Mechanical Engineering",
                R.drawable.btechsub1img,
                R.color.color1
            )
        )
        cardDataList.add(
            CardData(
                "AEI",
                "Applied Electronics and Instrumentation",
                R.drawable.courseimg2,
                R.color.color2
            )
        )
        cardDataList.add(
            CardData(
                "ECE",
                "Electronics & Communications",
                R.drawable.btechsub1img,
                R.color.color3
            )
        )
        cardDataList.add(CardData("CSE", "Computer Science", R.drawable.courseimg2, R.color.color4))
        cardDataList.add(
            CardData(
                "EIE",
                "Electronics and Instrumentations",
                R.drawable.btechsub1img,
                R.color.color1
            )
        )
        cardDataList.add(
            CardData(
                "EEE",
                "Electrical and Electronics Engineering",
                R.drawable.courseimg2,
                R.color.color2
            )
        )
        cardDataList.add(
            CardData(
                "BME",
                "Bio Medical Engineering",
                R.drawable.btechsub1img,
                R.color.color3
            )
        )
        cardDataList.add(CardData("CSE", "Computer Science", R.drawable.courseimg1, R.color.color4))

        // Add more cards as needed
        val cardAdapter = CardAdapter(this, cardDataList)
        recyclerView.adapter = cardAdapter

        // Find the back button
        val backBtn = findViewById<ImageView>(R.id.backBtn)

        // Set OnClickListener to navigate back to MainActivity
        backBtn.setOnClickListener {
            val intent = Intent(this@BtechCoursesActivity, MainActivity::class.java)
            startActivity(intent)
            // Optionally, you can finish the current activity if you don't want to keep it in the back stack
            finish()
        }
    }
}
