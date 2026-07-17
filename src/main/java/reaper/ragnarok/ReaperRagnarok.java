package reaper.ragnarok;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reaper.ragnarok.block.ModBlocks;
import reaper.ragnarok.tab.ModCreativeModeTabs;

public class ReaperRagnarok implements ModInitializer {

	public static final String MOD_ID = "reaper-ragnarok";

	public static final Logger LOGGER =
			LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModCreativeModeTabs.registerCreativeModeTabs();

		LOGGER.info("Reaper: Ragnarok initialized!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}