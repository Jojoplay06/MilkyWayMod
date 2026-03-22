package com.jojoplay.milkywaymod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;


public class YogurtItem extends Item {
    private static final int DRINK_DURATION = 32;

    public YogurtItem(Properties properties) { super(properties); }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {

        ItemStack result = super.finishUsingItem(stack, level, entityLiving);

        if (entityLiving instanceof Player player) {
            return ItemUtils.createFilledResult(
                    result,
                    player,
                    new ItemStack(Items.GLASS_BOTTLE)
            );
        }

        return result;
    }


    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}
