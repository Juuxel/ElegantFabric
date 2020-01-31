package juuxel.elegantfabric.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.cactoos.Scalar;

public final class BlockStateAt implements Scalar<BlockState> {
    private final World world;
    private final Scalar<BlockPos> pos;

    public BlockStateAt(World world, Scalar<BlockPos> pos) {
        this.world = world;
        this.pos = pos;
    }

    public BlockStateAt(World world, BlockPos pos) {
        this(world, () -> pos);
    }

    @Override
    public BlockState value() throws Exception {
        return world.getBlockState(pos.value());
    }
}
