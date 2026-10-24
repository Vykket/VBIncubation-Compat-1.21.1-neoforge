package net.vykket.vbincubationcompat.mixin;

import com.blackgear.vanillabackport.common.api.modules.mob_variant.VariantDataHolder;
import com.blackgear.vanillabackport.common.level.entities.mob.animal.chicken.ChickenVariant;
import com.teamabnormals.blueprint.core.api.EggLayer;
import com.teamabnormals.incubation.common.entity.ai.goal.LayEggInNestGoal;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.Item;
import net.vykket.vbincubationcompat.variant.VariantClassifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LayEggInNestGoal.class)
public class LayEggInNestGoalMixin {

    @Shadow
    @Final
    private Animal bird;

    @Redirect(
            method = {"tick", "isValidTarget"},
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/teamabnormals/blueprint/core/api/EggLayer;getEggItem()Lnet/minecraft/world/item/Item;"
            )
    )
    private Item replaceEgg(EggLayer eggLayer) {
        Item egg = eggLayer.getEggItem();

        if (!(bird instanceof Chicken chicken)) {
            return egg;
        }

        if (!(chicken instanceof VariantDataHolder<?> holder)) {
            return egg;
        }

        var variant = holder.getVariantData().orElse(null);
        if (!(variant instanceof ChickenVariant chickenVariant)) {
            return egg;
        }

        return switch (VariantClassifier.classify(chickenVariant)) {
            case WARM -> BuiltInRegistries.ITEM.get(
                    ResourceLocation.parse("minecraft:brown_egg")
            );
            case COLD -> BuiltInRegistries.ITEM.get(
                    ResourceLocation.parse("minecraft:blue_egg")
            );
            default -> egg;
        };
    }
}