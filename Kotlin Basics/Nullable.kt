fun main(){
    var favActor : String? = "Kevin Spacey"
    println(favActor?.length)

    // favActor = null
    // println(favActor?.length)

    //call safe(?.) operator with Elvis Operator(?:)
    val lengthOfActorName = favActor?.length ?: 0

    println("Length of Actor Name is $lengthOfActorName")
}