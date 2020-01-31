package juuxel.elegantfabric.direction;

import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;

public final class Opposite extends DirectionEnvelope {
    public Opposite(Scalar<Direction> direction) {
        super(() -> direction.value().getOpposite());
    }

    public Opposite(Direction direction) {
        this(() -> direction);
    }
}
