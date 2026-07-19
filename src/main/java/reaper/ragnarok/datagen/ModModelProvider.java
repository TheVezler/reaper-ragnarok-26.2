package reaper.ragnarok.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import reaper.ragnarok.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.family(ModBlocks.PINE_PLANKS)
                .stairs(ModBlocks.PINE_STAIRS)
                .slab(ModBlocks.PINE_SLAB)
                .fence(ModBlocks.PINE_FENCE)
                .fenceGate(ModBlocks.PINE_FENCE_GATE)
                .pressurePlate(ModBlocks.PINE_PRESSURE_PLATE)
                .button(ModBlocks.PINE_BUTTON);

        blockModelGenerators.createCrossBlockWithDefaultItem(ModBlocks.PINE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

        blockModelGenerators.createTrivialBlock(ModBlocks.PINE_LEAVES, TexturedModel.LEAVES);

        blockModelGenerators.createDoor(ModBlocks.PINE_DOOR);

        blockModelGenerators.createOrientableTrapdoor(ModBlocks.PINE_TRAPDOOR);

        BlockModelGenerators.WoodProvider pine =
                blockModelGenerators.woodProvider(ModBlocks.PINE_LOG);

        pine.logWithHorizontal(ModBlocks.PINE_LOG);
        pine.wood(ModBlocks.PINE_WOOD);

        BlockModelGenerators.WoodProvider strippedPine =
                blockModelGenerators.woodProvider(ModBlocks.STRIPPED_PINE_LOG);

        strippedPine.logWithHorizontal(ModBlocks.STRIPPED_PINE_LOG);
        strippedPine.wood(ModBlocks.STRIPPED_PINE_WOOD);

        blockModelGenerators.createAxisAlignedPillarBlock(
                ModBlocks.PETRIFIED_BONE,
                TexturedModel.COLUMN);

        blockModelGenerators.createTrivialCube(ModBlocks.REINFORCED_STONE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }

}
