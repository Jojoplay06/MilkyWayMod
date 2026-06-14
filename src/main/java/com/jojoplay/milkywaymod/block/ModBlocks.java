package com.jojoplay.milkywaymod.block;

import com.jojoplay.milkywaymod.MilkyWayMod;
import com.jojoplay.milkywaymod.item.ModItems;
import com.jojoplay.milkywaymod.item.custom.CheeseBlock;
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

    public static final DeferredBlock<Block> COW_OLD_CHEESE_BLOCK = registerBlock("cow_old_cheese_block",
            () -> new CheeseBlock(
                    BlockBehaviour.Properties.of()
                            .randomTicks(),null
            )
    );

    public static final DeferredBlock<Block> SHEEP_OLD_CHEESE_BLOCK = registerBlock("sheep_old_cheese_block",
            () -> new CheeseBlock(
                    BlockBehaviour.Properties.of()
                            .randomTicks(),null
            )
    );

    public static final DeferredBlock<Block> GOAT_OLD_CHEESE_BLOCK = registerBlock("goat_old_cheese_block",
            () -> new CheeseBlock(
                    BlockBehaviour.Properties.of()
                            .randomTicks(),null
            )
    );

    public static final DeferredBlock<Block> COW_CHEESE_BLOCK = registerBlock("cow_cheese_block",
            () -> new CheeseBlock(
                    BlockBehaviour.Properties.of()
                            .randomTicks(),COW_OLD_CHEESE_BLOCK
            )
    );

    public static final DeferredBlock<Block> GOAT_CHEESE_BLOCK = registerBlock("goat_cheese_block",
            () -> new CheeseBlock(
                    BlockBehaviour.Properties.of()
                            .randomTicks(),GOAT_OLD_CHEESE_BLOCK
            )
    );

    public static final DeferredBlock<Block> SHEEP_CHEESE_BLOCK = registerBlock("sheep_cheese_block",
            () -> new CheeseBlock(
                    BlockBehaviour.Properties.of()
                            .randomTicks(),SHEEP_OLD_CHEESE_BLOCK
            )
    );
    public static final DeferredBlock<Block> CHEESEMAKER_TABLE = registerBlock("cheesemaker_table",
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
