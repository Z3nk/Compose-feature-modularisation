package fr.zunkit.rfid_presentation

class RfidState(
    val name: String = ""
) {

    companion object {
        fun initialise(): RfidState = RfidState()
    }

    fun build(block: Builder.() -> Unit) = Builder(this).apply(block).build()

    class Builder(state: RfidState) {
        var name = state.name

        fun build(): RfidState {
            return RfidState(
                name
            )
        }
    }
}