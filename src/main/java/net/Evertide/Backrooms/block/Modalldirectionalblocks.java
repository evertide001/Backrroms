package net.Evertide.Backrooms.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

// 1. Changed superclass to DirectionalBlock to allow vertical orientations
public class Modalldirectionalblocks extends DirectionalBlock {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final MapCodec<Modalldirectionalblocks> CODEC = simpleCodec(Modalldirectionalblocks::new);

    private static final VoxelShape SHAPE_NORTH = Block.box(4.0D, 4.0D, 12.0D, 12.0D, 12.0D, 16.0D);
    private static final VoxelShape SHAPE_SOUTH = Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 4.0D);
    private static final VoxelShape SHAPE_EAST  = Block.box(0.0D, 4.0D, 4.0D, 4.0D, 12.0D, 12.0D);
    private static final VoxelShape SHAPE_WEST  = Block.box(14.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
    private static final VoxelShape SHAPE_UP    = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 4.0D, 12.0D);
    private static final VoxelShape SHAPE_DOWN  = Block.box(4.0D, 12.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public Modalldirectionalblocks(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case SOUTH: return SHAPE_SOUTH;
            case EAST:  return SHAPE_EAST;
            case WEST:  return SHAPE_WEST;
            case UP:    return SHAPE_UP;
            case DOWN:  return SHAPE_DOWN;
            case NORTH:
            default:    return SHAPE_NORTH;
        }
    }
    @Override
    protected MapCodec<? extends DirectionalBlock> codec() { return CODEC; }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
