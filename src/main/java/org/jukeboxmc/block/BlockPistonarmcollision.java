package org.jukeboxmc.block;

import org.jukeboxmc.block.direction.BlockFace;
import org.jukeboxmc.item.ItemPistonarmcollision;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockPistonarmcollision extends BlockWaterlogable {

    public BlockPistonarmcollision() {
        super( "minecraft:piston_arm_collision" );
    }

    @Override
    public ItemPistonarmcollision toItem() {
        return new ItemPistonarmcollision();
    }

    @Override
    public BlockType getType() {
        return BlockType.PISTONARMCOLLISION;
    }

    public void setBlockFace( BlockFace blockFace ) {
        this.setState( "facing_direction", blockFace.ordinal() );
    }

    public BlockFace getBlockFace() {
        return this.stateExists( "facing_direction" ) ? BlockFace.values()[this.getIntState( "facing_direction" )] : BlockFace.NORTH;
    }
}
