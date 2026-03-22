package com.jojoplay.milkywaymod.item;

import com.jojoplay.milkywaymod.MilkyWayMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MilkyWayMod.MODID);

    public static final DeferredItem<Item> COW_CHEESE = ITEMS.register("cow_cheese",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SHEEP_CHEESE = ITEMS.register("sheep_cheese",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GOAT_CHEESE = ITEMS.register("goat_cheese",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHEEP_MILK_BUCKET = ITEMS.register("sheep_milk_bucket",
            ()-> new Item(new Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
            ));
    public static final DeferredItem<Item> GOAT_MILK_BUCKET = ITEMS.register("goat_milk_bucket",
            ()-> new Item(new Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
            ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
