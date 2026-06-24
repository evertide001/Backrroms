package net.Evertide.Backrooms.datagen;

import net.Evertide.Backrooms.BackroomsBackstage;
import net.Evertide.Backrooms.items.Moditems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BackroomsBackstage.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(Moditems.PRISMATIC.get());
    }
}
