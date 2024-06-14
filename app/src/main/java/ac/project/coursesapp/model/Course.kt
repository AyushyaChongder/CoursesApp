import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import ac.project.coursesapp.R

data class Course(
    val id: Int, // Add the id property
    val name: String,
    val shortForm: String,
    val allowWebAccess: Boolean,
    val allowUnlimitedUnlocks: Boolean
) {
    companion object {
        private val backgroundColors = intArrayOf(
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4
        )
    }

    fun getBackgroundColor(context: Context, position: Int): Int {
        val colorResId = backgroundColors[position % backgroundColors.size]
        return ContextCompat.getColor(context, colorResId)
    }
}
