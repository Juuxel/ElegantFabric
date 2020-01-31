package juuxel.elegantfabric.world;

import juuxel.elegantfabric.core.ChainedProc;
import net.minecraft.world.World;
import org.cactoos.Proc;
import org.cactoos.func.RunnableOf;
import org.cactoos.scalar.Binary;

public final class ClientOnly implements Proc<World> {
    private final Proc<World> proc;

    public ClientOnly(Proc<World> proc) {
        this.proc = proc;
    }

    @SafeVarargs
    public ClientOnly(Proc<World>... procs) {
        this(new ChainedProc<>(procs));
    }

    @Override
    public void exec(World input) throws Exception {
        new Binary(
            new IsClient(input),
            new RunnableOf<>(proc, input)
        ).value();
    }
}
