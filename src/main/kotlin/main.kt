import NoteService.createComment
import NoteService.delete
import NoteService.deleteComment
import NoteService.get
import NoteService.getById
import NoteService.getComments
import NoteService.restoreComment

fun main(){
    val servise = WallService()
    val servise2= NoteService
    servise.add(Post(1,1,1,77,6766,"Вот так мы отдыхаем"))
    servise.add(Post(2,1,1,77,6766,"Вот так мы отдыхаем"))
    servise.add(Post(3,2,2,76,6765,"А мы вот так отдыхаем"))
    servise.add(Post(4,3,3,75,6764,"Я хочу на море"))
    servise.add(Post(5,4,4,74,6763,"Идем в магазин"))
    val comment=Comment(1,3,6,"Hi",false)
    servise.createComment(comment)
    servise2.add(Note(1,11, "note1", "Hi", 12, deleted = true))
    servise2.add(Note(2,22, "note2", "Hello", 13, deleted = true))
    servise2.add(Note(3,33, "note3", "Ooo", 14, deleted = true))
    servise2.add(Note(4,44, "note4", "AAA", 15, deleted = true))
    createComment(1,NoteComment(1,1,"comment 1", 1, true))
    createComment(2, NoteComment(2,2,"comment 2", 2, true))
    delete(1)
    deleteComment(2)
    get(5)
    getById(1)
    getComments(4)
    restoreComment(2)





}

