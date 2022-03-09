package fr.zunkit.rfid_presentation

sealed class RfidEvent {

    object Connected : RfidEvent()
    object Available : RfidEvent()
    object Disconnected : RfidEvent()
    object Connecting : RfidEvent()
    object Disconnecting : RfidEvent()

}