package me.gammadelta.twin_paths_mod.items;

import me.gammadelta.twin_paths_mod.TwinPathsMod;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

import java.lang.reflect.Field;

import static me.gammadelta.twin_paths_mod.TwinPathsMod.LOGGER;
import static me.gammadelta.twin_paths_mod.TwinPathsMod.MOD_NAME;

/**
 * Contains all the new items added for the modpack.
 */
@Mod.EventBusSubscriber(modid = MOD_NAME, bus = Bus.MOD)
public final class ItemsRegistry {

    private static final class Items {
        Item aluminumOxide = item("aluminum_oxide");
        Item insulatingPaste = item("insulating_paste");
        Item roughCrystal = item("rough_crystal");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        int count = 0;
        IForgeRegistry<Item> reg = event.getRegistry();
        for (Field field : Items.class.getDeclaredFields()) {
            // reflection ftw
            try {
                reg.register((Item) field.get(Items.class));
                count += 1;
            } catch (IllegalAccessException _e) {
                // This should never happen
            }
        }
        LOGGER.info("{} items registered", count);
    }

    /**
     * Create a boring item that doesn't actually do anything
     */
    private static Item item(String name) {
        Item item = new Item(new Item.Properties());
        item.setRegistryName(MOD_NAME, name);
        return item;
    };
}
