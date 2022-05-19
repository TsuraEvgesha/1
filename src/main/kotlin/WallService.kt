class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var lastId = 1
    fun createComment(comment: Comment):Comment{
        for (post in posts) if (comment.id == post.id) {
            comments += comment.copy(text=comment.text)
            return comments.last()}
        throw PostNotFoundException(text ="id is not found")

    }

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


