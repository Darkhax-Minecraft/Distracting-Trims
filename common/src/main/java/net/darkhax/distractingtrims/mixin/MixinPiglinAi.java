package net.darkhax.distractingtrims.mixin;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.armortrim.TrimMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public class MixinPiglinAi {

    @Unique
    private static final TagKey<TrimMaterial> DISTRACTING_TRIM = TagKey.create(Registries.TRIM_MATERIAL, new ResourceLocation("distractingtrims", "distracts_piglins"));

    @Inject(method = "isWearingGold(Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At("HEAD"), cancellable = true)
    private static void isWearingGold(LivingEntity wearer, CallbackInfoReturnable<Boolean> cbi) {

        for (ItemStack stack : wearer.getArmorSlots()) {

            if (stack.hasTag()) {

                final ArmorTrim trim = ArmorTrim.getTrim(wearer.level().registryAccess(), stack, true).orElse(null);

                if (trim != null && trim.material().is(DISTRACTING_TRIM)) {

                    cbi.setReturnValue(true);
                }
            }
        }
    }
}