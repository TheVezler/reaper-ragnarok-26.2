package reaper.ragnarok.worldgen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import reaper.ragnarok.ReaperRagnarok;
import reaper.ragnarok.block.ModBlocks;
import net.minecraft.util.valueproviders.UniformInt;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            Identifier.fromNamespaceAndPath(ReaperRagnarok.MOD_ID, "pine_tree"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        TreeConfiguration pineTree = new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PINE_LOG),
                new StraightTrunkPlacer(5, 6, 7),
                BlockStateProvider.simple(ModBlocks.PINE_LEAVES),
                new SpruceFoliagePlacer(
                        UniformInt.of(2, 3),
                        UniformInt.of(0, 1),
                        UniformInt.of(3, 6)),
                new TwoLayersFeatureSize(1, 0, 1),
                BlockStateProvider.simple(Blocks.DIRT)
        ).ignoreVines().build();

        context.register(PINE_TREE, new ConfiguredFeature<>(Feature.TREE, pineTree));
    }
}
