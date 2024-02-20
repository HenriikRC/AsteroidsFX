package dk.sdu.mmmi.cbse.asteroidsystem.common.services;

import dk.sdu.mmmi.cbse.asteroidsystem.common.data.GameData;
import dk.sdu.mmmi.cbse.asteroidsystem.common.data.World;

public interface IGamePluginService {

    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}