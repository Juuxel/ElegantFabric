package juuxel.elegantfabric.direction;

import net.minecraft.util.hit.BlockHitResult;

public final class DirectionOf extends DirectionEnvelope {
    public DirectionOf(BlockHitResult hit) {
        super(hit::getSide);
    }
}
