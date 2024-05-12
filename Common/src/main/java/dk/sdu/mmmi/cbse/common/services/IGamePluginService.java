package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    /**
     * Initializes entities when the application is started and when a plugin is inserted.
     *
     * Pre-conditions:
     * gameData is initialized
     * world is initialized
     *
     * Post-conditions:
     * Entities are added to world
     *
     * @param gameData
     * @param world
     */
    void start(GameData gameData, World world);

    /**
     * Removes entities upon stopping the game or removing a plugin
     *
     * Pre-conditions:
     * gameData is initialized
     * world is initialized
     *
     * Post-conditions:
     * Entities are removed from world
     *
     * @param gameData
     * @param world
     */
    void stop(GameData gameData, World world);
}
