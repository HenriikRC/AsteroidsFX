
import dk.sdu.mmmi.cbse.asteroidsystem.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.asteroidsystem.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.asteroidsystem.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.asteroidsystem.enemysystem.EnemyControlSystem;
import dk.sdu.mmmi.cbse.asteroidsystem.enemysystem.EnemyPlugin;

module Enemy {
    requires Common;
    requires CommonBullet;
    uses BulletSPI;
    provides IGamePluginService with EnemyPlugin;
    provides IEntityProcessingService with EnemyControlSystem;

}
