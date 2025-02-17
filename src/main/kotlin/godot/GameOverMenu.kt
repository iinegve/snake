package godot

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.annotation.RegisterSignal
import godot.core.signal0

@RegisterClass
class GameOverMenu : CanvasLayer() {

    @RegisterSignal
    val restart by signal0()

    @RegisterFunction
    fun _onRestartButtonPressed() {
        restart.emit()
    }
}
