package juuxel.elegantfabric.action;

import net.minecraft.util.ActionResult;
import org.cactoos.Func;
import org.cactoos.Proc;
import org.cactoos.func.UncheckedProc;

public final class SuccessfulFunc<X> implements Func<X, ActionResult> {
    private final UncheckedProc<X> proc;

    public SuccessfulFunc(Proc<X> proc) {
        this(new UncheckedProc<>(proc));
    }

    public SuccessfulFunc(UncheckedProc<X> proc) {
        this.proc = proc;
    }

    @Override
    public ActionResult apply(X input) {
        proc.exec(input);
        return ActionResult.SUCCESS;
    }
}
