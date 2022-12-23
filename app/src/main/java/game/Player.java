package game;

import entities.Ship;

public class Player {
    private final String id;
    private final double points;
    private final int lives;
    private  Ship ship;
    private boolean isAlive;

    public Player(String id, double points, int lives, Ship shipId , boolean isAlive) {
        this.id = id;
        this.points= points;
        this.lives = lives;
        this.ship = shipId;
        this.isAlive = isAlive;
    }
    public Player removeLives(){
        return new Player(id , points, lives - 1 , ship , isAlive);
    }
    public Player addPoints(double points){
        return new Player(id , this.points + points , lives , ship , isAlive);
    }
    public Player getNewPlayer(){
        return new Player(id, points, lives , ship, isAlive);
    }
    public void setShip(Ship ship){
        this.ship = ship;
    }

    public String getId() {
        return id;
    }

    public double getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }
    public Ship getShip(){
        return ship;
    }
    public Player setIsAlive(boolean isAlive){
        return new Player(id , points , lives , ship , isAlive);
    }
    public boolean isAlive(){
        return isAlive;
    }
    public String getShipId() {
        return ship.getId();
    }
}
