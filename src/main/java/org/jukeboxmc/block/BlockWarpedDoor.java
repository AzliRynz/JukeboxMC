package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemWarpedDoor;

public class BlockWarpedDoor extends BlockDoor {

    public BlockWarpedDoor() {
        super( "minecraft:warped_door" );
    }

    @Override
    public ItemWarpedDoor toItem() {
        return new ItemWarpedDoor();
    }

    @Override
    public BlockType getType() {
        return BlockType.WARPED_DOOR;
    }

    @Override
    public BlockWarpedDoor newDoor() {
        return new BlockWarpedDoor();
    }
}