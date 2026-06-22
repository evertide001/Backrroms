package net.Evertide.Backrooms.block;

import net.Evertide.Backrooms.BackroomsBackstage;
import net.Evertide.Backrooms.items.Moditems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Modblocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BackroomsBackstage.MODID);

    // --- Custom Shapes (Defined in pixels: MinX, MinY, MinZ, MaxX, MaxY, MaxZ) ---
    // A thin tile flat on the floor (1 pixel tall)
    private static final VoxelShape TILE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
    // A stack of tiles (4 pixels tall)
    private static final VoxelShape STACK_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
    // A small lantern shape sitting in the middle of the block
    private static final VoxelShape LANTERN_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D);

    public static final DeferredBlock<Block> AREA_0_WALLPAPER = registerBlock("area_0_wallpaper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> AREA_0_CARPET = registerBlock("area_0_carpet",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.WOOL)));

    public static final DeferredBlock<Block> AREA_0_CEILING_TILE = registerBlock("area_0_ceiling_tile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.FUNGUS)));

    public static final DeferredBlock<Block> DAMAGED_AREA_0_CEILING_TILE = registerBlock("damaged_area_0_ceiling_tile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.FUNGUS)));

    public static final DeferredBlock<Block> DAMAGED_AREA_0_CEILING_TILE_2 = registerBlock("damaged_area_0_ceiling_tile_2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.FUNGUS)));

    public static final DeferredBlock<Block> DAMAGED_AREA_0_CEILING_TILE_3 = registerBlock("damaged_area_0_ceiling_tile_3",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.FUNGUS)));

    public static final DeferredBlock<Block> EMPTY_AREA_0_CEILING_TILE = registerBlock("empty_area_0_ceiling_tile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.FUNGUS)));


    public static final DeferredBlock<Block> FLOOR_CEILING_TILE = registerBlock("floor_ceiling_tile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.FUNGUS)) {
                @Override
                public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
                    return TILE_SHAPE;
                }
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }

            });

    public static final DeferredBlock<Block> FLOOR_CEILING_TILE_STACK = registerBlock("floor_ceiling_tile_stack",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.FUNGUS)) {
                @Override
                public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
                    return STACK_SHAPE;
                }
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });


    public static final DeferredBlock<Block> LOST_LANTERN = registerBlock("lost_lantern",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0f)
                    .sound(SoundType.LANTERN)
                    .instabreak()
                    .lightLevel(state -> 15)) {
                @Override
                public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
                    return LANTERN_SHAPE;
                }
            });

    public static final DeferredBlock<Block> BOMB_FROM_ANGER_BIRD = registerBlock("bomb_from_anger_bird",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(20f)
                    .sound(SoundType.VAULT)
                    .speedFactor(0.01f)
                    .lightLevel(state -> 5)) {
                @Override
                public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
                    return LANTERN_SHAPE;
                }
            });

    public static final DeferredBlock<Block> CEILING_LIGHT = registerBlock("ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });
    public static final DeferredBlock<Block> RED_CEILING_LIGHT = registerBlock("red_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });
       public static final DeferredBlock<Block> ORANGE_CEILING_LIGHT = registerBlock("orange_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });
    public static final DeferredBlock<Block> YELLOW_CEILING_LIGHT = registerBlock("yellow_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });
    public static final DeferredBlock<Block> GREEN_CEILING_LIGHT = registerBlock("green_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });
    public static final DeferredBlock<Block> TEAL_CEILING_LIGHT = registerBlock("teal_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });
    public static final DeferredBlock<Block> BLUE_CEILING_LIGHT = registerBlock("blue_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });
    public static final DeferredBlock<Block> PURPLE_CEILING_LIGHT = registerBlock("purple_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });
    public static final DeferredBlock<Block> PINK_CEILING_LIGHT = registerBlock("pink_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)) {
                public boolean isOcclusion(BlockState state) {
                    return false;
                }

                @Override
                public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
                    return Shapes.empty();
                }
            });

    public static final DeferredBlock<Block> WALL_SOCKET = registerBlock("wall_socket",
            () -> new Moddirectionalblocks(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.LANTERN)
                    .dynamicShape()
            ));

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
