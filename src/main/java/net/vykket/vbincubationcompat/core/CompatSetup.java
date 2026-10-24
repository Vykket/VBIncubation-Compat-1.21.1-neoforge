package net.vykket.vbincubationcompat.core;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import com.blackgear.vanillabackport.common.registries.items.ModItems;
import com.teamabnormals.incubation.common.block.EmptyNestBlock;
import com.teamabnormals.incubation.core.registry.IncubationBlocks;
import net.vykket.vbincubationcompat.register.CompatBlocks;

public class CompatSetup {

    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            EmptyNestBlock twig = (EmptyNestBlock) IncubationBlocks.TWIG_NEST.get();
            EmptyNestBlock hay = (EmptyNestBlock) IncubationBlocks.HAY_NEST.get();

            twig.addNest(() -> ModItems.BLUE_EGG.get(), CompatBlocks.TWIG_BLUE_NEST.get());
            hay.addNest(() -> ModItems.BLUE_EGG.get(), CompatBlocks.HAY_BLUE_NEST.get());

            twig.addNest(() -> ModItems.BROWN_EGG.get(), CompatBlocks.TWIG_BROWN_NEST.get());
            hay.addNest(() -> ModItems.BROWN_EGG.get(), CompatBlocks.HAY_BROWN_NEST.get());
        });
    }
}
