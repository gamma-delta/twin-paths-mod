package me.gammadelta.twin_paths_mod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.lang.reflect.Field;

import static me.gammadelta.twin_paths_mod.TwinPathsMod.LOGGER;
import static me.gammadelta.twin_paths_mod.TwinPathsMod.MOD_NAME;

/**
 * Contains all the new items added for the modpack.
 */
public final class ItemsRegistry {
    public static final ItemGroup CREATIVE_TAB = new ItemGroup(MOD_NAME) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(aluminumOxide.get());
        }
    };

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_NAME);

    public static final RegistryObject<Item> aluminumOxide = item("aluminum_oxide");
    public static final RegistryObject<Item> insulatingPaste = item("insulating_paste");
    public static final RegistryObject<Item> roughCrystal = item("rough_crystal");

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    /**
     * Create a boring item that doesn't actually do anything
     */
    private static RegistryObject<Item> item(String name) {
        return ITEMS.register(name, () -> {
            Item item = new Item(new Item.Properties().group(CREATIVE_TAB));
            return item;
        });
    }
}
