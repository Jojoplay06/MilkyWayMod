package com.jojoplay.milkywaymod.block;

import com.jojoplay.milkywaymod.MilkyWayMod;
import com.jojoplay.milkywaymod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.checkerframework.checker.signature.qual.Identifier;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MilkyWayMod.MODID);

    public static final DeferredBlock<Block> CHEESE_BLOCK = registerBlock("cheese_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
            )
    );
    public static final DeferredBlock<Block> OLD_CHEESE_BLOCK = registerBlock("old_cheese_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
            )
    );


    private static <T extends Block> DeferredBlock<Block> registerBlock(String name, Supplier<T> block){
        DeferredBlock<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, Supplier<T> block){
        ModItems.ITEMS.registerSimpleBlockItem(name, block);

    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
