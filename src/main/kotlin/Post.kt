data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    var text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Any,
    val copyright: Any,
    val likes: Any,
    val reposts: Any,
    val views: Any,
    val postType: String,
    val signerId: Int,
    var canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    var isPinned: Boolean,
    var markedAsAds: Boolean,
    var isFavorite: Boolean,
    var donut: Any,
    var postponedId: Int
){
    constructor(ownerId: Int, text: String, date: Int, friendsOnly: Boolean, markedAsAds: Boolean) : this(
        id = 0, ownerId = ownerId, fromId = ownerId,
        createdBy = 0, date = date, text, replyOwnerId = 0,
        replyPostId = 0, friendsOnly = friendsOnly,
        comments = Any(), copyright = Any(), likes = Any(),
        reposts = Any(), views = Any(), postType = "post",
        signerId = 0, canPin = true, canDelete = true, canEdit = true,
        isPinned = false, markedAsAds = markedAsAds, isFavorite = false,
        donut = Any(), postponedId =0
    )
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
