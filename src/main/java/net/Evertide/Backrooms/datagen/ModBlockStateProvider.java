package net.Evertide.Backrooms.datagen;

import net.Evertide.Backrooms.BackroomsBackstage;
import net.Evertide.Backrooms.block.Modblocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BackroomsBackstage.MODID, exFileHelper);
    }



        @Override
    protected void registerStatesAndModels() {
        blockWithItem(Modblocks.AREA_0_ERRORED_CARPET);
        blockWithItem(Modblocks.AREA_0_ERRORED_WALLPAPER);
        blockWithItem(Modblocks.AREA_0_SIDED_WALLPAPER);
        blockWithItem(Modblocks.AREA_0_CARPET);
        blockWithItem(Modblocks.AREA_0_WALLPAPER);
        blockWithItem(Modblocks.AREA_0_WALLPAPER_BLANK);
            blockWithItem(Modblocks.AREA_0_WALLPAPER_DOUBLE_STRIPED);
            blockWithItem(Modblocks.AREA_0_WALLPAPER_SPECKLE);
            blockWithItem(Modblocks.AREA_0_WALLPAPER_STRIPED);
            blockWithItem(Modblocks.AREA_0_WALLPAPER_WOBBLY);
            blockWithItem(Modblocks.RED_CARPET);
            blockWithItem(Modblocks.RED_WALLPAPER);
            blockWithItem(Modblocks.MANILLA_WALLPAPER);
            blockWithItem(Modblocks.FAKE_SKY);
            blockWithItem(Modblocks.AREA_0_SOGGY_CARPET);
            blockWithItem(Modblocks.FAKE_CLOUD);
            blockWithItem(Modblocks.FAKE_WHITE_SUN);
            blockWithItem(Modblocks.FAKE_YELLOW_SUN);
            blockWithItem(Modblocks.VOID);
            blockWithItem(Modblocks.DECONSTRUCTED);
            blockWithItem(Modblocks.CONSTRUCTED);

        customBlockWithItem(Modblocks.CEILING_LIGHT);
        customBlockWithItem(Modblocks.BOMB_FROM_ANGER_BIRD);
        customBlockWithItem(Modblocks.WHITE_CEILING_LIGHT);
        customBlockWithItem(Modblocks.RED_CEILING_LIGHT);
        customBlockWithItem(Modblocks.ORANGE_CEILING_LIGHT);
        customBlockWithItem(Modblocks.YELLOW_CEILING_LIGHT);
        customBlockWithItem(Modblocks.GREEN_CEILING_LIGHT);
        customBlockWithItem(Modblocks.TEAL_CEILING_LIGHT);
        customBlockWithItem(Modblocks.BLUE_CEILING_LIGHT);
        customBlockWithItem(Modblocks.PURPLE_CEILING_LIGHT);
        customBlockWithItem(Modblocks.PINK_CEILING_LIGHT);
        customBlockWithItem(Modblocks.LOST_LANTERN);
        customBlockWithItem(Modblocks.FLOOR_CEILING_TILE);
        customBlockWithItem(Modblocks.FLOOR_CEILING_TILE_STACK);
        customBlockWithItem(Modblocks.AREA_0_CEILING_TILE);
        customBlockWithItem(Modblocks.DAMAGED_AREA_0_CEILING_TILE);
        customBlockWithItem(Modblocks.DAMAGED_AREA_0_CEILING_TILE_2);
        customBlockWithItem(Modblocks.DAMAGED_AREA_0_CEILING_TILE_3);
        customBlockWithItem(Modblocks.EMPTY_AREA_0_CEILING_TILE);
        directionalBlockWithItem(Modblocks.WALL_SOCKET);

    }
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void customBlockWithItem(DeferredBlock<?> deferredBlock) {
        String blockName = deferredBlock.getId().getPath();
        simpleBlockWithItem(deferredBlock.get(), models().getExistingFile(modLoc("blocks/"+blockName)) );
    }
    private void directionalBlockWithItem(DeferredBlock<?> deferredBlock) {
        String blockName = deferredBlock.getId().getPath();
        getVariantBuilder(deferredBlock.get()).forAllStates(state -> {
            Direction facing = state.getValue(net.minecraft.world.level.block.HorizontalDirectionalBlock.FACING);

            // defaults
            int rotationX = 0;
            int rotationY = 0;

            if (facing == Direction.EAST)  rotationY = 90;
            if (facing == Direction.SOUTH) rotationY = 180;
            if (facing == Direction.WEST)  rotationY = 270;
            if (facing == Direction.UP)    rotationX = 90;
            if (facing == Direction.DOWN)  rotationX = -90;

            return ConfiguredModel.builder()
                    .modelFile(models().getExistingFile(modLoc("blocks/" + blockName)))
                    .rotationX(rotationX)
                    .rotationY(rotationY)
                    .build();
        });
        simpleBlockItem(deferredBlock.get(), models().getExistingFile(modLoc("blocks/" + blockName)));
    }

}
