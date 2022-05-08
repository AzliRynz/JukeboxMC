package org.jukeboxmc.block;

import org.jukeboxmc.block.direction.BlockFace;
import org.jukeboxmc.blockentity.BlockEntityBanner;
import org.jukeboxmc.item.ItemWallBanner;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockWallBanner extends BlockWaterlogable {

    public BlockWallBanner() {
        super( "minecraft:wall_banner" );
    }

    @Override
    public ItemWallBanner toItem() {
        return new ItemWallBanner();
    }

    @Override
    public BlockType getType() {
        return BlockType.WALL_BANNER;
    }

    @Override
    public boolean hasBlockEntity() {
        return true;
    }

    @Override
    public BlockEntityBanner getBlockEntity() {
        return (BlockEntityBanner) this.world.getBlockEntity( this.location, this.location.getDimension() );
    }

    public void setBlockFace( BlockFace blockFace ) {
        this.setState( "facing_direction", blockFace.ordinal() );
    }

    public BlockFace getBlockFace() {
        return this.stateExists( "facing_direction" ) ? BlockFace.values()[this.getIntState( "facing_direction" )] : BlockFace.NORTH;
    }
}
