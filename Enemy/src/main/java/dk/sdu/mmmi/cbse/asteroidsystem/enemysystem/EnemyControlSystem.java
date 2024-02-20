package dk.sdu.mmmi.cbse.asteroidsystem.enemysystem;

import dk.sdu.mmmi.cbse.asteroidsystem.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.Entity;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.GameData;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.World;
import dk.sdu.mmmi.cbse.asteroidsystem.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements IEntityProcessingService {

    private Random rng = new Random();

    private final int SHOOTING_FREQUENCY = 5;
    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            int move = rng.nextInt(3);
            switch(move) {
                case 0: enemy.setRotation(enemy.getRotation() - 5);
                        break;
                case 1: enemy.setRotation(enemy.getRotation() + 5);
                        break;
                case 2: break;
            }
            int shootingNumber = rng.nextInt(0,100);

            if(shootingNumber < SHOOTING_FREQUENCY) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createBullet(enemy, gameData));}
                );
            }

            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(enemy.getX() + changeX);
            enemy.setY(enemy.getY() + changeY);

            if (enemy.getX() < 0) {
                enemy.setX(1);
                enemy.setRotation(enemy.getRotation() + 45);
            }

            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(gameData.getDisplayWidth()-1);
                enemy.setRotation(enemy.getRotation() + 45);
            }

            if (enemy.getY() < 0) {
                enemy.setY(1);
                enemy.setRotation(enemy.getRotation() + 45);
            }

            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(gameData.getDisplayHeight()-1);
                enemy.setRotation(enemy.getRotation() + 45);
            }


        }
    }


    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
