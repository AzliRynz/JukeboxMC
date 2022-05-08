package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemElement84;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockElement84 extends Block {

    public BlockElement84() {
        super( "minecraft:element_84" );
    }

    @Override
    public ItemElement84 toItem() {
        return new ItemElement84();
    }

    @Override
    public BlockType getType() {
        return BlockType.ELEMENT_84;
    }

}
