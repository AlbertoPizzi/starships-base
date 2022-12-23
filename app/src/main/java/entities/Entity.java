package entities;

import movement.Position;

public class Entity {
    private final String id;

    private final EntityType type;
    private final EntityShape shape;
    private final double height;
    private final double width;

    private final Position position;
    private final Position direction;
    private final double speed;
    private final double rotationDegrees;
    private final boolean isVisible;
    private final double currentHealth;

    private final double dmg;

    public Entity(String id, EntityType type, EntityShape shape, double height
            , double width, Position position, Position direction, double speed
            , double rotationDegrees,double dmg, boolean isVisible, double currentHealth ) {
        this.id = id;
        this.type = type;
        this.shape = shape;
        this.height = height;
        this.width = width;
        this.position = position;
        this.direction = direction;
        this.speed = speed;
        this.rotationDegrees = rotationDegrees;
        this.isVisible = isVisible;
        this.currentHealth = currentHealth;
        this.dmg = dmg;
    }
    public Entity setId(String id){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setEntityType(EntityType type){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setPosition(Position position){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setEntityShape(EntityShape shape){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setHeight(double height){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setWidth(double width){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setRotationDegrees(double rotationDegrees){
        return new Entity(id , type , shape , height, width , position, new Position(direction.getX() , direction.getY() + rotationDegrees)
                , speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setSpeed(double speed){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setDirection(Position direction){
        return new Entity(id , type , shape , height, width , position, this.direction.sum(direction), speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setDirectionSpeed( Position direction){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setCurrentHealth(double currentHealth){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }
    public Entity setIsVisible(boolean isVisible){
        return new Entity(id , type , shape , height, width , position, direction, speed, rotationDegrees , dmg , isVisible, currentHealth);
    }

    public String getId() {
        return id;
    }

    public EntityType getType() {
        return type;
    }

    public EntityShape getShape() {
        return shape;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Position getPosition() {
        return position;
    }

    public Position getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public double getRotationDegrees() {
        return rotationDegrees;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public double getDmg() {
        return dmg;
    }
}
