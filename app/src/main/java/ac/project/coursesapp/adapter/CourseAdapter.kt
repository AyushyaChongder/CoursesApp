import ac.project.coursesapp.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(
    private val courseList: List<Course>,
    private val onItemClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private val imageResources = intArrayOf(
        R.drawable.courseimg1,
        R.drawable.courseimg2,
        R.drawable.courseimg3,
        R.drawable.courseimg4
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.bind(course, imageResources[position % imageResources.size])
        holder.itemView.setOnClickListener { onItemClick(course) }
    }

    override fun getItemCount() = courseList.size

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.course_view)
        private val cardImage: ImageView = itemView.findViewById(R.id.cardimg)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val subtitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)

        fun bind(course: Course, imageResource: Int) {
            cardView.setCardBackgroundColor(course.getBackgroundColor(itemView.context, adapterPosition))
            cardImage.setImageResource(imageResource)
            titleTextView.text = course.name
            subtitleTextView.text = course.shortForm
        }
    }
}
