package mod.linguardium.spawnchunks.mixin;

import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.gen.Invoker;

import static mod.linguardium.spawnchunks.Main.SPAWN_CHUNK_RANGE;

@Mixin(GameRules.class)
public class RegisterGameRule{

    @Invoker
    public static <T extends GameRules.Rule<T>> GameRules.Key<T> callRegister(String key, GameRules.Category category, GameRules.Type<T> type) {
        throw new NotImplementedException("GameRules mixin failed");
    }
    static {
        callRegister(SPAWN_CHUNK_RANGE, GameRules.Category.UPDATES, IntegerGameRuleAccessor.invokeCreate(11));

   }
}