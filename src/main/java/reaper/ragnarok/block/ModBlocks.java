package reaper.ragnarok.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import reaper.ragnarok.ReaperRagnarok;

import java.util.function.Function;

public class ModBlocks {

    public static final Block PINE_PLANKS = registerBlock("pine_planks",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_WOOD = registerBlock("pine_wood",
            properties -> new RotatedPillarBlock(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_LOG = registerBlock("pine_log",
            properties -> new RotatedPillarBlock(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            properties -> new RotatedPillarBlock(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            properties -> new RotatedPillarBlock(properties.strength(3f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block REINFORCED_STONE = registerBlock("reinforced_stone",
            properties -> new Block(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ReaperRagnarok.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(ReaperRagnarok.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ReaperRagnarok.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ReaperRagnarok.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        ReaperRagnarok.LOGGER.info("Registering Mod Blocks for" + ReaperRagnarok.MOD_ID);
    }
}

