package snownee.jade.addon.universal;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.Identifiers;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class UniversalPlugin implements IWailaPlugin {

	@Override
	public void register(IWailaCommonRegistration registration) {
		registration.registerBlockDataProvider(ItemStorageProvider.getBlock(), Block.class);
		registration.registerEntityDataProvider(ItemStorageProvider.getEntity(), Entity.class);
		registration.registerItemStorage(ItemStorageProvider.Extension.INSTANCE, Object.class);
		registration.registerItemStorage(ItemStorageProvider.Extension.INSTANCE, Block.class);

		registration.registerBlockDataProvider(FluidStorageProvider.getBlock(), Block.class);
		registration.registerEntityDataProvider(FluidStorageProvider.getEntity(), Entity.class);
		registration.registerFluidStorage(FluidStorageProvider.Extension.INSTANCE, Object.class);

		registration.registerBlockDataProvider(EnergyStorageProvider.getBlock(), Block.class);
		registration.registerEntityDataProvider(EnergyStorageProvider.getEntity(), Entity.class);
		registration.registerEnergyStorage(EnergyStorageProvider.Extension.INSTANCE, Object.class);

		registration.registerBlockDataProvider(ProgressProvider.getBlock(), Block.class);
		registration.registerEntityDataProvider(ProgressProvider.getEntity(), Entity.class);
	}

	@Override
	public void registerClient(IWailaClientRegistration registration) {
		registration.addConfig(Identifiers.UNIVERSAL_ITEM_STORAGE_DETAILED_AMOUNT, 54, 0, 54, false);
		registration.addConfig(Identifiers.UNIVERSAL_ITEM_STORAGE_NORMAL_AMOUNT, 9, 0, 54, false);
		registration.addConfig(Identifiers.UNIVERSAL_ITEM_STORAGE_SHOW_NAME_AMOUNT, 5, 0, 9, true);
		registration.addConfig(Identifiers.UNIVERSAL_ITEM_STORAGE_ITEMS_PER_LINE, 9, 3, 27, true);
		registration.addConfig(Identifiers.UNIVERSAL_ENERGY_STORAGE_DETAILED, false);
		registration.addConfig(Identifiers.UNIVERSAL_FLUID_STORAGE_DETAILED, false);

		registration.registerBlockComponent(ItemStorageProvider.getBlock(), Block.class);
		registration.registerEntityComponent(ItemStorageProvider.getEntity(), Entity.class);
		registration.registerItemStorageClient(ItemStorageProvider.Extension.INSTANCE);

		registration.registerBlockComponent(FluidStorageProvider.getBlock(), Block.class);
		registration.registerEntityComponent(FluidStorageProvider.getEntity(), Entity.class);
		registration.registerFluidStorageClient(FluidStorageProvider.Extension.INSTANCE);

		registration.registerBlockComponent(EnergyStorageProvider.getBlock(), Block.class);
		registration.registerEntityComponent(EnergyStorageProvider.getEntity(), Entity.class);
		registration.registerEnergyStorageClient(EnergyStorageProvider.Extension.INSTANCE);

		registration.registerBlockComponent(ProgressProvider.getBlock(), Block.class);
		registration.registerEntityComponent(ProgressProvider.getEntity(), Entity.class);

		Component category = Component.translatable("config.jade.plugin_jade");
		registration.setConfigCategoryOverride(Identifiers.UNIVERSAL_ITEM_STORAGE, category);
		registration.setConfigCategoryOverride(Identifiers.UNIVERSAL_FLUID_STORAGE, category);
		registration.setConfigCategoryOverride(Identifiers.UNIVERSAL_ENERGY_STORAGE, category);
	}

}
