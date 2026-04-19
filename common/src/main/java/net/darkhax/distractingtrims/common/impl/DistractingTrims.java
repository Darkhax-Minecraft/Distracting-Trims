package net.darkhax.distractingtrims.common.impl;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistractingTrims {

    public static final String MOD_ID = "distractingtrims";
    public static final String MOD_NAME = "DistractingTrims";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final TagKey<TrimMaterial> DISTRACTING_TRIM = TagKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(MOD_ID, "distracts_piglins"));
}