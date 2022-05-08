package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemElement60;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockElement60 extends Block {

    public BlockElement60() {
        super( "minecraft:element_60" );
    }

    @Override
    public ItemElement60 toItem() {
        return new ItemElement60();
    }

    @Override
    public BlockType getType() {
        return BlockType.ELEMENT_60;
    }

}
