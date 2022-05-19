
fun main(){
    val comment=Comment(1,3,6,"Hi",false)
    val result = WallService().createComment(comment)
    val service = WallService()
//    val post = Post(ownerId = 12, text = "Text", date = 123456, friendsOnly = false, markedAsAds = false,
//        copyHistory=null)
//    service.add(Post(ownerId = 20, text = "Text 2", date = 222, friendsOnly = true, markedAsAds = false, copyHistory = null))
//    service.add(Post(ownerId = 30, text = "Text 3", date = 333, friendsOnly = false, markedAsAds = true,
//        copyHistory = null))

    println(result)



}

