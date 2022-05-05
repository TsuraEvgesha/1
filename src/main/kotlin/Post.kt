
data class Post(
    var id: Int=0,
    val ownerId: Int,
    val fromId: Int=ownerId,
    val createdBy: Int=0,
    val date: Int,
    var text: String,
    val replyOwnerId: Int=0,
    val replyPostId: Int=0,
    val friendsOnly: Boolean= true,
    val comments: Any= Any(),
    val copyright: Any= Any(),
    val likes: Any= Any(),
    val reposts: Any= Any(),
    val views: Any= Any(),
    val postType: String="post",
    val postSource: Any = Any(),
    val geo:Any?= null,
    val copyHistory: Array<String?>,
    val signerId: Int=0,
    var canPin: Boolean= true,
    var canDelete: Boolean=true,
    var canEdit: Boolean= true,
    var isPinned: Boolean= false,
    var markedAsAds: Boolean= true,
    var isFavorite: Boolean= false,
    var donut: Any= Any(),
    var postponedId: Int=0
){
}

class WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0

    fun add(post: Post): Post{
        post.id = ++lastId
        posts += post
        return posts.last()
    }

    fun update(post:Post): Boolean{
        for ((index, targetPost) in posts.withIndex()){
            if (targetPost.id == post.id){
                posts[index] = post.copy(id = targetPost.id, date = targetPost.date)
                return true
            }
        }
        return false
    }
}
