package org.jukeboxmc.block;

import org.jukeboxmc.block.direction.BlockFace;
import org.jukeboxmc.item.ItemCommandBlock;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockCommandBlock extends Block {

    public BlockCommandBlock() {
        super( "minecraft:command_block" );
    }

    @Override
    public ItemCommandBlock toItem() {
        return new ItemCommandBlock();
    }

    @Override
    public BlockType getType() {
        return BlockType.COMMAND_BLOCK;
    }

    public void setConditional( boolean value ) {
        this.setState( "conditional_bit", value ? (byte) 1 : (byte) 0 );
    }

    public boolean isConditional() {
        return this.stateExists( "conditional_bit" ) && this.getByteState( "conditional_bit" ) == 1;
    }

    public void setBlockFace( BlockFace blockFace ) {
        this.setState( "facing_direction", blockFace.ordinal() );
    }

    public BlockFace getBlockFace() {
        return this.stateExists( "facing_direction" ) ? BlockFace.values()[this.getIntState( "facing_direction" )] : BlockFace.NORTH;
    }
}
