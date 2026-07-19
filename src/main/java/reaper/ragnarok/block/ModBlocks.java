package reaper.ragnarok.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import reaper.ragnarok.worldgen.ModTreeGrowers;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import reaper.ragnarok.ReaperRagnarok;

import java.util.function.Function;

public class ModBlocks {

    public static final Block PINE_PLANKS = registerBlock("pine_planks",
            properties -> new Block(properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_WOOD = registerBlock("pine_wood",
            properties -> new RotatedPillarBlock(properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_LOG = registerBlock("pine_log",
            properties -> new RotatedPillarBlock(properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            properties -> new RotatedPillarBlock(properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            properties -> new RotatedPillarBlock(properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_STAIRS = registerBlock("pine_stairs",
            properties -> new StairBlock(PINE_PLANKS.defaultBlockState(), properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_SLAB = registerBlock("pine_slab",
            properties -> new SlabBlock(properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_FENCE = registerBlock("pine_fence",
            properties -> new FenceBlock(properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_FENCE_GATE = registerBlock("pine_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK, properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_DOOR = registerBlock("pine_door",
            properties -> new DoorBlock(BlockSetType.OAK, properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));

    public static final Block PINE_TRAPDOOR = registerBlock("pine_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK, properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));

    public static final Block PINE_PRESSURE_PLATE = registerBlock("pine_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK, properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final Block PINE_BUTTON = registerBlock("pine_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 30, properties.strength(1.5f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD).noCollision()));

    public static final Block PINE_LEAVES = registerBlock("pine_leaves",
            properties -> new TintedParticleLeavesBlock(0.00f, properties.strength(0.2f)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion()));

    public static final Block PINE_SAPLING = registerBlock("pine_sapling",
            properties -> new SaplingBlock(ModTreeGrowers.PINE, properties.noCollision().randomTicks().instabreak().sound(SoundType.GRASS)));


    public static final Block PETRIFIED_BONE = registerBlock("petrified_bone",
            properties -> new RotatedPillarBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));

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

