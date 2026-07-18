package reaper.ragnarok.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import reaper.ragnarok.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.PINE_PLANKS);

        BlockModelGenerators.WoodProvider pine =
                blockModelGenerators.woodProvider(ModBlocks.PINE_LOG);

        pine.logWithHorizontal(ModBlocks.PINE_LOG);
        pine.wood(ModBlocks.PINE_WOOD);

        BlockModelGenerators.WoodProvider strippedPine =
                blockModelGenerators.woodProvider(ModBlocks.STRIPPED_PINE_LOG);

        strippedPine.logWithHorizontal(ModBlocks.STRIPPED_PINE_LOG);
        strippedPine.wood(ModBlocks.STRIPPED_PINE_WOOD);

        blockModelGenerators.createTrivialCube(ModBlocks.REINFORCED_STONE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
