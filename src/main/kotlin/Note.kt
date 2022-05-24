data class Note(
    var id: Int,
    var ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    var deleted: Boolean = false
) {
    override fun toString(): String {
        return "Note: (ownerId = $ownerId, id = $id, title = '$title', text = '$text', date = $date,deleted = $deleted)"
    }
}
