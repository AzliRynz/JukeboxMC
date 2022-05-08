package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemSweetBerryBush;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockSweetBerryBush extends Block {

    public BlockSweetBerryBush() {
        super( "minecraft:sweet_berry_bush" );
    }

    @Override
    public ItemSweetBerryBush toItem() {
        return new ItemSweetBerryBush();
    }

    @Override
    public BlockType getType() {
        return BlockType.SWEET_BERRY_BUSH;
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    public void setGrowth( int value ) { //0-7
        this.setState( "growth", value );
    }

    public int getGrowth() {
        return this.stateExists( "growth" ) ? this.getIntState( "growth" ) : 0;
    }

}
