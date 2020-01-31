package juuxel.elegantfabric.pos;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public final class ConstantOffset extends BlockPos {
    public ConstantOffset(BlockPos origin, Direction direction) {
        super(
            origin.getX() + direction.getOffsetX(),
            origin.getY() + direction.getOffsetY(),
            origin.getZ() + direction.getOffsetZ()
        );
    }

    public ConstantOffset(BlockPos origin, Direction direction, int amount) {
        super(
            origin.getX() + direction.getOffsetX() * amount,
            origin.getY() + direction.getOffsetY() * amount,
            origin.getZ() + direction.getOffsetZ() * amount
        );
    }
}
