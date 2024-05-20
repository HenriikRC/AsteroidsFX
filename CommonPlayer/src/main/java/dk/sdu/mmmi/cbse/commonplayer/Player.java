package dk.sdu.mmmi.cbse.commonplayer;

import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author Emil
 */
public class Player extends Entity {

    private int healthPoints = 5;

    public int getHealthPoints() {
        return healthPoints;
    }

    public int setHealthPoints(int healthPoints) {
        return this.healthPoints = healthPoints;
    }


}
