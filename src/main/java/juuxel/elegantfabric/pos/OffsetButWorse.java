package juuxel.elegantfabric.pos;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;
import org.cactoos.scalar.Constant;

public final class OffsetButWorse implements Scalar<BlockPos> {
    private final Scalar<BlockPos> pos;
    private final Scalar<Direction> direction;

    public OffsetButWorse(Scalar<BlockPos> pos, Scalar<Direction> direction) {
        this.pos = pos;
        this.direction = direction;
    }

    public OffsetButWorse(Scalar<BlockPos> pos, Direction direction) {
        this(pos, () -> direction);
    }

    public OffsetButWorse(BlockPos pos, Scalar<Direction> direction) {
        this(() -> pos, direction);
    }

    // This is the part where it gets worse.
    // Instead of storing the offset distance, OBW creates child objects until the pos if offset enough.

    public OffsetButWorse(Scalar<BlockPos> pos, Scalar<Direction> direction, int amount) {
        this(amount <= 1 ? pos : new OffsetButWorse(pos, direction, amount - 1), direction);
    }

    public OffsetButWorse(BlockPos pos, Scalar<Direction> direction, int amount) {
        this(amount <= 1 ? new Constant<>(pos) : new OffsetButWorse(pos, direction, amount - 1), direction);
    }

    public OffsetButWorse(Scalar<BlockPos> pos, Direction direction, int amount) {
        this(amount <= 1 ? pos : new OffsetButWorse(pos, direction, amount - 1), direction);
    }

    public OffsetButWorse(BlockPos pos, Direction direction, int amount) {
        this(amount <= 1 ? new Constant<>(pos) : new OffsetButWorse(pos, direction, amount - 1), direction);
    }

    @Override
    public BlockPos value() throws Exception {
        return pos.value().offset(direction.value());
    }
}
