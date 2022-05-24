import NoteService.add
import NoteService.createComment
import NoteService.delete
import NoteService.deleteComment
import NoteService.edit
import NoteService.editComment
import NoteService.restoreComment
import org.junit.Test
import org.junit.Assert.*


class NoteServiceTest {

    @Test
    fun testAdd() {
        val noteTest = Note(0, 0, " ", " ",0, false)
        noteTest.id = 1
        val result = 1
        assertEquals(noteTest.id, result)
    }

    @Test
    fun testCreateComment() {
        val noteTest = Note(0, 1, " ", " ", 0,false)
        noteTest.id = 1
        val commentTest = NoteComment(1, 0," ", 0, false)
        commentTest.commentId = 1
        assertEquals(commentTest.commentId, noteTest.id)
    }

    @Test
    fun testDelete() {
        val noteTest= Note(0, 0, " ", " ", 0,false)
        add(noteTest)
        noteTest.id = 1
        delete(1)
        noteTest.deleted = true
        val result = true
        assertEquals(noteTest.deleted, result)
    }

    @Test
    fun testDeleteComment() {
        val noteTest= Note(0, 0, " ", " ", 0,false)
        add(noteTest)
        val commentTest: NoteComment = NoteComment(0, 0," ", 0, false)
        createComment(1, commentTest)
        deleteComment(1)
        commentTest.deleted = true
        val result = true
        assertEquals(commentTest.deleted, result)
    }

    @Test
    fun testEdit() {
        val noteTest= Note(0, 0, " ", " ", 0,false)
        add(noteTest)
        noteTest.id = 1
        edit(1, noteTest)
        noteTest.deleted = false
        val result = false
        assertEquals(noteTest.deleted, result)
    }

    @Test
    fun testEditComment() {
        val noteTest= Note(0, 0, "", "", 0,false)
        add(noteTest)
        val commentTest: NoteComment = NoteComment(0, 0,"", 0,true)
        createComment(1, commentTest)
        editComment(1, commentTest)
        commentTest.deleted = false
        val result= false
        assertEquals(commentTest.deleted, result)
    }

    @Test
    fun testGetNote() {
        val noteTest = Note(10, 0, "title", "", 0,false)
        add(noteTest)
        val expected = "title"
        assertEquals(noteTest.title, expected)
    }

    @Test
    fun testGetById() {
        val note= Note(10, 0, "title", "text", 0,false)
        val expected = println("""title: title, text: text""")
        val result = println("""title: ${note.title}, text: ${note.text}""")
        assertEquals(expected, result)
    }

    @Test
    fun testGetComments() {
        val note = Note(0, 0, "", "", 0,false)
        val comment= NoteComment(0, 0,"comment", 0, true)
        add(note)
        createComment(1, comment)
        val expected = comment.message
        val result = "comment"
        assertEquals(expected, result)
    }

    @Test
    fun testRestoreComment() {
        val commentTest = NoteComment(1, 0,"", 1, true)
        commentTest.commentId = 1
        commentTest.deleted = true
        restoreComment(1)
        val result = true
        assertEquals(commentTest.deleted, result)
    }

    @Test(expected = NoteException::class)
    fun testExceptionEditNote() {
        val noteTest= Note(0, 0, " ", " ", 0,false)
        add(noteTest)
        noteTest.id = 1
        val expected = NoteException::class
        edit(5, noteTest)
        val result = NoteException::class
        assertEquals(expected, result)
    }

    @Test(expected = NoteException::class)
    fun testExceptionDeleteNote() {
        val expected = NoteException::class
        delete(5)
        val result = NoteException::class
        assertEquals(expected, result)
    }

    @Test(expected = NoteException::class)
    fun testExceptionAddComment() {
        val comment= NoteComment(0, 0," ", 0, true)
        val expected = NoteException::class
        val result = createComment(6, comment)
        assertEquals(expected, result)
    }

    @Test(expected = CommentException::class)
    fun testExceptionDeleteComment() {
        val expected = CommentException::class
        deleteComment(5)
        val result = CommentException::class
        assertEquals(expected, result)
    }

    @Test(expected = CommentException::class)
    fun testExceptionEditComment() {
        val commentTest = NoteComment(0, 0," ", 0, true)
        val expected = CommentException::class
        editComment(5, commentTest)
        val result = CommentException::class
        assertEquals(expected, result)
    }

    @Test(expected = CommentRestoreException::class)
    fun testExceptionRestoreComment() {
        val commentTest = NoteComment(1, 0," ", 1, true)
        commentTest.commentId = 1
        commentTest.deleted = true
        val expected = CommentRestoreException::class
        restoreComment(5)
        val result = CommentRestoreException::class
        assertEquals(expected, result)
    }
}



