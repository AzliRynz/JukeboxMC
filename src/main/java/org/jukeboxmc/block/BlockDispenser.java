package org.jukeboxmc.block;

import org.jukeboxmc.block.direction.BlockFace;
import org.jukeboxmc.blockentity.BlockEntityDispenser;
import org.jukeboxmc.blockentity.BlockEntityType;
import org.jukeboxmc.item.Item;
import org.jukeboxmc.item.ItemDispenser;
import org.jukeboxmc.item.type.ItemToolType;
import org.jukeboxmc.math.Vector;
import org.jukeboxmc.player.Player;
import org.jukeboxmc.world.World;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockDispenser extends Block {

    public BlockDispenser() {
        super( "minecraft:dispenser" );
    }

    @Override
    public boolean placeBlock( Player player, World world, Vector blockPosition, Vector placePosition, Vector clickedPosition, Item itemIndHand, BlockFace blockFace ) {
        this.setBlockFace( player.getDirection().toBlockFace().opposite() );
        world.setBlock( placePosition, this, 0 );
        BlockEntityType.DISPENSER.<BlockEntityDispenser>createBlockEntity( this ).spawn();
        return true;
    }

    @Override
    public boolean interact( Player player, Vector blockPosition, Vector clickedPosition, BlockFace blockFace, Item itemInHand ) {
        BlockEntityDispenser blockEntity = this.getBlockEntity();
        if ( blockEntity != null ) {
            blockEntity.interact( player, blockPosition, clickedPosition, blockFace, itemInHand );
            return true;
        }
        return false;
    }

    @Override
    public ItemDispenser toItem() {
        return new ItemDispenser();
    }

    @Override
    public BlockType getType() {
        return BlockType.DISPENSER;
    }

    @Override
    public boolean hasBlockEntity() {
        return true;
    }

    @Override
    public BlockEntityDispenser getBlockEntity() {
        return (BlockEntityDispenser) this.world.getBlockEntity( this.location, this.location.getDimension() );
    }

    @Override
    public double getHardness() {
        return 3.5;
    }

    @Override
    public ItemToolType getToolType() {
        return ItemToolType.PICKAXE;
    }

    public void setTriggered( boolean value ) {
        this.setState( "triggered_bit", value ? (byte) 1 : (byte) 0 );
    }

    public boolean isTriggered() {
        return this.stateExists( "triggered_bit" ) && this.getByteState( "triggered_bit" ) == 1;
    }

    public void setBlockFace( BlockFace blockFace ) {
        this.setState( "facing_direction", blockFace.ordinal() );
    }

    public BlockFace getBlockFace() {
        return this.stateExists( "facing_direction" ) ? BlockFace.values()[this.getIntState( "facing_direction" )] : BlockFace.NORTH;
    }
}
