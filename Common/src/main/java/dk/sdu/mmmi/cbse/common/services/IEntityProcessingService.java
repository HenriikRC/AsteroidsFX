package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     * Implemented in services that manages game updates, for example movement.
     *
     * Pre-conditions:
     * gameData != null
     * world is initialized with the relevant entities that should be processed.
     *
     * Post-conditions:
     * All entities in world are updated based on the specific implementation of process in the service(s).
     *
     * @param gameData
     * @param world
     * @throws
     */
    void process(GameData gameData, World world);
}
