
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.commonspaceship.HpSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.commonplayer.TargetSPI;
import dk.sdu.mmmi.cbse.playersystem.PlayerControlSystem;
import dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
import dk.sdu.mmmi.cbse.playersystem.PlayerTargetSystem;

module Player {
    requires Common;
    requires CommonBullet;
    requires CommonPlayer;
    requires CommonSpaceship;
    uses BulletSPI;
    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with PlayerControlSystem;
    provides TargetSPI with PlayerTargetSystem;
    provides HpSPI with PlayerControlSystem;
}
