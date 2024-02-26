package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin  implements IGamePluginService {

    private final Random rand = new Random();
    private final int MAX_ASTEROIDS = 15;
    private final double MIN_SPEED = 1d;
    private final double MAX_SPEED = 3d;

    @Override
    public void start(GameData gameData, World world) {
        Entity asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {
        Asteroid asteroid = new Asteroid();
        asteroid.setPolygonCoordinates(0, 0, 10, 0, 10, 10, 0, 10);
        // Randomly select a side for the asteroid to spawn
        int side = rand.nextInt(4); // 0: top, 1: right, 2: bottom, 3: left

        double x, y;
        x= 50;
        y = 50;
        /*
        switch (side) {
            case 0: // top
                x = rand.nextDouble() * gameData.getDisplayWidth();
                y = gameData.getDisplayHeight() + 10;
                break;
            case 1: // right
                x = gameData.getDisplayWidth() + 10;
                y = rand.nextDouble() * gameData.getDisplayHeight();
                break;
            case 2: // bottom
                x = rand.nextDouble() * gameData.getDisplayWidth();
                y = -10;
                break;
            case 3: // left
            default:
                x = -10;
                y = rand.nextDouble() * gameData.getDisplayHeight();
                break;
        }

         */

        asteroid.setX(x);
        asteroid.setY(y);
        asteroid.setRotation(rand.nextInt(360));

        double speed = rand.nextDouble(MIN_SPEED, MAX_SPEED);
        asteroid.setSpeed(speed);

        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.getEntities(Asteroid.class).forEach(world::removeEntity);
    }
}
