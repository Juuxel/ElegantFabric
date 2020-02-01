package juuxel.elegantfabric.text;

import com.google.gson.JsonElement;
import net.minecraft.text.Text;

public final class TextOf extends TextEnvelope {
    public TextOf(JsonElement json) {
        super(Text.Serializer.fromJson(json));
    }
}
