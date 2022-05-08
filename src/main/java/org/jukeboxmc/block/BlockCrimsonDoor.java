package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemCrimsonDoor;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockCrimsonDoor extends BlockDoor {

    public BlockCrimsonDoor() {
        super( "minecraft:crimson_door" );
    }

    @Override
    public ItemCrimsonDoor toItem() {
        return new ItemCrimsonDoor();
    }

    @Override
    public BlockType getType() {
        return BlockType.CRIMSON_DOOR;
    }

    @Override
    public BlockCrimsonDoor newDoor() {
        return new BlockCrimsonDoor();
    }
}
