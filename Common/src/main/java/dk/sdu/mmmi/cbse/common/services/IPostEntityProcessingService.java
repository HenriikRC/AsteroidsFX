package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService {

    /**
     * For Entity processing after the initial processing from IEntityProcessingService.
     *
     * Pre-conditions:
     * gameData is initialized
     * world is initialized
     * All entities have already been processed by IEntityProcessingService
     *
     * Post-conditions:
     * All entities are updated based on the implementation(s) of this method.<
     *
     * @param gameData
     * @param world
     */
    void process(GameData gameData, World world);
}
