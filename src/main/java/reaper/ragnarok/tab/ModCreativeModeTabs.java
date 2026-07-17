package reaper.ragnarok.tab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import reaper.ragnarok.ReaperRagnarok;
import reaper.ragnarok.block.ModBlocks;

public final class ModCreativeModeTabs {

    public static final ResourceKey<CreativeModeTab> REAPER_TAB_KEY =
            ResourceKey.create(
                    BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                    ReaperRagnarok.id("reaper")
            );

    public static final CreativeModeTab REAPER_TAB =
            FabricCreativeModeTab.builder()
                    .title(Component.translatable(
                            "creativeTab.reaper-ragnarok"
                    ))
                    .icon(() -> new ItemStack(
                            Items.WITHER_SKELETON_SKULL
                    ))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.PINE_LOG);
                        output.accept(ModBlocks.PINE_WOOD);
                        output.accept(ModBlocks.STRIPPED_PINE_LOG);
                        output.accept(ModBlocks.STRIPPED_PINE_WOOD);
                        output.accept(ModBlocks.PINE_PLANKS);
                        output.accept(ModBlocks.PINE_STAIRS);
                        output.accept(ModBlocks.PINE_SLAB);
                    })
                    .build();

    public static void registerCreativeModeTabs() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                REAPER_TAB_KEY,
                REAPER_TAB
        );

        ReaperRagnarok.LOGGER.info(
                "Registering creative mode tabs for {}",
                ReaperRagnarok.MOD_ID
        );
    }

    private ModCreativeModeTabs() {
    }
}