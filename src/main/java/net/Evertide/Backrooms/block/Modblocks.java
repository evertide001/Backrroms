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
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.function.Supplier;

public class Modblocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BackroomsBackstage.MODID);

    // MinX, MinY, MinZ, MaxX, MaxY, MaxZ)
    private static final VoxelShape TILE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
    private static final VoxelShape STACK_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
    private static final VoxelShape LANTERN_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D);
    private static final VoxelShape BOX_REPLACE = Block.box(0.00, 0.00, 0.00, 16.00, 16.00, 16.00);

    public static final DeferredBlock<Block> AREA_0_WALLPAPER = registerBlock("area_0_wallpaper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> AREA_0_ERRORED_WALLPAPER = registerBlock("area_0_errored_wallpaper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noCollission()
                    .noOcclusion()
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> AREA_0_SIDED_WALLPAPER = registerBlock("area_0_sided_wallpaper",
            () -> new DirectionalPassageBlock(
                    BlockBehaviour.Properties.of()
                            .strength(999999999f)
                            .sound(SoundType.BAMBOO_WOOD),
                    (level, pos) -> true
            )
            {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable( "tooltip.backroomsbackstage.one_sided.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }

                    @Override
                    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
                    return BOX_REPLACE;
                }
            }


    );
    public static final DeferredBlock<Block> AREA_0_WALLPAPER_BLANK = registerBlock("area_0_wallpaper_blank",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> BUDDING_FIRE_SALT = registerBlock("budding_fire_salt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 5)
                    .sound(SoundType.AMETHYST_CLUSTER)));

    public static final DeferredBlock<Block> BLOCK_OF_FIRE_SALT = registerBlock("block_of_fire_salt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 5)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> FIRE_SALT_BUD = registerBlock("fire_salt_bud",
            () -> new Modalldirectionalblocks(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .lightLevel(state -> 5)
                    .noOcclusion()
                    .noCollission()
                    .sound(SoundType.LARGE_AMETHYST_BUD)){

            });

    public static final DeferredBlock<Block> CARPET_GRASS = registerBlock("carpet_grass",
            () -> new ModfoligeBlock(
                    BlockBehaviour.Properties.of()
                            .strength(0f)
                            .instabreak()
                            .noOcclusion()
                            .noCollission()
                            .sound(SoundType.WOOL),
                    Modblocks.AREA_0_CARPET
            )
    );

    public static final DeferredBlock<Block> BURNSTONE = registerBlock("burnstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BASALT)));

    public static final DeferredBlock<Block> CONCRETE = registerBlock("concrete",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.DEEPSLATE_BRICKS)));


    public static final DeferredBlock<Block> RED_WALLPAPER = registerBlock("red_wallpaper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> MANILLA_WALLPAPER = registerBlock("manilla_wallpaper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> AREA_0_WALLPAPER_STRIPED = registerBlock("area_0_wallpaper_striped",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> AREA_0_WALLPAPER_DOUBLE_STRIPED = registerBlock("area_0_wallpaper_double_striped",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> AREA_0_WALLPAPER_SPECKLE = registerBlock("area_0_wallpaper_speckle",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> AREA_0_WALLPAPER_WOBBLY = registerBlock("area_0_wallpaper_wobbly",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.BAMBOO_WOOD)));

    public static final DeferredBlock<Block> DECONSTRUCTED = registerBlock("deconstructed",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 7)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> CONSTRUCTED = registerBlock("constructed",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 7)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> VOID = registerBlock("void",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 2)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> FAKE_CLOUD = registerBlock("fake_cloud",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> FAKE_SKY = registerBlock("fake_sky",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> FAKE_WHITE_SUN = registerBlock("fake_white_sun",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> FAKE_YELLOW_SUN = registerBlock("fake_yellow_sun",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .lightLevel(state -> 15)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> AREA_0_CARPET = registerBlock("area_0_carpet",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.WOOL)));

    public static final DeferredBlock<Block> RED_CARPET = registerBlock("red_carpet",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.WOOL)));

    public static final DeferredBlock<Block> AREA_0_SOGGY_CARPET = registerBlock("area_0_soggy_carpet",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .sound(SoundType.WET_SPONGE)));

    public static final DeferredBlock<Block> AREA_0_ERRORED_CARPET = registerBlock("area_0_errored_carpet",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noCollission()
                    .noOcclusion()
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
                    .noOcclusion()
                    .sound(SoundType.FUNGUS)) {
                @Override
                public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
                    return TILE_SHAPE;
                }

            });

    public static final DeferredBlock<Block> FLOOR_CEILING_TILE_STACK = registerBlock("floor_ceiling_tile_stack",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .sound(SoundType.FUNGUS)) {
                @Override
                public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
                    return STACK_SHAPE;
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
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS))
            );

    public static final DeferredBlock<Block> WHITE_CEILING_LIGHT = registerBlock("white_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> RED_CEILING_LIGHT = registerBlock("red_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

       public static final DeferredBlock<Block> ORANGE_CEILING_LIGHT = registerBlock("orange_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> YELLOW_CEILING_LIGHT = registerBlock("yellow_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> GREEN_CEILING_LIGHT = registerBlock("green_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> TEAL_CEILING_LIGHT = registerBlock("teal_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> BLUE_CEILING_LIGHT = registerBlock("blue_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> PURPLE_CEILING_LIGHT = registerBlock("purple_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> PINK_CEILING_LIGHT = registerBlock("pink_ceiling_light",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(99999999f)
                    .noOcclusion()
                    .lightLevel(state -> 15)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> WALL_SOCKET = registerBlock("wall_socket",
            () -> new Modalldirectionalblocks(BlockBehaviour.Properties.of()
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
