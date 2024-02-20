package dk.sdu.mmmi.cbse.asteroidsystem.common.services;

import dk.sdu.mmmi.cbse.asteroidsystem.common.data.GameData;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.World;

public interface IEntityProcessingService {

    /**
     *
     *
     *
     * @param gameData
     * @param world
     * @throws
     */
    void process(GameData gameData, World world);
}
