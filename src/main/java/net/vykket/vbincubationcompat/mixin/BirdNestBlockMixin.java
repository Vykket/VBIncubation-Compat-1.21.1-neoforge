package net.vykket.vbincubationcompat.mixin;

import com.teamabnormals.incubation.common.block.BirdNestBlock;
import com.teamabnormals.incubation.common.block.EmptyNestBlock;
import com.teamabnormals.incubation.core.registry.IncubationBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.vykket.vbincubationcompat.register.CompatBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Supplier;

@Mixin(BirdNestBlock.class)
public class BirdNestBlockMixin {

    @Redirect(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/teamabnormals/incubation/common/block/EmptyNestBlock;addNest(Ljava/util/function/Supplier;Lnet/minecraft/world/level/block/Block;)V"
            )
    )
    @SuppressWarnings("unchecked")
    private void addCompatNest(
            EmptyNestBlock nestBlock,
            Supplier<?> egg,
            Block nest
    ) {
        nestBlock.addNest((Supplier<? extends Item>) egg, nest);
    }

    @Inject(
            method = "removeEgg",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void removeCompatEgg(
            Entity entity,
            BlockState state,
            LevelAccessor level,
            BlockPos pos,
            CallbackInfoReturnable<BlockState> cir
    ) {
        if (state.getValue(BirdNestBlock.EGGS) > 1) {
            return;
        }

        Block nest = state.getBlock();
        BlockState emptyNest = null;

        if (nest == CompatBlocks.TWIG_BLUE_NEST.get()
                || nest == CompatBlocks.TWIG_BROWN_NEST.get()) {
            emptyNest = IncubationBlocks.TWIG_NEST.get().defaultBlockState();
        } else if (nest == CompatBlocks.HAY_BLUE_NEST.get()
                || nest == CompatBlocks.HAY_BROWN_NEST.get()) {
            emptyNest = IncubationBlocks.HAY_NEST.get().defaultBlockState();
        }

        if (emptyNest == null) {
            return;
        }

        level.setBlock(pos, emptyNest, Block.UPDATE_ALL);
        cir.setReturnValue(emptyNest);
    }
}