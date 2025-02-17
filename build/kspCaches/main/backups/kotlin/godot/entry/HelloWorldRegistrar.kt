// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
package godot.entry

import godot.HelloWorld
import godot.MultiplayerAPI.RPCMode.RPC_MODE_DISABLED
import godot.MultiplayerPeer.TransferMode.TRANSFER_MODE_RELIABLE
import godot.PropertyHint.PROPERTY_HINT_NONE
import godot.`annotation`.RegisteredClassMetadata
import godot.core.KtConstructor0
import godot.core.KtRpcConfig
import godot.core.VariantParser.NIL
import godot.core.VariantParser.STRING
import godot.registration.ClassRegistrar
import godot.registration.ClassRegistry
import godot.registration.KtFunctionArgument
import kotlin.Unit
import kotlin.collections.listOf

@RegisteredClassMetadata(
  "HelloWorld",
  "Node",
  "godot.HelloWorld",
  "src/main/kotlin/godot/HelloGodot.kt",
  "gdj/godot/HelloWorld.gdj",
  "snake",
  "godot.Node,godot.Object,godot.core.KtObject,kotlin.Any",
  "godot.HelloWorld.signal",
  "godot.HelloWorld.helloString",
  "godot.HelloWorld._ready,godot.HelloWorld.printNext",
)
public open class HelloWorldRegistrar : ClassRegistrar {
  public override fun register(registry: ClassRegistry): Unit {
    with(registry) {
      registerClass<HelloWorld>(listOf(), HelloWorld::class, false, "Node", "HelloWorld", "src/main/kotlin/godot/HelloGodot.kt", "gdj/godot/HelloWorld.gdj") {
        constructor(KtConstructor0(::HelloWorld))
        notificationFunctions(listOf())
        function(HelloWorld::_ready, NIL, KtFunctionArgument(NIL, "kotlin.Unit"), KtRpcConfig(RPC_MODE_DISABLED.id.toInt(), false, TRANSFER_MODE_RELIABLE.id.toInt(), 0))
        function(HelloWorld::printNext, NIL, STRING, KtFunctionArgument(STRING, "kotlin.String", "str"), KtFunctionArgument(NIL, "kotlin.Unit"), KtRpcConfig(RPC_MODE_DISABLED.id.toInt(), false, TRANSFER_MODE_RELIABLE.id.toInt(), 0))
        signal(HelloWorld::signal, KtFunctionArgument(STRING, "kotlin.String", "test"))
        property(HelloWorld::helloString, STRING, STRING, "kotlin.String", PROPERTY_HINT_NONE, "", godot.PropertyUsageFlags.PROPERTY_USAGE_DEFAULT.flag)
      }
    }
  }
}
