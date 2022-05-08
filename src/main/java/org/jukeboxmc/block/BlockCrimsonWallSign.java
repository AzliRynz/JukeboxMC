package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemCrimsonWallSign;

public class BlockCrimsonWallSign extends BlockWallSign {

    public BlockCrimsonWallSign() {
        super("minecraft:crimson_wall_sign");
    }

    @Override
    public ItemCrimsonWallSign toItem() {
        return new ItemCrimsonWallSign();
    }

    @Override
    public BlockType getType() {
        return BlockType.CRIMSON_WALL_SIGN;
    }

}