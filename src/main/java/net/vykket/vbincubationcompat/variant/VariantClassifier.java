package net.vykket.vbincubationcompat.variant;

import com.blackgear.vanillabackport.common.api.modules.mob_variant.spawn.SpawnCondition;
import com.blackgear.vanillabackport.common.api.modules.mob_variant.spawn.check.BiomeCheck;
import com.blackgear.vanillabackport.common.api.modules.mob_variant.spawn.check.raw.RawBiomeCheck;
import com.blackgear.vanillabackport.common.level.entities.mob.animal.chicken.ChickenVariant;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import java.util.Optional;

public class VariantClassifier {

    private static final ResourceLocation WARM =
            ResourceLocation.fromNamespaceAndPath("minecraft", "spawns_warm_variant_farm_animals");

    private static final ResourceLocation COLD =
            ResourceLocation.fromNamespaceAndPath("minecraft", "spawns_cold_variant_farm_animals");

    public enum Type {
        WARM, COLD, TEMPERATE
    }

    public static Type classify(ChickenVariant variant) {

        for (var selector : variant.spawnConditions().selectors()) {

            Optional<SpawnCondition> condOpt = selector.condition();
            if (condOpt.isEmpty()) continue;

            ResourceLocation tag = getTag(condOpt.get());
            if (tag == null) continue;

            if (tag.equals(WARM)) return Type.WARM;
            if (tag.equals(COLD)) return Type.COLD;
        }

        return Type.TEMPERATE;
    }

    private static ResourceLocation getTag(SpawnCondition condition) {

        if (condition instanceof RawBiomeCheck raw) {
            return raw.requiredBiomes().location();
        }

        if (condition instanceof BiomeCheck biome) {
            HolderSet<Biome> set = biome.requiredBiomes();
            if (set instanceof HolderSet.Named<Biome> named) {
                return named.key().location();
            }
        }

        return null;
    }
}
