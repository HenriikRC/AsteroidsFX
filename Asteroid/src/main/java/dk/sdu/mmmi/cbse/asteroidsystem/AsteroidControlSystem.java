package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        world.getEntities(Asteroid.class).forEach(entity -> {
            if (entity instanceof Asteroid) {
                Asteroid asteroid = (Asteroid) entity;

                double dx = Math.cos(Math.toRadians(asteroid.getRotation())) * asteroid.getSpeed();
                double dy = Math.sin(Math.toRadians(asteroid.getRotation())) * asteroid.getSpeed();
                asteroid.setX(asteroid.getX() + dx);
                asteroid.setY(asteroid.getY() + dy);


                /*
                if (asteroid.getX() < 0 || asteroid.getX() > gameData.getDisplayWidth()||

                        asteroid.getY() < 0 || asteroid.getY() > gameData.getDisplayHeight()) {
                    world.removeEntity(asteroid);
                }
                */

            }
        });
    }
}
