class WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 1


    fun add(post: Post): Post{
        post.id = ++lastId
        posts += post.copy(id=posts.size)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, targetPost) in posts.withIndex()){
            if (targetPost.id == post.id){
                posts[index] = post.copy(id = targetPost.id, date = targetPost.date)
                return true
            }
        }
        return false
    }

}