package entities.oldFiles;

import entities.Entity;

public class AsteroidOld  {
//
//    final String id;
//    final EntityType type = EntityType.ASTEROID;
//    final double dmg;
//    final double size;
//    final Position position;
//    final double xOffSet;
//    final double yOffSet;
//
//    public Asteroid(String id, double size, Position position, double xOffSet, double yOffSet) {
//        this.id = id;
//        this.dmg = size * Config.ASTEROID_DMG ;
//        this.size = size;
//        this.position = position;
//        this.xOffSet = xOffSet;
//        this.yOffSet = yOffSet;
//    }
//
//    @Override
//    public double getX() {
//        return 0;
//    }
//
//    @Override
//    public double getY() {
//        return 0;
//    }
//
//    @Override
//    public double calculateSpeed() {
//        return 0;
//    }
//
//    @Override
//    public Position getPosition() {
//        return null;
//    }
//
//    @Override
//    public String getId() {
//        return id;
//    }
//
//    @Override
//    public Entity getEntity() {
//        return null;
//    }
//
//    @Override
//    public double getRotation() {
//        return 0;
//    }
//
//    @Override
//    public Entity update() {
//        return new Asteroid( id , size , new Position(position.getX() + xOffSet, position.getY() + yOffSet ) , xOffSet , yOffSet);
//    }
//
//    @Override
//    public Position verify(Position pos) {
//        return null;
//    }
//
//    @Override
//    public EntityType getType() {
//        return type;
//    }
//
//    @Override
//    public double getDamage() {
//        return 0;
//    }
//
//    @Override
//    public Optional<Entity> collide(Entity enemy) {
//        if(enemy.getType().equals(EntityType.BULLET)){
//            if(size <= Config.MIN_ASTEROID_SIZE){
//                return Optional.empty();
//            }
//            else{
//                return Optional.of(new Asteroid(id, size - enemy.getDamage(), position, xOffSet, yOffSet));
//            }
//        }else {
//            return Optional.of(this);
//        }
//    }
//
//    @Override
//    public double getHeight() {
//        return size;
//    }
//
//    @Override
//    public String getOwnerId() {
//        return "";
//    }
//
//    @Override
//    public double getWidth() {
//        return 0;
//    }
}
