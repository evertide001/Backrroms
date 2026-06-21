package net.Evertide.Backrooms.block;

import net.Evertide.Backrooms.BackroomsBackstage;
import net.Evertide.Backrooms.items.Moditems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Modblocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BackroomsBackstage.MODID);

    public static final DeferredBlock<Block> AREA_0_WALLPAPER = registerBlock("area_0_wallpaper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f).sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> AREA_0_CARPET = registerBlock("area_0_carpet",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f).sound(SoundType.WOOL)));

    public static final DeferredBlock<Block> AREA_0_CEILING_TILE = registerBlock("area_0_ceiling_tile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f).sound(SoundType.FUNGUS)));

    public static final DeferredBlock<Block> DAMAGED_AREA_0_CEILING_TILE = registerBlock("damaged_area_0_ceiling_tile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f).sound(SoundType.FUNGUS)));

    public static final DeferredBlock<Block> LOST_LANTERN = registerBlock("lost_lantern",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0f).sound(SoundType.LANTERN).instabreak().noCollission().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> CEILING_LIGHT = registerBlock("ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {

                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public net.minecraft.world.phys.shapes.VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return net.minecraft.world.phys.shapes.Shapes.empty();
                }
            });
    public static final DeferredBlock<Block>  WALL_SOCKET = registerBlock("wall_socket",
            () -> new Moddirectionalblocks(BlockBehaviour.Properties.of()
                    .strength(99999999f).sound(SoundType.LANTERN).noCollission()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}