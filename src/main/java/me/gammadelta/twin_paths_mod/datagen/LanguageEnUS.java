package me.gammadelta.twin_paths_mod.datagen;

import me.gammadelta.twin_paths_mod.items.ItemsRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IDataProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;

import static me.gammadelta.twin_paths_mod.TwinPathsMod.MOD_NAME;
import static me.gammadelta.twin_paths_mod.items.ItemsRegistry.CREATIVE_TAB;

public class LanguageEnUS extends LanguageProvider {
    public LanguageEnUS(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MOD_NAME, "en_US");
    }

    @Override
    protected void addTranslations() {
           add(ItemsRegistry.aluminumOxide.get(), "Aluminum Oxide");
           add(ItemsRegistry.insulatingPaste.get(), "Insulating Paste");
           add(ItemsRegistry.roughCrystal.get(), "Rough Crystal");

           add("itemGroup.twin_paths_mod", "Twin Paths Mod");
    }
}
