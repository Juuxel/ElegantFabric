package juuxel.elegantfabric.pos;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;
import org.cactoos.scalar.Unchecked;

public final class Offset extends BlockPos {
    public Offset(BlockPos origin, Direction direction) {
        this(origin, direction, 1);
    }

    public Offset(Scalar<BlockPos> origin, Scalar<Direction> direction) {
        this(new Unchecked<>(origin).value(), new Unchecked<>(direction).value());
    }

    public Offset(BlockPos origin, Scalar<Direction> direction) {
        this(origin, new Unchecked<>(direction).value());
    }

    public Offset(Scalar<BlockPos> origin, Direction direction) {
        this(new Unchecked<>(origin).value(), direction);
    }

    public Offset(Scalar<BlockPos> origin, Scalar<Direction> direction, int amount) {
        this(new Unchecked<>(origin).value(), new Unchecked<>(direction).value(), amount);
    }

    public Offset(BlockPos origin, Scalar<Direction> direction, int amount) {
        this(origin, new Unchecked<>(direction).value(), amount);
    }

    public Offset(Scalar<BlockPos> origin, Direction direction, int amount) {
        this(new Unchecked<>(origin).value(), direction);
    }

    public Offset(BlockPos origin, Direction direction, int amount) {
        super( // Slightly more optimized than `super(origin.offset(direction, amount));`
            origin.getX() + direction.getOffsetX() * amount,
            origin.getY() + direction.getOffsetY() * amount,
            origin.getZ() + direction.getOffsetZ() * amount
        );
    }
}
