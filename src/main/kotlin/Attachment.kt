interface Attachment {
    val type: String
}

class VideoAttachment(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment {
    override val type: String = "video"
}

class PhotoAttachment(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment {
    override val type: String = "photo"
}

class MapAttachment(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment {
    override val type: String = "map"
}

class FileAttachment(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment {
    override val type: String = "file"
}

class AudioAttachment(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int
) : Attachment {
    override val type: String = "audio"
}