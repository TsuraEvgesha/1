
fun main(){
    val comment=Comment(1,3,6,"Hi",false)
    val result = WallService().createComment(comment)
    println(result)



}

