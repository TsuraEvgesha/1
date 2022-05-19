
data class Post(
    var id: Int = 3,
    var ownerId: Int = 0,
    var fromId: Int = ownerId,
    val createdBy: Int = 0,
    val date: Int,
    var text: String = "text",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = true,
    val comments: Comment = Comment(),
    val copyright: Copyright = Copyright(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "post",
    val geo: Geo? = null,
    val copyHistory: Array<Post>? = null,
    val signerId: Int = 0,
    var canPin: Boolean = true,
    var canDelete: Boolean = true,
    val likes: Likes = Likes(),
    var canEdit: Boolean = true,
    var isPinned: Boolean = false,
    var markedAsAds: Boolean = true,
    var donut: Donut = Donut(),
    var isFavorite: Boolean = false,
    var postponedId: Int = 0,

    ){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (createdBy != other.createdBy) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (comments != other.comments) return false
        if (copyright != other.copyright) return false
        if (reposts != other.reposts) return false
        if (views != other.views) return false
        if (postType != other.postType) return false
        if (geo != other.geo) return false
        if (copyHistory != null) {
            if (other.copyHistory == null) return false
            if (!copyHistory.contentEquals(other.copyHistory)) return false
        } else if (other.copyHistory != null) return false
        if (signerId != other.signerId) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (likes != other.likes) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (donut != other.donut) return false
        if (isFavorite != other.isFavorite) return false
        if (postponedId != other.postponedId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + fromId
        result = 31 * result + createdBy
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + replyOwnerId
        result = 31 * result + replyPostId
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + comments.hashCode()
        result = 31 * result + copyright.hashCode()
        result = 31 * result + reposts.hashCode()
        result = 31 * result + views.hashCode()
        result = 31 * result + postType.hashCode()
        result = 31 * result + (geo?.hashCode() ?: 0)
        result = 31 * result + (copyHistory?.contentHashCode() ?: 0)
        result = 31 * result + signerId
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + likes.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + donut.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + postponedId
        return result
    }


}

data class Geo(
    var type: String="",
    var coordinates: String="",
    var place: Place
)

data class Place(
    var id: Int=1,
    var title: String="",
    var latitude: Int=4,
    var longitude: Int=2323445,
    var created: Int=54,
    var icon: String="",
    var checkins: Int=546,
    var updated: Int=596,
    var type: Int=23,
    var country: Int=23,
    var city: Int=67,
    var address: String= ""
)

data class Donut(
    var isDonut: Boolean = false,
    var paidDuration: Int = 0,
    var placeHolder: Boolean = false,
    var publishCopy: Boolean = false,
    var editMode: String = arrayOf("", "").toString()
) {

}

data class Views(
    var count: Int = 1
) {

}

data class Reposts(
    var count: Int = 0,
    var userReposted: Boolean = true
) {

}

data class Likes(
    var count: Int = 0,
    var userLikes: Boolean = true,
    var canLike: Boolean = true,
    var canPublish: Boolean = true,
) {

}

data class Copyright(
    var id: Int = 1,
    var link: String = "",
    var name: String = "",
    var type: String = ""
)

data class Comment(
    var fromId: Int = 1,
    var id: Int = 3,
    var date: Int = 212,
    var text: String = "Hello world",
    var deleted: Boolean = false

)
class PostNotFoundException(text:String):Exception(text)




