package com.jojoplay.milkywaymod.event;

import com.jojoplay.milkywaymod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
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
        if (event.getTarget() instanceof Sheep sheep && stack.getItem() == Items.BUCKET && !sheep.isBaby()){
            giveMilk(player, event, new ItemStack(ModItems.SHEEP_MILK_BUCKET.get()));
        }

        //Cabra
        if (event.getTarget() instanceof Goat goat && stack.getItem() == Items.BUCKET && !goat.isBaby()){
            giveMilk(player, event, new ItemStack(ModItems.GOAT_MILK_BUCKET.get()));
        }
    }

    private static void giveMilk(Player player, PlayerInteractEvent.EntityInteract event, ItemStack result) {

        ItemStack stack = player.getItemInHand(event.getHand());

        player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);

        if (!player.level().isClientSide) {

            //si no esta en creativo quita un cubo
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            if (stack.isEmpty()) {
                player.setItemInHand(event.getHand(), result);
            } else {
                if (!player.getInventory().add(result)) {
                    player.drop(result, false);
                }
            }
        }

        event.setCancellationResult(net.minecraft.world.InteractionResult.SUCCESS);
        event.setCanceled(true);
    }
}
