package ac.project.coursesapp.model

data class Category(
    val id: Int,
    val name: String,
    val short_form: String,
    val allow_web_access: Boolean,
    val allow_unlimited_unlocks: Boolean
)