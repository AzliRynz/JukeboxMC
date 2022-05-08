package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemCauldron;
import org.jukeboxmc.item.type.ItemToolType;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockCauldron extends BlockWaterlogable {

    public BlockCauldron() {
        super( "minecraft:cauldron" );
    }

    @Override
    public ItemCauldron toItem() {
        return new ItemCauldron();
    }

    @Override
    public BlockType getType() {
        return BlockType.CAULDRON;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public ItemToolType getToolType() {
        return ItemToolType.PICKAXE;
    }

    @Override
    public boolean canBreakWithHand() {
        return false;
    }

    public void setFillLevel( int value ) { //0-6
        this.setState( "fill_level", value );
    }

    public int getFillLevel() {
        return this.stateExists( "fill_level" ) ? this.getIntState( "fill_level" ) : 0;
    }

    public void setLiquid( LiquidType liquidType ) {
        this.setState( "cauldron_liquid", liquidType.name().toLowerCase() );
    }

    public LiquidType getLiquidType() {
        return this.stateExists( "cauldron_liquid" ) ? LiquidType.valueOf( this.getStringState( "cauldron_liquid" ) ) : LiquidType.WATER;
    }

    public enum LiquidType {
        WATER,
        LAVA
    }
}
