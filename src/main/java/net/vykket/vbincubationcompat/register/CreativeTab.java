package net.vykket.vbincubationcompat.register;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class CreativeTab {

    public static void addItems(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {

            event.insertAfter(
                    Items.HAY_BLOCK.getDefaultInstance(),
                    CompatBlocks.BROWN_EGG_CRATE.get().asItem().getDefaultInstance(),
                    net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.insertAfter(
                    Items.HAY_BLOCK.getDefaultInstance(),
                    CompatBlocks.BLUE_EGG_CRATE.get().asItem().getDefaultInstance(),
                    net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }
    }
}
