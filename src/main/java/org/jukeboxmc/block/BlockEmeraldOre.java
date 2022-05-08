package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemEmeraldOre;
import org.jukeboxmc.item.type.ItemTierType;
import org.jukeboxmc.item.type.ItemToolType;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockEmeraldOre extends Block {

    public BlockEmeraldOre() {
        super( "minecraft:emerald_ore" );
    }

    @Override
    public ItemEmeraldOre toItem() {
        return new ItemEmeraldOre();
    }

    @Override
    public BlockType getType() {
        return BlockType.EMERALD_ORE;
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
        return ItemTierType.IRON;
    }

    @Override
    public boolean canBreakWithHand() {
        return false;
    }

}
