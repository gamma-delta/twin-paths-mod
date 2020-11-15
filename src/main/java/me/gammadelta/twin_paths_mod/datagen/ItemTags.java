package me.gammadelta.twin_paths_mod.datagen;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.Tag;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Arrays;

import static me.gammadelta.twin_paths_mod.TwinPathsMod.MOD_NAME;


public class ItemTags extends ItemTagsProvider {
    public static ITag.INamedTag<Item> HARDWOODS =
            net.minecraft.tags.ItemTags.makeWrapperTag(MOD_NAME + ":hardwoods");
    public static ITag.INamedTag<Item> SOFTWOODS =
            net.minecraft.tags.ItemTags.makeWrapperTag(MOD_NAME + ":softwoods");
    public static ITag.INamedTag<Item> FIREPROOF_WOODS =
            net.minecraft.tags.ItemTags.makeWrapperTag(MOD_NAME + ":fireproof_woods");

    public ItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper efh) {
        super(generator, blockTags, MOD_NAME, efh);
    }

    @Override
    protected void registerTags() {
        final String[] hardwoods = new String[] {
                "minecraft:oak_logs",
                "minecraft:dark_oak_logs",
                "minecraft:birch_logs",
                "minecraft:jungle_logs",
                "minecraft:acacia_logs",
                "biomesoplenty:cherry_logs",
                "biomesoplenty:mahogany_logs",
                "biomesoplenty:jacaranda_logs",
                "biomesoplenty:willow_logs",
                "biomesoplenty:palm_logs",
        };
        Builder<Item> hardwoodBuilder = this.getOrCreateBuilder(HARDWOODS);
        for (String hw : hardwoods) {
            ITag.INamedTag<Item> tag = net.minecraft.tags.ItemTags.makeWrapperTag(hw);

            hardwoodBuilder.addTag(tag);
        }
    }
}
