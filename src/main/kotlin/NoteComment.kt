data class NoteComment (
    var noteId: Int = 0,
    var ownerId: Int =0,
    val message: String = "",
    var commentId: Int = 0,
    var deleted: Boolean = true
) {
    override fun toString(): String {
        return """Comment: (noteId = $noteId, ownerId = $ownerId, commentId = $commentId, deleted = $deleted
            |   message = '$message')""".trimMargin()
    }
}