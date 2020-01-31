package juuxel.elegantfabric.impl;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cactoos.Proc;
import org.cactoos.iterable.IterableOf;
import org.cactoos.scalar.And;
import org.cactoos.scalar.Unchecked;

public final class ElegantFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        if (!FabricLoader.getInstance().isDevelopmentEnvironment()) {
            Logger logger = LogManager.getLogger();
            new Unchecked<>(
                new And(
                    (Proc<String>) logger::warn,
                    new IterableOf<>(
                        "+---------------------------------------------------------+",
                        "| You should not be running Elegant Fabric in production! |",
                        "+---------------------------------------------------------+"
                    )
                )
            ).value();
        }
    }
}
