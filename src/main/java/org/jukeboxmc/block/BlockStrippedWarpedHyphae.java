package org.jukeboxmc.block;

import org.jukeboxmc.block.direction.BlockFace;
import org.jukeboxmc.item.Item;
import org.jukeboxmc.item.ItemStrippedWarpedHyphae;
import org.jukeboxmc.item.type.ItemToolType;
import org.jukeboxmc.math.Axis;
import org.jukeboxmc.math.Vector;
import org.jukeboxmc.player.Player;
import org.jukeboxmc.world.World;

public class BlockStrippedWarpedHyphae extends Block {

    public BlockStrippedWarpedHyphae() {
        super("minecraft:stripped_warped_hyphae");
    }

    @Override
    public boolean placeBlock( Player player, World world, Vector blockPosition, Vector placePosition, Vector clickedPosition, Item itemIndHand, BlockFace blockFace ) {
        if ( blockFace == BlockFace.UP || blockFace == BlockFace.DOWN ) {
            this.setAxis( Axis.Y );
        } else if ( blockFace == BlockFace.NORTH || blockFace == BlockFace.SOUTH ) {
            this.setAxis( Axis.Z );
        } else {
            this.setAxis( Axis.X );
        }

        world.setBlock( placePosition, this );
        return true;
    }

    @Override
    public ItemStrippedWarpedHyphae toItem() {
        return new ItemStrippedWarpedHyphae();
    }

    @Override
    public BlockType getType() {
        return BlockType.STRIPPED_WARPED_HYPHAE;
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public ItemToolType getToolType() {
        return ItemToolType.AXE;
    }

    public void setDeprecated( int value ) { //0-3 Idk what it is
        this.setState( "deprecated", value );
    }

    public int getDeprecated() {
        return this.stateExists( "deprecated" ) ? this.getIntState( "deprecated" ) : 0;
    }

    public void setAxis( Axis axis ) {
        this.setState( "pillar_axis", axis.name().toLowerCase() );
    }

    public Axis getAxis() {
        return this.stateExists( "pillar_axis" ) ? Axis.valueOf( this.getStringState( "pillar_axis" ) ) : Axis.Y;
    }
}