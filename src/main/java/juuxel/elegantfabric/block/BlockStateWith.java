package juuxel.elegantfabric.block;

import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import org.cactoos.Scalar;

public final class BlockStateWith<T extends Comparable<T>> implements Scalar<BlockState> {
    private final Scalar<BlockState> original;
    private final Property<T> property;
    private final Scalar<T> value;

    public BlockStateWith(Scalar<BlockState> original, Property<T> property, Scalar<T> value) {
        this.original = original;
        this.property = property;
        this.value = value;
    }

    public BlockStateWith(BlockState original, Property<T> property, Scalar<T> value) {
        this(() -> original, property, value);
    }

    public BlockStateWith(Scalar<BlockState> original, Property<T> property, T value) {
        this(original, property, () -> value);
    }

    public BlockStateWith(BlockState original, Property<T> property, T value) {
        this(() -> original, property, () -> value);
    }

    @Override
    public BlockState value() throws Exception {
        return original.value().with(property, value.value());
    }
}
