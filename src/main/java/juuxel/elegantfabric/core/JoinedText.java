package juuxel.elegantfabric.core;

import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.cactoos.Proc;
import org.cactoos.Scalar;
import org.cactoos.iterable.IterableOf;
import org.cactoos.scalar.And;

/**
 * A joined Minecraft text.
 */
public final class JoinedText implements Scalar<Text> {
    private final Iterable<Text> texts;

    public JoinedText(Text... texts) {
        this(new IterableOf<>(texts));
    }

    public JoinedText(Iterable<Text> texts) {
        this.texts = texts;
    }

    @Override
    public Text value() throws Exception {
        Text result = new LiteralText("");
        new And(
                (Proc<Text>) result::append,
                texts
        ).value();
        return result;
    }
}
