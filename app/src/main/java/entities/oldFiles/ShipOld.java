package entities.oldFiles;

import entities.Entity;

public class ShipOld {
//    final String id;
//    final EntityType type;
//    final double health;
//    final double height;
//    final double width;
//    final Position position;
//    final double speed;
//    final String ownerId;
//    final double rotation;
//    final double xs;
//    final double ys;
//    public Ship(String id, double xs , double ys, Position position, String ownerId, double rotation , double health) {
//        this.id = id;
//        this.ownerId = ownerId;
//        this.rotation = rotation;
//        this.xs = xs;
//        this.ys = ys;
//        this.health = health;
//        this.position = position;
//        this.width = Config.SHIP_WIDTH;
//        this.height = Config.SHIP_HEIGHT;
//        this.speed = Config.SHIP_SPEED;
//        this.type = EntityType.SHIP;
//
//    }
//
//    public double getXs() {
//        return xs;
//    }
//
//    public double getYs() {
//        return ys;
//    }
//
//    @Override
//    public double getX() {
//        return Math.cos(Math.toRadians(rotation));
//    }
//
//    @Override
//    public double getY() {
//        return Math.sin(Math.toRadians(rotation));
//    }
//
//    @Override
//    public double calculateSpeed() {
//        return Math.sqrt(Math.pow(position.getX(), 2) + Math.pow(position.getY(),2));
//    }
//
//    @Override
//    public Position getPosition() {
//        return position;
//    }
//
//    @Override
//    public String getId() {
//        return id;
//    }
//
//    @Override
//    public double getRotation() {
//        return rotation;
//    }
//
//    @Override
//    public Entity update() {
//        Position pos = verify(new Position(position.getX() + xs , position.getY() + ys));
//        return new Ship(id, pos.getX()/1.005 , pos.getY()/1.005, pos , ownerId , rotation , health);
//    }
//
//    @Override
//    public Position verify(Position pos) {
//        if(pos.getX() < 0) return new Position(pos.getX() + WINDOW_WIDTH, pos.getY());
//        if(pos.getX() > WINDOW_WIDTH) return new Position(pos.getX() - WINDOW_WIDTH , pos.getY());
//        if(pos.getY() < 0) return new Position(pos.getX() , pos.getY() + WINDOW_HEIGHT);
//        if(pos.getY() > WINDOW_HEIGHT) return new Position(pos.getX() , pos.getY() - WINDOW_HEIGHT);
//        else {
//            return pos;
//        }
//    }
//
//    @Override
//    public EntityType getType() {
//        return type;
//    }
//
//    @Override
//    public double getDamage() {
//        return health;
//    }
//
//    @Override
//    public Optional<Entity> collide(Entity enemy) {
//        if(enemy.getType().equals(EntityType.ASTEROID)) {
//            if(enemy.getPosition().equals(position) && this.getHealth() - enemy.getDamage() > 0){
//                Optional.of(new Ship(id , xs , ys , position , ownerId , rotation , health - enemy.getDamage()));
//            }
//        }if(enemy.getType().equals(EntityType.BULLET) || enemy.getType().equals(EntityType.SHIP)){
//            return Optional.of(this);
//        }else{
//            return Optional.empty();
//        }
//    }
//
//    @Override
//    public double getHeight() {
//        return height;
//    }
//
//    @Override
//    public String getOwnerId() {
//        return ownerId;
//    }
//
//    @Override
//    public double getWidth() {
//        return width;
//    }
//
//    public double getHealth() {
//        return health;
//    }
//TODO: HACER QUE PUEDA DISPARAR ESTA MIERDA

}
