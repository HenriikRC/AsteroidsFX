
import dk.sdu.mmmi.cbse.asteroidsystem.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.asteroidsystem.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    provides IGamePluginService with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidControlSystem;
}
