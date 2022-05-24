
fun main(){
    val servise = WallService()
    val comment=Comment(3,3,6,"Hi",false)
    val post=Post(4,4,5,1,1,"Привет")
    println(comment.id)
    println(post.id)
//    val note1 = Note(1,111, "note1", "text1", 11111111, deleted = true)
//    val note2 = Note(2,222, "note2", "text2", 22222222, deleted = true)
//    val note3 = Note(3,333, "note3", "text3", 33333333, deleted = true)
//    val note4 = Note(4,444, "note4", "text4", 44444444, deleted = true)
//    val comment1 = NoteComment(1,1,"comment 1", 1, true)
//    val comment2 = NoteComment(2,2,"comment 2", 2, true)
//
//    add(note1)
//    add(note2)
//    add(note3)
//    add(note4)
//    createComment(1, comment1)
//    createComment(4, comment2)
//    delete(3)
//    deleteComment(1)
//    get(5)
//    getById(1)
//    getComments(4)
//    restoreComment(1)
    val result=servise.createComment(comment)
    println(result)




}

