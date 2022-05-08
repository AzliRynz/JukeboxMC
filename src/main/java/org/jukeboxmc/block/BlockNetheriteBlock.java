package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemNetheriteBlock;
import org.jukeboxmc.item.type.ItemTierType;
import org.jukeboxmc.item.type.ItemToolType;

public class BlockNetheriteBlock extends Block {

    public BlockNetheriteBlock() {
        super("minecraft:netherite_block");
    }

    @Override
    public ItemNetheriteBlock toItem() {
        return new ItemNetheriteBlock();
    }

    @Override
    public BlockType getType() {
        return BlockType.NETHERITE_BLOCK;
    }

    @Override
    public double getHardness() {
        return 50;
    }

    @Override
    public ItemToolType getToolType() {
        return ItemToolType.PICKAXE;
    }

    @Override
    public ItemTierType getTierType() {
        return ItemTierType.DIAMOND;
    }

    @Override
    public boolean canBreakWithHand() {
        return false;
    }

}