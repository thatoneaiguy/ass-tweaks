package com.thatoneaiguy.mixin;

import com.thatoneaiguy.client.AssConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( BundleItem.class )
public class BundleItemMixin {

    @Shadow public static final int MAX_STORAGE = AssConfig.MAX_STORAGE;

    /**
     * @author thatoneaigyy ( eeverest )
     * @reason Expands upon the bundle's storage
     */

    @Overwrite()
    private static boolean dropAllBundledItems(ItemStack stack, PlayerEntity player) {
        return false;
    }

    @Inject(method = "getItemOccupancy", at = @At("TAIL"), cancellable = true )
    private static void ass$UnstackableItemOccupancyExpander(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        // return value is the " weight " of the item in a bundle
        if ( !stack.isStackable() ) {
            if ( !stack.getItem().equals(Items.ENCHANTED_BOOK) ) {
                if ( !stack.getItem().equals(Items.TOTEM_OF_UNDYING) ) {
                    cir.setReturnValue(AssConfig.UNSTACKABLE_VALUE);
                }
            }
            if ( stack.getItem().equals(Items.ENCHANTED_BOOK) ) {
                cir.setReturnValue( AssConfig.ENCH_BOOK_VALUE );
            }
            if ( stack.getItem().equals(Items.TOTEM_OF_UNDYING) ) {
                cir.setReturnValue(AssConfig.TOTEM_VALUE);
            }
        }
    }
}