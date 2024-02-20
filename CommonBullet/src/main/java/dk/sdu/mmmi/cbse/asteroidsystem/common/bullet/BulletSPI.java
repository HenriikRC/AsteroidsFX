package dk.sdu.mmmi.cbse.asteroidsystem.common.bullet;

import dk.sdu.mmmi.cbse.asteroidsystem.common.data.Entity;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.GameData;

/**
 *
 * @author corfixen
 */
public interface BulletSPI {
    Entity createBullet(Entity e, GameData gameData);
}
