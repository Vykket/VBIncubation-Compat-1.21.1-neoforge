package net.vykket.vbincubationcompat.register;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vykket.vbincubationcompat.VbIncubation;

public class CompatItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(VbIncubation.MODID);

    public static final DeferredHolder<Item, BlockItem> BROWN_EGG_CRATE =
            ITEMS.register("brown_egg_crate",
                    () -> new BlockItem(CompatBlocks.BROWN_EGG_CRATE.get(),
                            new Item.Properties()));

    public static final DeferredHolder<Item, BlockItem> BLUE_EGG_CRATE =
            ITEMS.register("blue_egg_crate",
                    () -> new BlockItem(CompatBlocks.BLUE_EGG_CRATE.get(),
                            new Item.Properties()));

}
