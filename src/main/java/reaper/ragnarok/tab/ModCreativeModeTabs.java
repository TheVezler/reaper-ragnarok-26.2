package reaper.ragnarok.tab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import reaper.ragnarok.ReaperRagnarok;
import reaper.ragnarok.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final CreativeModeTab REAPER_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ReaperRagnarok.MOD_ID, "reaper"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PINE_PLANKS))
                    .title(Component.translatable("creativemodetab.reaper-ragnarok.pine_planks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.PINE_PLANKS);
                        output.accept(ModBlocks.PINE_WOOD);
                        output.accept(ModBlocks.PINE_LOG);
                        output.accept(ModBlocks.STRIPPED_PINE_WOOD);
                        output.accept(ModBlocks.STRIPPED_PINE_LOG);
                        output.accept(ModBlocks.REINFORCED_STONE);


                    }).build());


    public static void registerModCreativeModeTabs() {
        ReaperRagnarok.LOGGER.info("Registering Creative Mode Tabs for " + ReaperRagnarok.MOD_ID);
    }


}
