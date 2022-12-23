package edu.austral.ingsis.starships

import config.Config.*
import edu.austral.ingsis.starships.ui.*
import edu.austral.ingsis.starships.ui.ElementColliderType.*
import entities.Asteroid
import entities.Entity
import entities.EntityShape
import entities.EntityType
import game.Game
import javafx.application.Application
import javafx.application.Application.launch
import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import movement.Position
import java.awt.Label

import kotlin.system.exitProcess

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
        val BULLET_IMAGE_REF = ImageRef("shot" , BULLET_HEIGHT , BULLET_WIDTH)
        val game = Game()
        val adapter = Adapter()

    }

    override fun start(primaryStage: Stage) {
        val pane = gameScene()
        val menu = menu(primaryStage , pane)
        game.newGame()
        facade.timeListenable.addEventListener(TimeListener(facade.elements , game , this))
        facade.collisionsListenable.addEventListener(CollisionListener(game))
        keyTracker.keyPressedListenable.addEventListener(KeyPressedListener(game , this , primaryStage , pane ))
        facade.showCollider.value = false;


        keyTracker.scene = menu

        primaryStage.scene = menu
        primaryStage.height = WINDOW_HEIGHT
        primaryStage.width = WINDOW_WIDTH

        facade.start()
        keyTracker.start()
        primaryStage.show()
        createEntities()

    }

    override fun stop() {
        facade.stop()
        keyTracker.stop()
        exitProcess(0)
    }
    private fun gameScene(): StackPane {
        val pane = StackPane()
        val root = facade.view
        pane.children.addAll(root )
        root.id = "pane"

        return pane
    }
    private fun menu(primaryStage: Stage, pane: StackPane): Scene{
        val verticalLayout = VBox(50.0)
        verticalLayout.id = "menu"
        verticalLayout.children
        val menu = Scene(verticalLayout)
        menu.stylesheets.add(this::class.java.classLoader.getResource("styles.css")?.toString())
        return menu
    }

    private fun createEntities(){
        val entities = game.entities
        for(entity in entities){
            facade.elements[entity.id] = adapter.adaptEntity(entity)
        }
    }
    fun convertShape(shape: EntityShape) : ElementColliderType {
        return when (shape) {
            EntityShape.ELLIPTICAL -> Elliptical
            EntityShape.RECTANGULAR -> Rectangular
            EntityShape.TRIANGULAR -> Triangular
        }
    }
}

class TimeListener(private val elements: Map<String, ElementModel> , private val game: Game , private val starships: Starships) : EventListener<TimePassed> {
    override fun handle(event: TimePassed) {
        if (game.isOver) {
            game.reset()
            starships.stop()
        }
        game.update()
        val entities = game.entities ?: return
        for (entity in entities) {
            val element = elements.get(entity.id)
            val values = entity.posRotSz
            if (element != null) {
                element.x.set(values[0])
                element.y.set(values[1])
                element.rotationInDegrees.set(values[2])
                element.height.set(values[3])
                element.width.set(values[4])
            }
        }
    }
}

class CollisionListener(private val game: Game) : EventListener<Collision> {
    override fun handle(event: Collision) {
        game.handleCollision(event.element1Id ,event.element2Id )
        println("${event.element1Id} ${event.element2Id}")

    }

}

class KeyPressedListener(private val game: Game, private val starships: Starships, private val primaryStage: Stage, private val pane: StackPane): EventListener<KeyPressed> {
    override fun handle(event: KeyPressed) {
        val map = game.configuration.keyMap;
        when (event.key) {
            map["forward-1"] -> game.moveShip(0, Position(0.0, -1.0))
            map["backwards-1"] -> game.moveShip(0, Position(0.0, 1.0))
//            map["left-1"] -> game.moveShip(0, Position(-1.0, 0.0))
//            map["right-1"] -> game.moveShip(0, Position(1.0, 0.0))
            map["stop-1"] -> game.moveShip(0, Position(0.0, 0.0))
            map["rotate-left-1"] -> game.rotateShip(0, -5.0)
            map["rotate-right-1"] -> game.rotateShip(0, 5.0)
            map["shoot-1"] -> game.shoot(0)

            else -> {}
        }
        if (game.players.size == 2) {
            when (event.key) {
                map["forward-2"] -> game.moveShip(1, Position(0.0, -1.0))
                map["backwards-2"] -> game.moveShip(1, Position(0.0, 1.0))
//                map["left-2"] -> game.moveShip(1, Position(-1.0, 0.0))
//                map["right-2"] -> game.moveShip(1, Position(1.0, 0.0))
                map["stop-2"] -> game.moveShip(1, Position(0.0, 0.0))
                map["rotate-left-2"] -> game.rotateShip(1, -5.0)
                map["rotate-right-2"] -> game.rotateShip(1, 5.0)
                map["shoot-2"] -> game.shoot(1)

                else -> {}
            }
        }
    }

}
