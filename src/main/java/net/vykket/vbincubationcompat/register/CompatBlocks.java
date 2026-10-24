package net.vykket.vbincubationcompat.register;

import com.blackgear.vanillabackport.common.registries.items.ModItems;
import com.teamabnormals.incubation.common.block.BirdNestBlock;
import com.teamabnormals.incubation.common.block.EmptyNestBlock;
import com.teamabnormals.incubation.core.registry.IncubationBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vykket.vbincubationcompat.VbIncubation;
import static com.teamabnormals.incubation.core.registry.IncubationBlocks.HAY_NEST;
import static com.teamabnormals.incubation.core.registry.IncubationBlocks.TWIG_NEST;

public class CompatBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(VbIncubation.MODID);

    public static final DeferredBlock<Block> BROWN_EGG_CRATE =
            BLOCKS.register("brown_egg_crate",
                    () -> new Block(Block.Properties.of()
                            .strength(1.5F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()));

    public static final DeferredBlock<Block> BLUE_EGG_CRATE =
            BLOCKS.register("blue_egg_crate",
                    () -> new Block(Block.Properties.of()
                            .strength(1.5F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()));

    public static final DeferredBlock<Block> TWIG_BLUE_NEST =
            BLOCKS.register("twig_blue_nest",
                    () -> new BirdNestBlock(
                            () -> ModItems.BLUE_EGG.get(),
                            (EmptyNestBlock) TWIG_NEST.get(),
                            IncubationBlocks.IncubationProperties.TWIG_NEST
                    ));

    public static final DeferredBlock<Block> HAY_BLUE_NEST =
            BLOCKS.register("hay_blue_nest",
                    () -> new BirdNestBlock(
                            () -> ModItems.BLUE_EGG.get(),
                            (EmptyNestBlock) HAY_NEST.get(),
                            IncubationBlocks.IncubationProperties.HAY_NEST
                    ));

    public static final DeferredBlock<Block> TWIG_BROWN_NEST =
            BLOCKS.register("twig_brown_nest",
                    () -> new BirdNestBlock(
                            () -> ModItems.BROWN_EGG.get(),
                            (EmptyNestBlock) TWIG_NEST.get(),
                            IncubationBlocks.IncubationProperties.TWIG_NEST
                    ));

    public static final DeferredBlock<Block> HAY_BROWN_NEST =
            BLOCKS.register("hay_brown_nest",
                    () -> new BirdNestBlock(
                            () -> ModItems.BROWN_EGG.get(),
                            (EmptyNestBlock) HAY_NEST.get(),
                            IncubationBlocks.IncubationProperties.HAY_NEST
                    ));
}
