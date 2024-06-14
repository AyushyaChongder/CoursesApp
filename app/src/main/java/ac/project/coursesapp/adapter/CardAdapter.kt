import ac.project.coursesapp.R
import ac.project.coursesapp.model.Branch
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val context: Context, private val branchList: List<Branch>) :
    RecyclerView.Adapter<CardAdapter.BranchViewHolder>() {

    // Array of image resources
    private val imageResources = intArrayOf(
        R.drawable.courseimg1,
        R.drawable.courseimg2,
        R.drawable.courseimg3,
        R.drawable.courseimg4
    )

    // Array of colors for card backgrounds
    private val cardColors = intArrayOf(
        R.color.color1,
        R.color.color2,
        R.color.color3,
        R.color.color4
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return BranchViewHolder(view)
    }

    override fun onBindViewHolder(holder: BranchViewHolder, position: Int) {
        val branch = branchList[position]

        // Populate branch data into card views
        holder.titleTextView.text = branch.short
        holder.subtitleTextView.text = branch.name

        // Get a random image resource
        val randomImageResource = imageResources.random()

        // Set random image resource for each card
        holder.imageView.setImageResource(randomImageResource)

        // Set background color for the card
        holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, cardColors[position % cardColors.size]))
    }

    override fun getItemCount(): Int {
        return branchList.size
    }

    // ViewHolder for branch items
    class BranchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: CardView = itemView.findViewById(R.id.course_view)
        var imageView: ImageView = itemView.findViewById(R.id.cardimg)
        var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        var subtitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)
    }
}
