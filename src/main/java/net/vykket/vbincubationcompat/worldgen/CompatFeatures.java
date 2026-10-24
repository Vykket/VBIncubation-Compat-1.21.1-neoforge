package net.vykket.vbincubationcompat.worldgen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.vykket.vbincubationcompat.VbIncubation;

public class CompatFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_NEST =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(VbIncubation.MODID, "blue_nest")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_NEST =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(VbIncubation.MODID, "brown_nest")
            );
}
