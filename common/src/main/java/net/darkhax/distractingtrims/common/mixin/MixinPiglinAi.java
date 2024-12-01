package net.darkhax.distractingtrims.common.mixin;

import net.darkhax.distractingtrims.common.impl.DistractingTrims;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.ArmorTrim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PiglinAi.class)
public class MixinPiglinAi {

    @Inject(method = "isWearingGold(Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At("HEAD"), cancellable = true)
    private static void isWearingGold(LivingEntity wearer, CallbackInfoReturnable<Boolean> cbi) {
        for (ItemStack stack : wearer.getArmorSlots()) {
            if (stack.has(DataComponents.TRIM)) {
                final ArmorTrim trim = stack.get(DataComponents.TRIM);
                if (trim != null && trim.material().is(DistractingTrims.DISTRACTING_TRIM)) {
                    cbi.setReturnValue(true);
                }
            }
        }
    }
}