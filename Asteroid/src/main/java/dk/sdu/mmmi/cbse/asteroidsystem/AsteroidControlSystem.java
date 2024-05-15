package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.AsteroidSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class AsteroidControlSystem implements IEntityProcessingService, AsteroidSPI {

    @Override
    public void process(GameData gameData, World world) {
        world.getEntities(Asteroid.class).forEach(entity -> {
            if (entity instanceof Asteroid) {
                Asteroid asteroid = (Asteroid) entity;

                double dx = Math.cos(Math.toRadians(asteroid.getRotation())) * asteroid.getSpeed();
                double dy = Math.sin(Math.toRadians(asteroid.getRotation())) * asteroid.getSpeed();
                asteroid.setX(asteroid.getX() + dx);
                asteroid.setY(asteroid.getY() + dy);

                if(asteroid.getX() < -50 || asteroid.getX() > gameData.getDisplayWidth() + 50 || asteroid.getY() < -50 || asteroid.getY() > gameData.getDisplayHeight()+50) {
                    world.removeEntity(asteroid);
                }
                /*
                if (asteroid.getX() < 0 || asteroid.getX() > gameData.getDisplayWidth()||

                        asteroid.getY() < 0 || asteroid.getY() > gameData.getDisplayHeight()) {
                    world.removeEntity(asteroid);
                }
                */

            }
        });
    }

    @Override
    public void splitAsteroid(Entity entity, World world) {
        Asteroid asteroid = (Asteroid) entity;
        int newSize = asteroid.getSize() / 2;
        if (newSize < 10) {
            world.removeEntity(asteroid);
            return;
        }

        double originalAngle = asteroid.getRotation();
        double speed = asteroid.getSpeed();

        Asteroid asteroid1 = new Asteroid();
        asteroid1.setSize(newSize);
        asteroid1.setSpeed(speed);
        asteroid1.setRotation(originalAngle - 45);
        asteroid1.setX(asteroid.getX() + newSize);
        asteroid1.setY(asteroid.getY());
        asteroid1.setPolygonCoordinates(0, 0, newSize, 0, newSize, newSize, 0, newSize,0,newSize);
        asteroid1.setRadius(newSize);

        Asteroid asteroid2 = new Asteroid();
        asteroid2.setSize(newSize);
        asteroid2.setSpeed(speed);
        asteroid2.setRotation(originalAngle + 45);
        asteroid2.setX(asteroid.getX() - newSize);
        asteroid2.setY(asteroid.getY());
        asteroid2.setPolygonCoordinates(0, 0, newSize, 0, newSize, newSize, 0, newSize,0,newSize);
        asteroid2.setRadius(newSize);

        world.addEntity(asteroid1);
        world.addEntity(asteroid2);
        world.removeEntity(asteroid);
    }
}
