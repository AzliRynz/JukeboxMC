package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemOxidizedCutCopperStairs;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockOxidizedCutCopperStairs extends BlockStairs {

    public BlockOxidizedCutCopperStairs() {
        super( "minecraft:oxidized_cut_copper_stairs" );
    }

    @Override
    public ItemOxidizedCutCopperStairs toItem() {
        return new ItemOxidizedCutCopperStairs();
    }

    @Override
    public BlockType getType() {
        return BlockType.OXIDIZED_CUT_COPPER_STAIRS;
    }
}
