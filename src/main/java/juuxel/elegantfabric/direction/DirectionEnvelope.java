package juuxel.elegantfabric.direction;

import net.minecraft.util.math.Direction;
import org.cactoos.Scalar;

public abstract class DirectionEnvelope implements Scalar<Direction> {
    private final Scalar<Direction> origin;

    public DirectionEnvelope(Scalar<Direction> origin) {
        this.origin = origin;
    }

    @Override
    public final Direction value() throws Exception {
        return origin.value();
    }
}
