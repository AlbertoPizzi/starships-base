package edu.austral.ingsis.starships

import edu.austral.ingsis.starships.ui.*
import edu.austral.ingsis.starships.ui.ElementColliderType.*
import entities.Asteroid
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.stage.Stage

fun main() {
    launch(Starships::class.java)
}

class Starships() : Application() {
    private val imageResolver = CachedImageResolver(DefaultImageResolver())
    private val facade = ElementsViewFacade(imageResolver)
    private val keyTracker = KeyTracker()

    companion object {
        val STARSHIP_IMAGE_REF = ImageRef("ship", 80.0, 100.0)
        val STARSHIP_IMAGE_REF2 = ImageRef("Xwing", 80.0, 100.0)
        val Asteroid_IMAGE_REF = ImageRef("farquad", 80.0, 100.0)
    }

    override fun start(primaryStage: Stage) {
        facade.elements["asteroid-1"] =
            ElementModel("asteroid-1", 0.0, 0.0, 30.0, 40.0, 0.0, Elliptical, Asteroid_IMAGE_REF)
        facade.elements["asteroid-2"] =
            ElementModel("asteroid-2", 100.0, 100.0, 30.0, 20.0, 90.0, Rectangular, Asteroid_IMAGE_REF)
        facade.elements["asteroid-3"] =
            ElementModel("asteroid-3", 200.0, 200.0, 20.0, 30.0, 180.0, Elliptical, Asteroid_IMAGE_REF)

        val starship = ElementModel("starship-1", 300.0, 300.0, 40.0, 40.0, 270.0, Elliptical, STARSHIP_IMAGE_REF2)
        facade.elements["starship"] = starship
        val starship2 = ElementModel("starship-2", 300.0, 300.0, 40.0, 40.0, 270.0, Triangular, STARSHIP_IMAGE_REF)
        facade.elements["starship"] = starship


        facade.timeListenable.addEventListener(TimeListener(facade.elements))
        facade.collisionsListenable.addEventListener(CollisionListener())
        keyTracker.keyPressedListenable.addEventListener(KeyPressedListener(starship))

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

class TimeListener(private val elements: Map<String, ElementModel>) : EventListener<TimePassed> {
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

class CollisionListener() : EventListener<Collision> {
    override fun handle(event: Collision) {
        println("${event.element1Id} ${event.element2Id}")
    }

}

class KeyPressedListener(private val starship: ElementModel): EventListener<KeyPressed> {
    override fun handle(event: KeyPressed) {
        when(event.key) {
            KeyCode.UP -> starship.y.set(starship.y.value - 5 )
            KeyCode.DOWN -> starship.y.set(starship.y.value + 5)
            KeyCode.LEFT -> starship.x.set(starship.x.value - 5 )
            KeyCode.RIGHT -> starship.x.set(starship.x.value + 5 )
            else -> {}
        }
    }

}
//TODO: ADAPT TO UI