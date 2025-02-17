// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
package godot.entry

import godot.Main
import godot.MultiplayerAPI.RPCMode.RPC_MODE_DISABLED
import godot.MultiplayerPeer.TransferMode.TRANSFER_MODE_RELIABLE
import godot.PropertyHint.PROPERTY_HINT_NONE
import godot.PropertyHint.PROPERTY_HINT_RESOURCE_TYPE
import godot.`annotation`.RegisteredClassMetadata
import godot.core.KtConstructor0
import godot.core.KtRpcConfig
import godot.core.VariantCaster.INT
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NIL
import godot.core.VariantParser.OBJECT
import godot.registration.ClassRegistrar
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit
import kotlin.collections.listOf

@RegisteredClassMetadata(
  "Main",
  "Node",
  "godot.Main",
  "src/main/kotlin/godot/Main.kt",
  "gdj/godot/Main.gdj",
  "snake",
  "godot.Node,godot.Object,godot.core.KtObject,kotlin.Any",
  "",
  "godot.Main.score,godot.Main.snakeScene",
  "godot.Main._ready,godot.Main._process,godot.Main._onMoveTimerTimeout,godot.Main.restartGame",
)
public open class MainRegistrar : ClassRegistrar {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<Main>(listOf(), Main::class, false, "Node", "Main", "src/main/kotlin/godot/Main.kt", "gdj/godot/Main.gdj") {
        constructor(KtConstructor0(::Main))
        notificationFunctions(listOf())
        function(Main::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), KtRpcConfig(RPC_MODE_DISABLED.id.toInt(), false, TRANSFER_MODE_RELIABLE.id.toInt(), 0))
        function(Main::_process, NIL, DOUBLE, KtFunctionArgument(DOUBLE, "kotlin.Double", "delta"), KtFunctionArgument(NIL, "kotlin.Unit"), KtRpcConfig(RPC_MODE_DISABLED.id.toInt(), false, TRANSFER_MODE_RELIABLE.id.toInt(), 0))
        function(Main::_onMoveTimerTimeout, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), KtRpcConfig(RPC_MODE_DISABLED.id.toInt(), false, TRANSFER_MODE_RELIABLE.id.toInt(), 0))
        function(Main::restartGame, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), KtRpcConfig(RPC_MODE_DISABLED.id.toInt(), false, TRANSFER_MODE_RELIABLE.id.toInt(), 0))
        property(Main::score, INT, LONG, "kotlin.Int", PROPERTY_HINT_NONE, "", godot.PropertyUsageFlags.PROPERTY_USAGE_NONE.flag)
        property(Main::snakeScene, OBJECT, OBJECT, "godot.PackedScene", PROPERTY_HINT_RESOURCE_TYPE, "PackedScene", godot.PropertyUsageFlags.PROPERTY_USAGE_DEFAULT.flag)
      }
    }
  }
}
