package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.AsteroidSPI;
import dk.sdu.mmmi.cbse.common.services.HpSPI;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class CollisionDetector implements IPostEntityProcessingService {

    public CollisionDetector() {
    }

    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;
                }

                if(collides(entity1, entity2)) {
                    // CollisionDetection
                    if (entity1.getEntityType() == EntityType.PLAYER || entity1.getEntityType() == EntityType.ENEMY) {
                        if (entity2.getEntityType() == EntityType.BULLET) {
                            getHpSPI().reduceHp(entity1, world);
                        }
                    } else if (entity1.getEntityType() == EntityType.ASTEROID) {
                        if (entity2.getEntityType() == EntityType.BULLET) {
                            getAsteroidSPI().splitAsteroid(entity1, world);
                        }
                    }
                }
            }
        }
    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }

    private AsteroidSPI getAsteroidSPI() {
        return ServiceLoader.load(AsteroidSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList()).stream().findFirst().get();
    }

    private HpSPI getHpSPI() {
        return ServiceLoader.load(HpSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList()).stream().findFirst().get();
    }
}
