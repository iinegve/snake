// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
package godot.entry

import godot.GameOverMenu
import godot.MultiplayerAPI.RPCMode.RPC_MODE_DISABLED
import godot.MultiplayerPeer.TransferMode.TRANSFER_MODE_RELIABLE
import godot.`annotation`.RegisteredClassMetadata
import godot.core.KtConstructor0
import godot.core.KtRpcConfig
import godot.core.VariantParser.NIL
import godot.registration.ClassRegistrar
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit
import kotlin.collections.listOf

@RegisteredClassMetadata(
  "GameOverMenu",
  "CanvasLayer",
  "godot.GameOverMenu",
  "src/main/kotlin/godot/GameOverMenu.kt",
  "gdj/godot/GameOverMenu.gdj",
  "snake",
  "godot.CanvasLayer,godot.Node,godot.Object,godot.core.KtObject,kotlin.Any",
  "godot.GameOverMenu.restart",
  "",
  "godot.GameOverMenu._onRestartButtonPressed",
)
public open class GameOverMenuRegistrar : ClassRegistrar {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<GameOverMenu>(listOf(), GameOverMenu::class, false, "CanvasLayer", "GameOverMenu", "src/main/kotlin/godot/GameOverMenu.kt", "gdj/godot/GameOverMenu.gdj") {
        constructor(KtConstructor0(::GameOverMenu))
        notificationFunctions(listOf())
        function(GameOverMenu::_onRestartButtonPressed, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), KtRpcConfig(RPC_MODE_DISABLED.id.toInt(), false, TRANSFER_MODE_RELIABLE.id.toInt(), 0))
        signal(GameOverMenu::restart)
      }
    }
  }
}
