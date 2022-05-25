import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val post = Post(ownerId = 12, text = "Text", date = 123456, friendsOnly = false, markedAsAds = false,
            copyHistory=null)
        val result=service.add(post)
        assertEquals(0, result.id)
    }

    @Test
    fun update_isUpdatedPost() {
        val service = WallService()
        service.add(Post(ownerId = 12, text = "Text 1", date = 111, friendsOnly = false, markedAsAds = false, copyHistory = null))
        service.add(Post(ownerId = 20, text = "Text 2", date = 222, friendsOnly = true, markedAsAds = false, copyHistory = null))
        service.add(Post(ownerId = 30, text = "Text 3", date = 333, friendsOnly = false, markedAsAds = true,
            copyHistory = null))
        val update = Post(
            id = 2, ownerId = 50, fromId = 50,
            createdBy = 0, date = 555, "Updated", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = Comment(), copyright = Copyright(), reposts = Reposts(),
            views = Views(), postType = "post", copyHistory = null, signerId = 0,
            canPin = true, canDelete = true, canEdit = true, isPinned = false, markedAsAds = true,
            isFavorite = false, postponedId = 0
        )
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun update_noUpdatedPost() {
        val service = WallService()
        service.add(Post(ownerId = 12, text = "Text 1", date = 111, friendsOnly = false, markedAsAds = false,
            copyHistory = null))
        service.add(Post(ownerId = 20, text = "Text 2", date = 222, friendsOnly = true, markedAsAds = false,
            copyHistory = null))
        service.add(Post(ownerId = 30, text = "Text 3", date = 333, friendsOnly = false, markedAsAds = true,
            copyHistory = null))
        val update = Post(
            id = 4, ownerId = 50, fromId = 50,
            createdBy = 0, date = 555, "Updated", replyOwnerId = 0,
            replyPostId = 0, friendsOnly = false,
            comments = Comment(), copyright = Copyright(), reposts = Reposts(),
            views = Views(), postType = "post", copyHistory = null, signerId = 0,
            canPin = true, canDelete = true, canEdit = true, isPinned = false, markedAsAds = true,
            isFavorite = false, postponedId = 0
        )
        val result = service.update(update)
        assertFalse(result)
    }
    @Test
    fun addComment(){
        val servise = WallService()
        servise.add(Post(0,1,1,77,6766,"Вот так мы отдыхаем"))
        servise.add(Post(1,0,0,75,6765,"Мы отдыхаем"))
        val comment=Comment(0,1,0,"Hi")
        val result=servise.createComment(comment)
        assertEquals(comment,result)
    }
    @Test(expected = PostNotFoundException::class)
    fun shouldThrow(){
        val servise = WallService()
        servise.add(Post(0,1,1,77,6766,"Вот так мы отдыхаем"))
        servise.add(Post(1,0,0,75,6765,"Мы отдыхаем"))
        val comment = Comment(10,2,0,"Oops",false)
        val result=servise.createComment(comment)
        assertEquals("id is not found",result)
    }





}