object NoteService: NoteInterface <Note, NoteComment> {
    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<NoteComment>()

    override fun add(note: Note): Note {
        val newNote = note.copy(id = notes.size + 1, deleted = false)
        notes.plusAssign(newNote)
        return notes.last()
    }

    override fun createComment(id: Int, comment: NoteComment): NoteComment {
        notes.forEach { note ->
            if (!note.deleted) {
                if (id == note.id) {
                    val newComment = comment.copy(noteId = note.id, commentId = comments.size + 1,
                        message = comment.message, deleted = false)
                    comments.plusAssign(newComment)
                    return comments.last()
                }
            }
        }
        throw NoteException("ID $id do not exist")
    }


    override fun delete(id: Int): Boolean {
        notes.withIndex().forEach { (index, note) ->
            if (!note.deleted) {
                if (id == note.id) {
                    notes[index] = note.copy(id = note.id, deleted = true)
                    return true
                }
            }
        }
        throw NoteException("ID $id do not exist")
    }

    override fun deleteComment(idComment: Int): Boolean {
        comments.withIndex().forEach { (index, comment) ->
            if (!comment.deleted) {
                if (idComment == comment.commentId) {
                    comments[index] = comment.copy(commentId = comment.commentId, deleted = true)
                    return true
                }
            }
        }
        throw CommentException("Comments with ID $idComment do not exist")
    }

    override fun edit(id: Int, newNote: Note): Boolean {
        notes.withIndex().forEach { (index, note) ->
            if (!note.deleted) {
                if (id == note.id) {
                    notes[index] = note.copy(id = note.id, ownerId = note.id, title = newNote.title,
                        text = newNote.text, deleted = false)
                    return true
                }
            }
        }
        throw NoteException("Notes with ID $id do not exist")
    }

    override fun editComment(id: Int, comment: NoteComment): Boolean {
        comments.withIndex().forEach { (index, comment) ->
            if (!comment.deleted) {
                if (id == comment.commentId) {
                    comments[index] = comment.copy(noteId = comment.noteId, commentId = comment.commentId,
                        deleted = false, message = comment.message)
                    return true
                }
            }
        }
        throw CommentException("Comments with ID $id do not exist")
    }


    override fun get(id: Int): Boolean {
        notes.forEach { note ->
            if (id == note.id) {
                if (!note.deleted) {
                    println(note.title)
                    return true
                }
            }
        }
        return false
    }


    override fun getById(id: Int) {
        notes.forEach { note ->
            if (id == note.id) {
                if (!note.deleted) {
                    println("""title: ${note.title}, text: ${note.text}""")
                }
            }
        }
    }

    override fun getComments(id: Int) {
        comments.forEach { comment ->
            if (id == comment.noteId) {
                println(comment.message)
            }
        }
    }

    override fun restoreComment(id: Int): Boolean {
        comments.withIndex().forEach { (index, comment) ->
            if (id == comment.commentId) {
                if (comment.deleted) {
                    comments[index] = comment.copy(commentId = comment.commentId, deleted = false)
                    return true
                }
            }
        }
        throw CommentRestoreException("There is no deleted comment with ID $id")
    }
}

class NoteException(message: String) : RuntimeException(message)
class CommentException(message: String) : RuntimeException(message)
class CommentRestoreException(message: String) : RuntimeException(message)