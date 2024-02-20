
import dk.sdu.mmmi.cbse.asteroidsystem.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.asteroidsystem.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.asteroidsystem.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.asteroidsystem.playersystem.PlayerControlSystem;
import dk.sdu.mmmi.cbse.asteroidsystem.playersystem.PlayerPlugin;

module Player {
    requires Common;
    requires CommonBullet;   
    uses BulletSPI;
    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with PlayerControlSystem;
    
}
