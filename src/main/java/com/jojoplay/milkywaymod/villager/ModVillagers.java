package com.jojoplay.milkywaymod.villager;

import com.google.common.collect.ImmutableSet;
import com.jojoplay.milkywaymod.MilkyWayMod;
import com.jojoplay.milkywaymod.block.ModBlocks;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, MilkyWayMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, MilkyWayMod.MODID);

    public static final Holder<PoiType> CHEESE_POI = POI_TYPES.register("cheese_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CHEESEMAKER_TABLE.get().getStateDefinition().getPossibleStates()),
                    1, 1));
    public static final Holder<VillagerProfession> CHEESEMAKER = VILLAGER_PROFESSIONS.register("cheesemaker",
            ()-> new VillagerProfession("cheesemaker", holder -> holder.value() == CHEESE_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == CHEESE_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    null));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
