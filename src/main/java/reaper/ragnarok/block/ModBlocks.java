package reaper.ragnarok.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import reaper.ragnarok.ReaperRagnarok;

import java.util.function.Function;

public final class ModBlocks {

    public static final Block PINE_PLANKS = register(
            "pine_planks",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(2.0F, 3.0F)
                    .ignitedByLava(),
            true
    );

    public static final Block PINE_LOG = register(
            "pine_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    public static final Block PINE_WOOD = register(
            "pine_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    public static final Block STRIPPED_PINE_LOG = register(
            "stripped_pine_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    public static final Block STRIPPED_PINE_WOOD = register(
            "stripped_pine_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    public static final Block PINE_STAIRS = register(
            "pine_stairs",
            properties -> new StairBlock(
                    PINE_PLANKS.defaultBlockState(),
                    properties
            ),
            BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS),
            true
    );

    public static final Block PINE_SLAB = register(
            "pine_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS),
            true
    );

    private static Block register(
            String name,
            Function<BlockBehaviour.Properties, Block> blockFactory,
            BlockBehaviour.Properties properties,
            boolean registerItem
    ) {
        ResourceKey<Block> blockKey = ResourceKey.create(
                Registries.BLOCK,
                ReaperRagnarok.id(name)
        );

        Block block = blockFactory.apply(
                properties.setId(blockKey)
        );

        Block registeredBlock = Registry.register(
                BuiltInRegistries.BLOCK,
                blockKey,
                block
        );

        if (registerItem) {
            registerBlockItem(name, registeredBlock);
        }

        return registeredBlock;
    }

    private static void registerBlockItem(
            String name,
            Block block
    ) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                ReaperRagnarok.id(name)
        );

        BlockItem blockItem = new BlockItem(
                block,
                new Item.Properties()
                        .setId(itemKey)
                        .useBlockDescriptionPrefix()
        );

        Registry.register(
                BuiltInRegistries.ITEM,
                itemKey,
                blockItem
        );
    }

    public static void initialize() {
        ReaperRagnarok.LOGGER.info(
                "Registering blocks for {}",
                ReaperRagnarok.MOD_ID
        );
    }

    private ModBlocks() {
    }
}