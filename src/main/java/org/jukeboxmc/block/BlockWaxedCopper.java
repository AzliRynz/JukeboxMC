package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemWaxedCopper;
import org.jukeboxmc.item.type.ItemTierType;
import org.jukeboxmc.item.type.ItemToolType;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockWaxedCopper extends Block {

    public BlockWaxedCopper() {
        super( "minecraft:waxed_copper" );
    }

    @Override
    public ItemWaxedCopper toItem() {
        return new ItemWaxedCopper();
    }

    @Override
    public BlockType getType() {
        return BlockType.WAXED_COPPER;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public ItemToolType getToolType() {
        return ItemToolType.PICKAXE;
    }

    @Override
    public ItemTierType getTierType() {
        return ItemTierType.STONE;
    }

    @Override
    public boolean canBreakWithHand() {
        return false;
    }
}
