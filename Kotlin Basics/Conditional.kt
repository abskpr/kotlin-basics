fun main() {
    val trafficLightColor = "Yellow";

    when(trafficLightColor){
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid Traffic Light Color")
    }
}