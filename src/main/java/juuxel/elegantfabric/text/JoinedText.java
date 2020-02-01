package juuxel.elegantfabric.text;

import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.cactoos.iterable.IterableOf;
import org.cactoos.scalar.Folded;

/**
 * A joined Minecraft text.
 */
public final class JoinedText extends TextEnvelope {
    public JoinedText(Text... texts) {
        this(new IterableOf<>(texts));
    }

    public JoinedText(Iterable<Text> texts) {
        super(new Folded<>(new LiteralText(""), Text::append, texts));
    }
}
