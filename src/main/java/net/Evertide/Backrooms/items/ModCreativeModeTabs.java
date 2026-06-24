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
                        output.accept(Modblocks.AREA_0_ERRORED_WALLPAPER);
                        output.accept(Modblocks.AREA_0_SIDED_WALLPAPER);
                        output.accept(Modblocks.AREA_0_WALLPAPER_BLANK);
                        output.accept(Modblocks.AREA_0_CARPET);
                        output.accept(Modblocks.AREA_0_ERRORED_CARPET);
                        output.accept(Modblocks.AREA_0_CEILING_TILE);
                        output.accept(Modblocks.DAMAGED_AREA_0_CEILING_TILE);
                        output.accept(Modblocks.DAMAGED_AREA_0_CEILING_TILE_2);
                        output.accept(Modblocks.DAMAGED_AREA_0_CEILING_TILE_3);
                        output.accept(Modblocks.EMPTY_AREA_0_CEILING_TILE);
                        output.accept(Modblocks.FLOOR_CEILING_TILE);
                        output.accept(Modblocks.FLOOR_CEILING_TILE_STACK);
                        output.accept(Modblocks.WALL_SOCKET);
                        output.accept(Modblocks.CEILING_LIGHT);
                        output.accept(Modblocks.RED_CEILING_LIGHT);
                        output.accept(Modblocks.ORANGE_CEILING_LIGHT);
                        output.accept(Modblocks.YELLOW_CEILING_LIGHT);
                        output.accept(Modblocks.GREEN_CEILING_LIGHT);
                        output.accept(Modblocks.TEAL_CEILING_LIGHT);
                        output.accept(Modblocks.BLUE_CEILING_LIGHT);
                        output.accept(Modblocks.PURPLE_CEILING_LIGHT);
                        output.accept(Modblocks.PINK_CEILING_LIGHT);
                        output.accept(Modblocks.WHITE_CEILING_LIGHT);
                        output.accept(Modblocks.LOST_LANTERN);
                        output.accept(Modblocks.BOMB_FROM_ANGER_BIRD);
                        output.accept(Modblocks.AREA_0_SOGGY_CARPET);
                        output.accept(Modblocks.AREA_0_WALLPAPER_DOUBLE_STRIPED);
                        output.accept(Modblocks.AREA_0_WALLPAPER_SPECKLE);
                        output.accept(Modblocks.AREA_0_WALLPAPER_STRIPED);
                        output.accept(Modblocks.AREA_0_WALLPAPER_WOBBLY);
                        output.accept(Modblocks.CONSTRUCTED);
                        output.accept(Modblocks.DECONSTRUCTED);
                        output.accept(Modblocks.FAKE_CLOUD);
                        output.accept(Modblocks.FAKE_SKY);
                        output.accept(Modblocks.VOID);
                        output.accept(Modblocks.FAKE_WHITE_SUN);
                        output.accept(Modblocks.FAKE_YELLOW_SUN);
                        output.accept(Modblocks.RED_CARPET);
                        output.accept(Modblocks.RED_WALLPAPER);
                        output.accept(Modblocks.MANILLA_WALLPAPER);
                    })
                    .build());

            public static void register(IEventBus eventBus) {
                CREATIVE_MODE_TAB.register(eventBus);
            }
}
