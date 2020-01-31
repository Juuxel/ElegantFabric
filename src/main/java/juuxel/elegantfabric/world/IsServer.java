package juuxel.elegantfabric.world;

import net.minecraft.world.World;
import org.cactoos.Scalar;
import org.cactoos.scalar.Not;
import org.cactoos.scalar.ScalarEnvelope;

public final class IsServer extends ScalarEnvelope<Boolean> {
    public IsServer(Scalar<World> world) {
        super(new Not(new IsClient(world)));
    }

    public IsServer(World world) {
        this(() -> world);
    }
}
