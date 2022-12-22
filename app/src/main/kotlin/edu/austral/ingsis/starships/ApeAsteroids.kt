package edu.austral.ingsis.starships

import edu.austral.ingsis.starships.ui.*
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.stage.Stage

fun main() {
    Application.launch(ApeShips::class.java)
}

class ApeShips() : Application() {
    private val imageResolver = CachedImageResolver(DefaultImageResolver())
    private val facade = ElementsViewFacade(imageResolver)
    private val keyTracker = KeyTracker()

    companion object {
        val STARSHIP_IMAGE_REF = ImageRef("ship", 1000.0, 100.0)
    }

    override fun start(primaryStage: Stage) {
        facade.elements["asteroid-1"] =
            ElementModel("asteroid-1", 0.0, 0.0, 30.0, 40.0, 0.0, ElementColliderType.Elliptical, null)
        facade.elements["asteroid-2"] =
            ElementModel("asteroid-2", 100.0, 100.0, 30.0, 20.0, 90.0, ElementColliderType.Rectangular, null)
        facade.elements["asteroid-3"] =
            ElementModel("asteroid-3", 200.0, 200.0, 20.0, 30.0, 180.0, ElementColliderType.Elliptical, null)

        val starship = ElementModel("starship", 300.0, 300.0, 40.0, 40.0, 270.0, ElementColliderType.Triangular, STARSHIP_IMAGE_REF)
        facade.elements["starship"] = starship

        facade.timeListenable.addEventListener(ApeTimeListener(facade.elements))
        facade.collisionsListenable.addEventListener(ApeCollisionListener())
        keyTracker.keyPressedListenable.addEventListener(ApeKeyPressedListener(starship))

        val scene = Scene(facade.view)
        keyTracker.scene = scene

        primaryStage.scene = scene
        primaryStage.height = 800.0
        primaryStage.width = 800.0

        facade.start()
        keyTracker.start()
        primaryStage.show()
    }

    override fun stop() {
        facade.stop()
        keyTracker.stop()
    }
}

class ApeTimeListener(private val elements: Map<String, ElementModel>) : EventListener<TimePassed> {
    override fun handle(event: TimePassed) {
        elements.forEach {
            val (key, element) = it
            when(key) {
                "starship" -> {}
                "asteroid-1" -> {
                    element.x.set(element.x.value + 0.25)
                    element.y.set(element.y.value + 0.25)
                }
                else -> {
                    element.x.set(element.x.value - 0.25)
                    element.y.set(element.y.value - 0.25)
                }
            }

            element.rotationInDegrees.set(element.rotationInDegrees.value + 1)
        }
    }
}

class ApeCollisionListener() : EventListener<Collision> {
    override fun handle(event: Collision) {
        println("${event.element1Id} ${event.element2Id}")
    }

}

class ApeKeyPressedListener(private val starship: ElementModel): EventListener<KeyPressed> {
    override fun handle(event: KeyPressed) {
        when (event.key) {
            KeyCode.UP -> starship.y.set(starship.y.value - 5)
            KeyCode.DOWN -> starship.y.set(starship.y.value + 5)
            KeyCode.LEFT -> starship.x.set(starship.x.value - 5)
            KeyCode.RIGHT -> starship.x.set(starship.x.value + 5)
            else -> {}
        }
    }
}
