package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.TargetSPI;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements IEntityProcessingService {

    private Random rng = new Random();

    private final int SHOOTING_FREQUENCY = 3;
    private final int MAX_NO_ENEMIES = 15;

    @Override
    public void process(GameData gameData, World world) {


        Optional<TargetSPI> targetService = ServiceLoader.load(TargetSPI.class).findFirst();

        for (Entity enemy : world.getEntities(Enemy.class)) {
            if(targetService.isPresent()) {
                double speed = ((Enemy)enemy).getSpeed();
                double playerX = targetService.get().getTargetX();
                double playerY = targetService.get().getTargetY();

                double angleBetweenEntities = calculateAngle(enemy.getX(), enemy.getY(), playerX, playerY);

                enemy.setRotation(angleBetweenEntities);

                double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
                double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
                enemy.setX(enemy.getX() + changeX * speed);
                enemy.setY(enemy.getY() + changeY * speed);
            }

            int shootingNumber = rng.nextInt(0,100);
            if(shootingNumber < SHOOTING_FREQUENCY) {
                attemptToShootAtPlayer(enemy, gameData, world);
            }
            adjustPosition(enemy, gameData);
        }
    }

    public void spawnEnemy(){

    }


    private void attemptToShootAtPlayer(Entity enemy, GameData gameData, World world) {
        Optional<TargetSPI> targetService = ServiceLoader.load(TargetSPI.class).findFirst();
        if (targetService.isPresent()) {
            double playerX = targetService.get().getTargetX();
            double playerY = targetService.get().getTargetY();

            double angle = calculateAngle(enemy.getX(), enemy.getY(), playerX, playerY);

            ServiceLoader<BulletSPI> loader = ServiceLoader.load(BulletSPI.class);
            Optional<BulletSPI> bulletSPI = loader.findFirst();
            if (bulletSPI.isPresent()) {
                Entity bullet = bulletSPI.get().createBullet(enemy, gameData);
                bullet.setRotation(angle);
                world.addEntity(bullet);
            }
        }
    }

    private double calculateAngle(double enemyX, double enemyY, double playerX, double playerY) {
        double dx = playerX - enemyX;
        double dy = playerY - enemyY;
        double angleRadians =  Math.atan2(dy, dx);
        double angleDegrees =  Math.toDegrees(angleRadians);
        if (angleDegrees < 0) {
            angleDegrees += 360;
        }
        return angleDegrees;
    }

    private void adjustPosition(Entity enemy, GameData gameData) {
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

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
