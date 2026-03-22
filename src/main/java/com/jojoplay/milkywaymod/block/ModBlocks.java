package com.jojoplay.milkywaymod.block;

import com.jojoplay.milkywaymod.MilkyWayMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MilkyWayMod.MODID);

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
