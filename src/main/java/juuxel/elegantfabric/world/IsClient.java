package juuxel.elegantfabric.world;

import net.minecraft.world.World;
import org.cactoos.Scalar;

public final class IsClient implements Scalar<Boolean> {
    private final Scalar<World> world;

    public IsClient(Scalar<World> world) {
        this.world = world;
    }

    public IsClient(World world) {
        this(() -> world);
    }

    @Override
    public Boolean value() throws Exception {
        return world.value().isClient();
    }
}
