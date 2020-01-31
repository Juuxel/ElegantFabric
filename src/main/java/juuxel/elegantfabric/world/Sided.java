package juuxel.elegantfabric.world;

import net.minecraft.world.World;
import org.cactoos.Func;
import org.cactoos.func.FuncOf;
import org.cactoos.scalar.Ternary;

public final class Sided<T> implements Func<World, T> {
    private final Func<World, T> server;
    private final Func<World, T> client;

    public Sided(Func<World, T> server, Func<World, T> client) {
        this.server = server;
        this.client = client;
    }

    @Override
    public T apply(World input) throws Exception {
        return new <World>Ternary<T>(
            input, new FuncOf<>(new IsClient(input)),
            client, server
        ).value();
    }
}
