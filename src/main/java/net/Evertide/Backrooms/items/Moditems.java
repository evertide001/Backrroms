package net.Evertide.Backrooms.items;

import net.Evertide.Backrooms.BackroomsBackstage;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Moditems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BackroomsBackstage.MODID);

    public static final DeferredItem<Item> PRISMATIC = ITEMS.register( "prismatic",
    () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
