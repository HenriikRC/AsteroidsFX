package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * 3);
            bullet.setY(bullet.getY() + changeY * 3);
        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        Entity bullet = new Bullet();
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);

        // Calculate the direction in which the shooter is facing
        double dirX = Math.cos(Math.toRadians(shooter.getRotation()));
        double dirY = Math.sin(Math.toRadians(shooter.getRotation()));

        // Calculate the initial position of the bullet
        double bulletStartX = shooter.getX() + dirX * (shooter.getRadius() + bullet.getRadius());
        double bulletStartY = shooter.getY() + dirY * (shooter.getRadius() + bullet.getRadius());

        bullet.setX(bulletStartX);
        bullet.setY(bulletStartY);
        bullet.setRotation(shooter.getRotation());
        bullet.setRadius(1);
        bullet.setEntityType(EntityType.BULLET);
        return bullet;
    }
}
