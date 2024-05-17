package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author HRC
 */

public class Enemy extends Entity {

    private double speed = 0.5;
    private int healthPoints = 3;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int setHealthPoints(int healthPoints) {
        return this.healthPoints = healthPoints;
    }

}
