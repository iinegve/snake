// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
package godot.entry.HKXKreKTDPfpCJFOAoHV

import godot.GameOverMenu
import godot.Main
import godot.entry.GameOverMenuRegistrar
import godot.entry.MainRegistrar
import godot.registerEngineTypeMethods
import godot.registerEngineTypes
import godot.registerVariantMapping
import godot.registration.Entry
import godot.registration.Entry.Context
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.listOf
import kotlin.reflect.KClass

public class Entry : Entry() {
  public override val classRegistrarCount: Int = 2

  public override val projectName: String = "snake"

  public override fun Context.`init`(): Unit {
    GameOverMenuRegistrar().register(registry)
    MainRegistrar().register(registry)
  }

  public override fun Context.initEngineTypes(): Unit {
    registerVariantMapping()
    registerEngineTypes()
    registerEngineTypeMethods()
  }

  public override fun Context.getRegisteredClasses(): List<KClass<*>> = listOf(GameOverMenu::class,
      Main::class)
}
