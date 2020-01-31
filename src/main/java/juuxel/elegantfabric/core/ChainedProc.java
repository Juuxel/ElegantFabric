package juuxel.elegantfabric.core;

import org.cactoos.Proc;
import org.cactoos.iterable.IterableOf;
import org.cactoos.scalar.And;

/**
 * A chained procedure.
 *
 * @param <X> The input type
 */
public final class ChainedProc<X> implements Proc<X> {
    private final Iterable<Proc<X>> procs;

    public ChainedProc(Iterable<Proc<X>> procs) {
        this.procs = procs;
    }

    @SafeVarargs
    public ChainedProc(Proc<X>... procs) {
        this(new IterableOf<>(procs));
    }

    @Override
    public void exec(X input) throws Exception {
        new And((Proc<Proc<X>>) proc -> proc.exec(input), procs).value();
    }
}
