package juuxel.elegantfabric.pos;

import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;

public final class BlockPosOf extends BlockPos {
    public BlockPosOf(BlockHitResult hit) {
        super(hit.getBlockPos());
    }
}
