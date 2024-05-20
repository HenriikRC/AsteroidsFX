import dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module CollisionSystem {
    uses dk.sdu.mmmi.cbse.commonasteroid.AsteroidSPI;
    uses dk.sdu.mmmi.cbse.commonspaceship.HpSPI;
    requires Common;
    requires CommonAsteroid;
    requires CommonSpaceship;
    provides IPostEntityProcessingService with CollisionDetector;

    exports dk.sdu.mmmi.cbse.collisionsystem;
}