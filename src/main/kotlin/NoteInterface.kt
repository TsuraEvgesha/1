interface NoteInterface<N, C> {
    fun add(note: N): N
    fun createComment(id: Int, comment: C): C
    fun delete(id: Int): Boolean
    fun deleteComment(id: Int): Boolean
    fun edit(id: Int, note: N): Boolean
    fun editComment(id: Int, comment: C): Boolean
    fun get(id: Int):Boolean
    fun getById(id: Int)
    fun getComments(id: Int)
    fun restoreComment(id: Int): Boolean
}
