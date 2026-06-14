package com.jojoplay.milkywaymod.item.custom;

import com.jojoplay.milkywaymod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class CheeseBlock extends Block {

    private final Supplier<Block> nextStage;

    public CheeseBlock(Properties properties, Supplier<Block> nextStage) {
        super(properties);
        this.nextStage = nextStage;
    }

    @Override
    protected void randomTick(BlockState state,
                              ServerLevel level,
                              BlockPos pos,
                              RandomSource random){

        if (nextStage == null) {
            return;
        }

        boolean exposed = level.getBlockState(pos.above()).isAir();

        if (!exposed) {
            return;
        }

        if (random.nextInt(20) == 0) {
            level.setBlock(
                    pos,
                    nextStage.get().defaultBlockState(),
                    3
            );
        }
    }
}
