module Core {
    requires Common;
    requires CommonBullet;
    requires javafx.graphics;
    requires spring.context;
    requires spring.core;
    requires spring.beans;

    opens dk.sdu.mmmi.cbse.core to spring.core, javafx.graphics;
    exports dk.sdu.mmmi.cbse.core;

    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
}
