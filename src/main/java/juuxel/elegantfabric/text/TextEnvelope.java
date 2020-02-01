package juuxel.elegantfabric.text;

import net.minecraft.text.Style;
import net.minecraft.text.Text;
import org.cactoos.Scalar;
import org.cactoos.scalar.Unchecked;

import java.util.List;
import java.util.stream.Stream;

public abstract class TextEnvelope implements Text {
    private final Text text;

    public TextEnvelope(Text text) {
        this.text = text;
    }

    public TextEnvelope(Scalar<Text> text) {
        this(new Unchecked<>(text).value());
    }

    @Override
    public final Style getStyle() {
        return text.getStyle();
    }

    @Override
    public final Text setStyle(Style style) {
        return text.setStyle(style);
    }

    @Override
    public final Text append(Text text) {
        return text.append(text);
    }

    @Override
    public final String asString() {
        return text.asString();
    }

    @Override
    public final List<Text> getSiblings() {
        return text.getSiblings();
    }

    @Override
    public final Stream<Text> stream() {
        return text.stream();
    }

    @Override
    public final Text copy() {
        return text.copy();
    }
}
