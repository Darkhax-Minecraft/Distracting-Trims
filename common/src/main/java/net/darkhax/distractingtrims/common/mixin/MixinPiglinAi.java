package net.darkhax.distractingtrims.common.mixin;

import net.darkhax.distractingtrims.common.impl.DistractingTrims;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PiglinAi.class)
public class MixinPiglinAi {

    @Inject(method = "isWearingSafeArmor(Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At("HEAD"), cancellable = true)
    private static void isWearingSafeArmor(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cbi) {
        for (EquipmentSlot slot : EquipmentSlotGroup.ARMOR) {
            final ItemStack stack = livingEntity.getItemBySlot(slot);
            if (stack.has(DataComponents.TRIM)) {
                final ArmorTrim trim = stack.get(DataComponents.TRIM);
                if (trim != null && trim.material().is(DistractingTrims.DISTRACTING_TRIM)) {
                    cbi.setReturnValue(true);
                }
            }
        }
    }
}