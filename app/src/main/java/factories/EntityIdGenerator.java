package factories;

import entities.EntityType;

public class EntityIdGenerator {
    public static int generatedId = 0;

    public static String generateId(EntityType entityType){
        return entityType + ": " + String.valueOf(generatedId++);
    }
}