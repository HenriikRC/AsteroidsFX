package dk.sdu.mmmi.cbse.asteroidsystem.common.services;

import dk.sdu.mmmi.cbse.asteroidsystem.common.data.GameData;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService {

    void process(GameData gameData, World world);
}
