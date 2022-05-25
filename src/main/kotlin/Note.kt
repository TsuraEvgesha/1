data class Note(
    var id: Int=0,
    var ownerId: Int=5,
    val title: String="",
    val text: String="",
    val date: Int=9,
    var deleted: Boolean = false
) {
    override fun toString(): String {
        return "Note: (ownerId = $ownerId, id = $id, title = '$title', text = '$text', date = $date,deleted = $deleted)"
    }
}
