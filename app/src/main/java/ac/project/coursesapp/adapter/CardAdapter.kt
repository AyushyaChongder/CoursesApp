package ac.project.coursesapp.adapter

import ac.project.coursesapp.R
import ac.project.coursesapp.adapter.CardAdapter.CardViewHolder
import ac.project.coursesapp.model.CardData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val context: Context, private val cardDataList: List<CardData>) :
    RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardData = cardDataList[position]
        holder.titleTextView.text = cardData.title
        holder.subtitleTextView.text = cardData.subtitle
        holder.imageView.setImageResource(cardData.imageResId)
        holder.cardView.setCardBackgroundColor(
            ContextCompat.getColor(
                context,
                cardData.backgroundColorResId
            )
        )
    }

    override fun getItemCount(): Int {
        return cardDataList.size
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: CardView = itemView.findViewById(R.id.card_view)
        var imageView: ImageView = itemView.findViewById(R.id.cardimg) // Add ImageView

        // Initialize ImageView
        var titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        var subtitleTextView: TextView = itemView.findViewById(R.id.subtitleTextView)
    }
}
