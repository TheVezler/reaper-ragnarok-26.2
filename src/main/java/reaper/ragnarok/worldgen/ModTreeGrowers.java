package reaper.ragnarok.worldgen;

import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower PINE = new TreeGrower(
            "pine",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.PINE_TREE),
            Optional.empty());
}
