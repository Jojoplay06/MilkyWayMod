package com.jojoplay.milkywaymod.event;

import com.jojoplay.milkywaymod.item.ModItems;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event){

        Player player = event.getEntity();
        ItemStack stack = player.getItemInHand(event.getHand());

        //Oveja
        if (event.getTarget() instanceof Sheep && stack.getItem() == Items.BUCKET){

            if (!player.level().isClientSide){
                player.setItemInHand(
                        event.getHand(),
                        new ItemStack(ModItems.SHEEP_MILK_BUCKET.get())
                );
            }

            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }

        //Cabra
        if (event.getTarget() instanceof Goat && stack.getItem() == Items.BUCKET){

            if (!player.level().isClientSide){
                player.setItemInHand(
                        event.getHand(),
                        new ItemStack(ModItems.GOAT_MILK_BUCKET.get())
                );
            }

            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }
    }
}
