class WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 1


    fun add(post: Post): Post{
        post.id = ++lastId
        posts += post.copy(id=posts.size)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (targetPost in posts) if (targetPost.id == post.id){
            return true
        }
        return false
    }

}