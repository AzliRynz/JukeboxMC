package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemElement14;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockElement14 extends Block {

    public BlockElement14() {
        super( "minecraft:element_14" );
    }

    @Override
    public ItemElement14 toItem() {
        return new ItemElement14();
    }

    @Override
    public BlockType getType() {
        return BlockType.ELEMENT_14;
    }

}
