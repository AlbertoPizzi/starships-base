package edu.austral.ingsis.starships

import config.Config.*
import edu.austral.ingsis.starships.ui.ElementColliderType
import edu.austral.ingsis.starships.ui.ElementModel
import edu.austral.ingsis.starships.ui.ImageRef
import entities.Asteroid
import entities.Bullet
import entities.Entity
import entities.EntityType
import entities.Ship

class Adapter {
    fun adaptEntity(entity: Entity): ElementModel{
        return when(entity.type){
            EntityType.ASTEROID -> adaptAsteroid(entity as Asteroid)
            EntityType.BULLET -> adaptBullet(entity as Bullet)
            EntityType.SHIP -> adaptShip(entity as Ship)
        }
    }
    fun adaptShip(ship: Ship): ElementModel{
        return ElementModel(
            ship.id,
            ship.position.x,
            ship.position.y,
            SHIP_HEIGHT,
            SHIP_WIDTH,
            ship.rotationDegrees,
            ElementColliderType.Triangular,
            ImageRef(SHIP_IMAGE_REF1 , SHIP_HEIGHT , SHIP_WIDTH)
        )
    }
    fun adaptAsteroid(asteroid: Asteroid): ElementModel {
        return ElementModel(
            asteroid.id,
            asteroid.position.x,
            asteroid.position.y,
            100.0,
            70.0,
            asteroid.rotationDegrees,
            ElementColliderType.Elliptical,
            ImageRef(ASTEROID_IMAGE, 100.0, 70.0)
        )
    }

    fun adaptBullet(bullet: Bullet): ElementModel {
        return ElementModel(
            bullet.id,
            bullet.position.x,
            bullet.position.y,
            BULLET_HEIGHT,
            BULLET_WIDTH,
            bullet.rotationDegrees,
            ElementColliderType.Rectangular,
            ImageRef(BULLET_IMAGE, 60.0, 35.0)
        )
    }
}