package net.Evertide.Backrooms.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.function.Supplier;

public class ModfoligeBlock extends BushBlock {

    public static final MapCodec<ModfoligeBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            propertiesCodec()
                    ).apply(instance, (properties) -> new ModfoligeBlock(properties, () -> Blocks.AIR))
    );

    private final Supplier<Block> blockToSurviveOn;

    public ModfoligeBlock(BlockBehaviour.Properties properties, Supplier<Block> blockToSurviveOn) {
        super(properties);
        this.blockToSurviveOn = blockToSurviveOn;
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(this.blockToSurviveOn.get());
    }
}
