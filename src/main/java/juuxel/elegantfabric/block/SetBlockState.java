package juuxel.elegantfabric.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.cactoos.Proc;
import org.cactoos.Scalar;

public final class SetBlockState implements Proc<World> {
    public static final int DEFAULT_FLAGS = 0b11;

    private final Scalar<BlockPos> pos;
    private final Scalar<BlockState> state;
    private final int flags;

    public SetBlockState(Scalar<BlockPos> pos, Scalar<BlockState> state, int flags) {
        this.pos = pos;
        this.state = state;
        this.flags = flags;
    }

    public SetBlockState(Scalar<BlockPos> pos, Scalar<BlockState> state) {
        this(pos, state, DEFAULT_FLAGS);
    }

    public SetBlockState(BlockPos pos, BlockState state, int flags) {
        this(() -> pos, () -> state, flags);
    }

    public SetBlockState(BlockPos pos, BlockState state) {
        this(() -> pos, () -> state);
    }

    @Override
    public void exec(World input) throws Exception {
        input.setBlockState(pos.value(), state.value(), flags);
    }
}
