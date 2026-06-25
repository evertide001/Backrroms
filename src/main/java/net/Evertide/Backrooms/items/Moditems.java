package net.Evertide.Backrooms.items;

import net.Evertide.Backrooms.BackroomsBackstage;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;


import java.util.List;

public class Moditems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BackroomsBackstage.MODID);

    public static final DeferredItem<Item> PRISMATIC = ITEMS.register( "prismatic",
    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item>  FIRE_SALT = ITEMS.register( "fire_salt",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.backroomsbackstage.fire_salt.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
