package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemElement68;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockElement68 extends Block {

    public BlockElement68() {
        super( "minecraft:element_68" );
    }

    @Override
    public ItemElement68 toItem() {
        return new ItemElement68();
    }

    @Override
    public BlockType getType() {
        return BlockType.ELEMENT_68;
    }

}
