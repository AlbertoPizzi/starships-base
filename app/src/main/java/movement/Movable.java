package movement;


import entities.Entity;

public interface Movable {
     double getX();
     double getY();
     double calculateSpeed();
     Position getPosition();

     String getId();
     Entity getEntity();
     double getRotation();

     Movable update();
     Position verify(Position pos);
}
