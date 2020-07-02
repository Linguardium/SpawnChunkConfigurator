package mod.linguardium.spawnchunks;

import net.fabricmc.api.ModInitializer;

import net.minecraft.world.GameRules;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "spawnchunks";
    public static final String MOD_NAME = "SpawnChunkConfigurator";

    public static String SPAWN_CHUNK_RANGE = "spawnChunkRange";
    public static GameRules.Key<GameRules.IntRule> SPAWN_CHUNK_RANGE_KEY = new GameRules.Key<>(SPAWN_CHUNK_RANGE, GameRules.Category.UPDATES);


    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}