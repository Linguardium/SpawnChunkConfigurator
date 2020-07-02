package mod.linguardium.spawnchunks.mixin;

import net.minecraft.server.world.ChunkTicketManager;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import static mod.linguardium.spawnchunks.Main.SPAWN_CHUNK_RANGE_KEY;

@Mixin(ServerChunkManager.class)
public class ServerChunkManagerMixin {
    @Shadow @Final private ServerWorld world;

    @Shadow @Final private ChunkTicketManager ticketManager;
    @Redirect(at=@At(value="INVOKE",target="Lnet/minecraft/server/world/ChunkTicketManager;addTicket(Lnet/minecraft/server/world/ChunkTicketType;Lnet/minecraft/util/math/ChunkPos;ILjava/lang/Object;)V"),method="addTicket")
    private void modifySTARTTickets(ChunkTicketManager manager, ChunkTicketType type, ChunkPos pos, int radius, Object argument) {
        if (this.world!=null && type.equals(ChunkTicketType.START)) {
            Integer range = radius;
            try {
                range = world.getGameRules().getInt(SPAWN_CHUNK_RANGE_KEY);
            } catch (Exception ignored) { }
            if (range < 1)
                range=1;
            if (range > 32)
                range=32;
            manager.addTicket(type, pos, range, argument);
        }else {
            manager.addTicket(type, pos, radius, argument);
        }

    }
}
