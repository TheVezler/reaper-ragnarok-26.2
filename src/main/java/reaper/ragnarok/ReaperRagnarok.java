package reaper.ragnarok;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.mixin.datagen.client.ModelProviderItemInfoCollectorMixin;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reaper.ragnarok.block.ModBlocks;
import reaper.ragnarok.tab.ModCreativeModeTabs;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ReaperRagnarok implements ModInitializer {
	public static final String MOD_ID = "reaper-ragnarok";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModBlocks.registerModBlocks();

		FlammableBlockRegistry flamableBlocks =
				FlammableBlockRegistry.getDefaultInstance();

		flamableBlocks.add(ModBlocks.PINE_LOG, 5, 5);
		flamableBlocks.add(ModBlocks.PINE_WOOD, 5, 5);
		flamableBlocks.add(ModBlocks.STRIPPED_PINE_LOG, 5, 5);
		flamableBlocks.add(ModBlocks.STRIPPED_PINE_WOOD, 5, 5);
		flamableBlocks.add(ModBlocks.PINE_PLANKS, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_STAIRS, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_SLAB, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_FENCE, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_FENCE_GATE, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_DOOR, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_TRAPDOOR, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_PRESSURE_PLATE, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_BUTTON, 5, 20);
		flamableBlocks.add(ModBlocks.PINE_LEAVES, 30, 60);

	}
}