package reaper.ragnarok;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import reaper.ragnarok.datagen.ModModelProvider;
import reaper.ragnarok.datagen.ModWorldgenProvider;
import reaper.ragnarok.worldgen.ModConfiguredFeatures;

public class ReaperRagnarokDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModWorldgenProvider::new);

	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(
				Registries.CONFIGURED_FEATURE,
				ModConfiguredFeatures::bootstrap);
	}
}
