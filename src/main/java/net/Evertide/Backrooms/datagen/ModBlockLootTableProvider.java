package net.Evertide.Backrooms.datagen;

import net.Evertide.Backrooms.block.Modblocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(Modblocks.AREA_0_ERRORED_CARPET.get());
        dropSelf(Modblocks.WALL_SOCKET.get());
        dropSelf(Modblocks.AREA_0_SIDED_WALLPAPER.get());
        dropSelf(Modblocks.AREA_0_ERRORED_WALLPAPER.get());
        dropSelf(Modblocks.AREA_0_CARPET.get());
        dropSelf(Modblocks.AREA_0_WALLPAPER.get());
        dropSelf(Modblocks.AREA_0_CEILING_TILE.get());
        dropSelf(Modblocks.BOMB_FROM_ANGER_BIRD.get());
        dropSelf(Modblocks.AREA_0_WALLPAPER_BLANK.get());
        dropSelf(Modblocks.DAMAGED_AREA_0_CEILING_TILE.get());
        dropSelf(Modblocks.DAMAGED_AREA_0_CEILING_TILE_2.get());
        dropSelf(Modblocks.DAMAGED_AREA_0_CEILING_TILE_3.get());
        dropSelf(Modblocks.EMPTY_AREA_0_CEILING_TILE.get());
        dropSelf(Modblocks.FLOOR_CEILING_TILE.get());
        dropSelf(Modblocks.FLOOR_CEILING_TILE_STACK.get());
        dropSelf(Modblocks.CEILING_LIGHT.get());
        dropSelf(Modblocks.RED_CEILING_LIGHT.get());
        dropSelf(Modblocks.ORANGE_CEILING_LIGHT.get());
        dropSelf(Modblocks.YELLOW_CEILING_LIGHT.get());
        dropSelf(Modblocks.GREEN_CEILING_LIGHT.get());
        dropSelf(Modblocks.TEAL_CEILING_LIGHT.get());
        dropSelf(Modblocks.BLUE_CEILING_LIGHT.get());
        dropSelf(Modblocks.PURPLE_CEILING_LIGHT.get());
        dropSelf(Modblocks.PINK_CEILING_LIGHT.get());
        dropSelf(Modblocks.WHITE_CEILING_LIGHT.get());
        dropSelf(Modblocks.LOST_LANTERN.get());
        dropSelf(Modblocks.VOID.get());
        dropSelf(Modblocks.FAKE_SKY.get());
        dropSelf(Modblocks.FAKE_CLOUD.get());
        dropSelf(Modblocks.FAKE_WHITE_SUN.get());
        dropSelf(Modblocks.FAKE_YELLOW_SUN.get());
        dropSelf(Modblocks.DECONSTRUCTED.get());
        dropSelf(Modblocks.CONSTRUCTED.get());
        dropSelf(Modblocks.RED_CARPET.get());
        dropSelf(Modblocks.RED_WALLPAPER.get());
        dropSelf(Modblocks.MANILLA_WALLPAPER.get());
        dropSelf(Modblocks.AREA_0_WALLPAPER_DOUBLE_STRIPED.get());
        dropSelf(Modblocks.AREA_0_WALLPAPER_WOBBLY.get());
        dropSelf(Modblocks.AREA_0_WALLPAPER_STRIPED.get());
        dropSelf(Modblocks.AREA_0_WALLPAPER_SPECKLE.get());
        dropSelf(Modblocks.AREA_0_SOGGY_CARPET.get());

        //add(ModBlocks.BISMUTH_ORE.get(),
        //  block -> createOreDrop(ModBlocks.BISMUTH_ORE.get(), ModItems.RAW_BISMUTH.get()));
        //add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
        // block -> createMultipleOreDrops(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(), ModItems.RAW_BISMUTH.get(), 2, 5));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Modblocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
