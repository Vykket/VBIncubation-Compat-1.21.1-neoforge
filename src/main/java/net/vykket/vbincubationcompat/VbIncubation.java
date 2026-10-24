package net.vykket.vbincubationcompat;

import net.neoforged.fml.common.Mod;
import net.vykket.vbincubationcompat.register.CompatBlocks;
import net.vykket.vbincubationcompat.register.CompatItems;
import net.vykket.vbincubationcompat.register.CreativeTab;

@Mod(VbIncubation.MODID)
public class VbIncubation {

    public static final String MODID = "vbincubationcompat";

    public VbIncubation(net.neoforged.bus.api.IEventBus modEventBus) {

        CompatBlocks.BLOCKS.register(modEventBus);
        CompatItems.ITEMS.register(modEventBus);
        modEventBus.addListener(CreativeTab::addItems);
    }
}

