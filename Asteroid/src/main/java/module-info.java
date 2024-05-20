
import dk.sdu.mmmi.cbse.commonasteroid.AsteroidSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    requires CommonAsteroid;

    provides IGamePluginService with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidControlSystem, dk.sdu.mmmi.cbse.asteroidsystem.AsteroidPlugin;
    provides AsteroidSPI with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidControlSystem;

    exports dk.sdu.mmmi.cbse.asteroidsystem;
}
