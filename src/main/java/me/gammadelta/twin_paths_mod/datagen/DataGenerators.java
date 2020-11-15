package me.gammadelta.twin_paths_mod.datagen;

import me.gammadelta.twin_paths_mod.TwinPathsMod;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            BlockTagsProvider blockTags = new BlockTagsProvider(generator, TwinPathsMod.MOD_NAME, event.getExistingFileHelper());
            generator.addProvider(new ItemTags(generator, blockTags, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            generator.addProvider(new ItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new LanguageEnUS(generator, event.getExistingFileHelper()));
        }
    }
}
