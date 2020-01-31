package juuxel.elegantfabric.pos;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;

public final class Offset implements Scalar<BlockPos> {
    private final Scalar<BlockPos> pos;
    private final Scalar<Direction> direction;
    private final int amount;

    public Offset(Scalar<BlockPos> pos, Scalar<Direction> direction, int amount) {
        this.pos = pos;
        this.direction = direction;
        this.amount = amount;
    }

    public Offset(BlockPos pos, Direction direction, int amount) {
        this(() -> pos, () -> direction, amount);
    }

    public Offset(Scalar<BlockPos> pos, Direction direction) {
        this(pos, () -> direction, 1);
    }

    public Offset(BlockPos pos, Scalar<Direction> direction) {
        this(() -> pos, direction, 1);
    }

    public Offset(BlockPos pos, Direction direction) {
        this(() -> pos, () -> direction, 1);
    }

    @Override
    public BlockPos value() throws Exception {
        return new BlockPos(pos.value().offset(direction.value(), amount));
    }
}
