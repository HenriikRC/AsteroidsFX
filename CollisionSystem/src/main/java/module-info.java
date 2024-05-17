import dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module CollisionSystem {
    uses dk.sdu.mmmi.cbse.common.services.AsteroidSPI;
    uses dk.sdu.mmmi.cbse.common.services.HpSPI;
    requires Common;
    provides IPostEntityProcessingService with CollisionDetector;
}