package me.gammadelta.twin_paths_mod.datagen;

import me.gammadelta.twin_paths_mod.TwinPathsMod;
import me.gammadelta.twin_paths_mod.items.ItemsRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IDataProvider;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, TwinPathsMod.MOD_NAME, helper);
    }

    @Override
    protected void registerModels() {
        itemAsHandheld(ItemsRegistry.aluminumOxide);
        itemAsHandheld(ItemsRegistry.insulatingPaste);
        itemAsHandheld(ItemsRegistry.roughCrystal);
    }

    private void itemAsHandheld(RegistryObject<? extends Item> registryObject, String texturePath) {
        final ResourceLocation registryName = registryObject.getId();
        final String path = registryName.getPath();
        final ResourceLocation handheld = new ResourceLocation("item/handheld");
        final ResourceLocation textureLocation = new ResourceLocation(registryName.getNamespace(), texturePath);
        singleTexture(path, handheld, "layer0", textureLocation);
    }

    private void itemAsHandheld(RegistryObject<? extends Item> registryObject) {
        itemAsHandheld(registryObject, "item/" + registryObject.getId().getPath());
    }
}
