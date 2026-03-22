package com.jojoplay.milkywaymod.item;

import com.jojoplay.milkywaymod.MilkyWayMod;
import com.jojoplay.milkywaymod.item.custom.YogurtItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MilkyWayMod.MODID);

    public static final DeferredItem<Item> COW_CHEESE = ITEMS.register("cow_cheese",
            ()-> new Item(new Item.Properties().food(ModFoodPropeties.CHESSE)));
    public static final DeferredItem<Item> SHEEP_CHEESE = ITEMS.register("sheep_cheese",
            ()-> new Item(new Item.Properties().food(ModFoodPropeties.CHESSE)));
    public static final DeferredItem<Item> GOAT_CHEESE = ITEMS.register("goat_cheese",
            ()-> new Item(new Item.Properties().food(ModFoodPropeties.CHESSE)));

    public static final DeferredItem<MilkBucketItem> SHEEP_MILK_BUCKET = ITEMS.register("sheep_milk_bucket",
            ()-> new MilkBucketItem(new Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
            ));
    public static final DeferredItem<MilkBucketItem> GOAT_MILK_BUCKET = ITEMS.register("goat_milk_bucket",
            ()-> new MilkBucketItem(new Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
            ));

    public static final DeferredItem<YogurtItem> YOGURT = ITEMS.register("yogurt",
            ()-> new YogurtItem(new Item.Properties()
                    .food(ModFoodPropeties.YOGURT)
                    .stacksTo(16)
            ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
