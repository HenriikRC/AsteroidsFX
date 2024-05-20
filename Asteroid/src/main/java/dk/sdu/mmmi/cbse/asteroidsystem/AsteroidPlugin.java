package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.commonasteroid.Asteroid;

import java.util.Random;

public class AsteroidPlugin  implements IGamePluginService, IEntityProcessingService {

    private final Random rand = new Random();
    private final int MAX_ASTEROIDS = 10;
    private final int SPAWN_INTERVAL = 3000;
    private volatile long lastSpawnTime = 0;
    private final double MIN_SPEED = 0.5d;
    private final double MAX_SPEED = 2d;

    @Override
    public void start(GameData gameData, World world) {
        /*for(int i = 0; i <= MAX_ASTEROIDS/2; i++) {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }

         */
    }

    @Override
    public void process(GameData gameData, World world) {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastSpawnTime >= SPAWN_INTERVAL && world.getEntities(Asteroid.class).size() < MAX_ASTEROIDS) {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
            System.out.println("Spawned 1 more" + asteroid.getX() + " " + asteroid.getY());
            lastSpawnTime = currentTime;
        }
    }

    private Entity createAsteroid(GameData gameData) {
        Asteroid asteroid = new Asteroid();
        int size = rand.nextInt(20,40);
        asteroid.setSize(size);
        asteroid.setPolygonCoordinates(0, 0, size, 0, size, size, 0, size,0,size);
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

        asteroid.setRadius(size);

        asteroid.setEntityType(EntityType.ASTEROID);
        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.getEntities(Asteroid.class).forEach(world::removeEntity);
    }

}
