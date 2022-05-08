package org.jukeboxmc.block;

import org.jukeboxmc.block.direction.BlockFace;
import org.jukeboxmc.block.type.WallType;
import org.jukeboxmc.item.Item;
import org.jukeboxmc.item.ItemCobblestoneWall;
import org.jukeboxmc.math.Vector;
import org.jukeboxmc.player.Player;
import org.jukeboxmc.world.World;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockCobblestoneWall extends BlockWall {

    public BlockCobblestoneWall() {
        super( "minecraft:cobblestone_wall" );
    }

    @Override
    public boolean placeBlock( Player player, World world, Vector blockPosition, Vector placePosition, Vector clickedPosition, Item itemIndHand, BlockFace blockFace ) {
        this.updateWall();
        return super.placeBlock( player, world, blockPosition, placePosition, clickedPosition, itemIndHand, blockFace );
    }

    @Override
    public BlockType getType() {
        return BlockType.COBBLESTONE_WALL;
    }

    @Override
    public ItemCobblestoneWall toItem() {
        return new ItemCobblestoneWall( this.runtimeId );
    }

    public BlockCobblestoneWall setWallBlockType( WallType wallType ) {
        return this.setState( "wall_block_type", wallType.name().toLowerCase() );
    }

    public WallType getWallBlockType() {
        return this.stateExists( "wall_block_type" ) ? WallType.valueOf( this.getStringState( "wall_block_type" ) ) : WallType.COBBLESTONE;
    }

}
