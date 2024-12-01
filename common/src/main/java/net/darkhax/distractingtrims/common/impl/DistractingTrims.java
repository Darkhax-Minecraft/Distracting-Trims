package net.darkhax.distractingtrims.common.impl;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.armortrim.TrimMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistractingTrims {

    public static final String MOD_ID = "distractingtrims";
    public static final String MOD_NAME = "DistractingTrims";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final TagKey<TrimMaterial> DISTRACTING_TRIM = TagKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(MOD_ID, "distracts_piglins"));
}