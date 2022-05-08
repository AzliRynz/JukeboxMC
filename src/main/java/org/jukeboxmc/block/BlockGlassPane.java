package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemGlassPane;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockGlassPane extends BlockWaterlogable {

    public BlockGlassPane() {
        super( "minecraft:glass_pane" );
    }

    @Override
    public ItemGlassPane toItem() {
        return new ItemGlassPane();
    }

    @Override
    public BlockType getType() {
        return BlockType.GLASS_PANE;
    }

    @Override
    public double getHardness() {
        return 0.3;
    }

    @Override
    public boolean canBreakWithHand() {
        return false;
    }
}