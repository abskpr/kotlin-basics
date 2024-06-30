open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "online"
    open val deviceType = "unknown"

    constructor(name : String, category : String, statusCode : Int) : this(name, category){
        deviceStatus = when(statusCode){
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    open fun turnOn(){
        deviceStatus = "on"
    }

    open fun turnOff(){
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName : String, deviceCategory : String) : 
    SmartDevice(name = deviceName, category = deviceCategory){
        
        override val deviceType = "Smart TV"

        var speakerVolume = 2
            set(value){
                if(value in 0..100){
                    field = value
                }
            }

        var channelNumber = 1
            set(value){
                if(value in 0..200){
                    field = value
                }
            }

        fun increaseSpeakerVolume(){
            speakerVolume++
            println("Speaker volume increated to $speakerVolume")
        }

        fun nextChannel(){
            channelNumber++
            println("Channel number changed to $channelNumber")
        }

        override fun turnOn(){
            super.turnOn()
            println(
                "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
            )
        }

        override fun turnOff(){
            super.turnOff()
            println("$name turned off")
        }
}

class SmartLightDevice(deviceName : String, deviceCategory : String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
        
        override val deviceType = "Smart Light"

        var brightnessLevel = 0
            set(value){
                if(value in 0..100){
                    field = value
                }
            }

        fun increaseBrightness(){
            brightnessLevel++
            println("Brightness increased to $brightnessLevel.")
        }

        override fun turnOn(){
            super.turnOn()
            brightnessLevel = 2
            println("$name turned on. The brightness level is $brightnessLevel.")
        }

        override fun turnOff(){
            super.turnOff()
            brightnessLevel = 0
            println("Smart Light turned off")
        }
}

class SmartHome(
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice : SmartLightDevice
) {
    fun turnTvOn(){
        smartTvDevice.turnOn()
    }

    fun turnTvOff(){
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume(){
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext(){
        smartTvDevice.nextChannel()
    }

    fun turnOnLight(){
        smartLightDevice.turnOn()
    }

    fun turnOffLight(){
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices(){
        turnTvOff()
        turnOffLight()
    }
}

fun main(){
    var smartDevice : SmartDevice = SmartTvDevice("Android TV", "Entertainment");
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility");
    smartDevice.turnOn()
}