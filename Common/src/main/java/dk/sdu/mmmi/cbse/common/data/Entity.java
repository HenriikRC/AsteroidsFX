package dk.sdu.mmmi.cbse.common.data;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();
    
    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double rotation;
    private double radius;
    private EntityType entityType;
            

    public String getID() {
        return ID.toString();
    }


    public void setPolygonCoordinates(double... coordinates ) {
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }
       

    public void setX(double x) {
        this.x =x;
    }

    public double getX() {
        return x;
    }

    
    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }
}
