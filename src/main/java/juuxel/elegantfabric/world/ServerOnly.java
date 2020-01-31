package juuxel.elegantfabric.world;

import juuxel.elegantfabric.core.ChainedProc;
import net.minecraft.world.World;
import org.cactoos.Proc;
import org.cactoos.func.RunnableOf;
import org.cactoos.scalar.Binary;

public final class ServerOnly implements Proc<World> {
    private final Proc<World> proc;

    public ServerOnly(Proc<World> proc) {
        this.proc = proc;
    }

    @SafeVarargs
    public ServerOnly(Proc<World>... procs) {
        this(new ChainedProc<>(procs));
    }

    @Override
    public void exec(World input) throws Exception {
        new Binary(
            new IsServer(input),
            new RunnableOf<>(proc, input)
        ).value();
    }
}
