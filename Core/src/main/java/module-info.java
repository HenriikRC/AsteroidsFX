import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Core {
    requires Common;
    requires CommonBullet;    
    requires javafx.graphics;    
    opens dk.sdu.mmmi.cbse.core to javafx.graphics;
    uses IGamePluginService;
    uses IEntityProcessingService;
}


