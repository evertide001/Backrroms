package net.Evertide.Backrooms.items;

import net.Evertide.Backrooms.BackroomsBackstage;
import net.Evertide.Backrooms.block.Modblocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BackroomsBackstage.MODID);

    public static final Supplier<CreativeModeTab> BACKROOMS_BACKSTAGE_TAB =CREATIVE_MODE_TAB.register( "backrooms_backstage_items_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack((Modblocks.AREA_0_WALLPAPER)))
                    .title(Component.translatable("creativetab.backroomsbackstage.backrooms_backstage_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.PRISMATIC);
                        output.accept(Modblocks.AREA_0_WALLPAPER);
                        output.accept(Modblocks.AREA_0_CARPET);
                        output.accept(Modblocks.AREA_0_CEILING_TILE);
                        output.accept(Modblocks.DAMAGED_AREA_0_CEILING_TILE);
                        output.accept(Modblocks.WALL_SOCKET);
                        output.accept(Modblocks.CEILING_LIGHT);
                        output.accept(Modblocks.LOST_LANTERN);
                    })
                    .build());

            public static void register(IEventBus eventBus) {
                CREATIVE_MODE_TAB.register(eventBus);
            }
}
