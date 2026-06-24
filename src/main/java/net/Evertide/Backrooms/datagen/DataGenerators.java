package net.Evertide.Backrooms.datagen;

import net.Evertide.Backrooms.BackroomsBackstage;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BackroomsBackstage.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
@SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
    DataGenerator generators = event.getGenerator();
    PackOutput packOutput = generators.getPackOutput();
    ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookprovider = event.getLookupProvider();

    generators.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
            List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookprovider));
    generators.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookprovider));

    BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookprovider, existingFileHelper);
generators.addProvider(event.includeServer(), blockTagsProvider);

generators.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookprovider, blockTagsProvider.contentsGetter(), existingFileHelper));

    generators.addProvider(event.includeServer(), new ModDataMapProvider(packOutput, lookprovider));

    generators.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
    generators.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
}
}
