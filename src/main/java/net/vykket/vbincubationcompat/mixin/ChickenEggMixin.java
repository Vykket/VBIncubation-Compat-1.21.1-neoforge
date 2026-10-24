package net.vykket.vbincubationcompat.mixin;

import com.blackgear.vanillabackport.common.api.modules.mob_variant.VariantDataHolder;
import com.blackgear.vanillabackport.common.level.entities.mob.animal.chicken.ChickenVariant;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.Item;
import net.vykket.vbincubationcompat.variant.VariantClassifier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Chicken.class)
public abstract class ChickenEggMixin {

    @WrapMethod(method = "getEggItem")
    private Item modifygetEggItem(
            Operation<Item> original
    ) {
        Chicken chicken = (Chicken) (Object) this;

        if (!(chicken instanceof VariantDataHolder<?> holder)) {
            return original.call();
        }

        var variant = holder.getVariantData().orElse(null);

        if (!(variant instanceof ChickenVariant chickenVariant)) {
            return original.call();
        }

        return switch (VariantClassifier.classify(chickenVariant)) {
            case WARM -> BuiltInRegistries.ITEM.get(
                    ResourceLocation.parse("minecraft:brown_egg")
            );

            case COLD -> BuiltInRegistries.ITEM.get(
                    ResourceLocation.parse("minecraft:blue_egg")
            );

            default -> original.call();
        };
    }
}
