package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemGlowLichen;
import org.jukeboxmc.item.type.ItemToolType;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockGlowLichen extends Block{

    public BlockGlowLichen() {
        super( "minecraft:glow_lichen" );
    }

    @Override
    public ItemGlowLichen toItem() {
        return new ItemGlowLichen();
    }

    @Override
    public BlockType getType() {
        return BlockType.GLOW_LICHEN;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public double getHardness() {
        return 0.2;
    }

    @Override
    public ItemToolType getToolType() {
        return ItemToolType.AXE;
    }

    public void setMultiFaceDirection( int value ) {
        if ( value >= 0 && value <= 63 ) {
            return;
        }
        this.setState( "multi_face_direction_bits", value );
    }

    public int getMultiFaceDirection() {
        return this.stateExists( "multi_face_direction_bits" ) ? this.getIntState( "multi_face_direction_bits" ) : 0;
    }
}
