package dk.sdu.mmmi.cbse.asteroidsystem.enemysystem;

import dk.sdu.mmmi.cbse.asteroidsystem.common.data.Entity;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.GameData;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.World;
import dk.sdu.mmmi.cbse.asteroidsystem.common.services.IGamePluginService;

import java.util.Random;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    @Override
    public void start(GameData gameData, World world) {
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData) {
        Entity enemyShip = new Enemy();
        enemyShip.setPolygonCoordinates(-5,-5,10,0,-5,5);
        Random randomGenerator = new Random();
        double randomX = randomGenerator.nextDouble(0, gameData.getDisplayHeight());
        double randomY = randomGenerator.nextDouble(0, gameData.getDisplayWidth());
        enemyShip.setX(randomX);
        enemyShip.setY(randomY);
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
}
