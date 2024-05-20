
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.commonspaceship.HpSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.commonplayer.TargetSPI;
import dk.sdu.mmmi.cbse.enemysystem.EnemyControlSystem;
import dk.sdu.mmmi.cbse.enemysystem.EnemyPlugin;

module Enemy {
    requires Common;
    requires CommonBullet;
    requires CommonEnemy;
    requires CommonPlayer;
    requires CommonSpaceship;
    uses TargetSPI;
    uses BulletSPI;
    provides IGamePluginService with EnemyPlugin;
    provides IEntityProcessingService with EnemyControlSystem;
    provides HpSPI with EnemyControlSystem;
}
