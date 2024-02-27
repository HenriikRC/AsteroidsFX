package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin  implements IGamePluginService {

    private final Random rand = new Random();
    private final int MAX_ASTEROIDS = 15;
    private final double MIN_SPEED = 0.1d;
    private final double MAX_SPEED = 1.5d;

    @Override
    public void start(GameData gameData, World world) {
        for(int i = 0; i <= MAX_ASTEROIDS; i++) {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }
    }

    private Entity createAsteroid(GameData gameData) {
        Asteroid asteroid = new Asteroid();
        asteroid.setPolygonCoordinates(0, 0, 10, 0, 10, 10, 0, 10);
        int side = rand.nextInt(4);

        double x, y;
        double angle;
        switch (side) {
            case 0: // top
                x = rand.nextDouble() * gameData.getDisplayWidth();
                y = gameData.getDisplayHeight() + 10;
                angle = rand.nextDouble(90,270);
                break;
            case 1: // right
                x = gameData.getDisplayWidth() + 10;
                y = rand.nextDouble() * gameData.getDisplayHeight();
                angle = rand.nextDouble(0,180);
                break;
            case 2: // bottom
                x = rand.nextDouble() * gameData.getDisplayWidth();
                y = -10;
                if(rand.nextBoolean()){
                    angle = rand.nextDouble(270,360);
                } else {
                    angle = rand.nextDouble(0,90);
                }
                break;
            case 3: // left
            default:
                x = -10;
                y = rand.nextDouble() * gameData.getDisplayHeight();
                angle = rand.nextDouble(180,360);
                break;
        }

        asteroid.setX(x);
        asteroid.setY(y);
        asteroid.setRotation(angle);
        //asteroid.setRotation(rand.nextInt(360));

        double speed = rand.nextDouble(MIN_SPEED, MAX_SPEED);
        asteroid.setSpeed(speed);

        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.getEntities(Asteroid.class).forEach(world::removeEntity);
    }
}
