package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemWarpedPressurePlate;

public class BlockWarpedPressurePlate extends BlockPressurePlate {

    public BlockWarpedPressurePlate() {
        super("minecraft:warped_pressure_plate");
    }

    @Override
    public ItemWarpedPressurePlate toItem() {
        return new ItemWarpedPressurePlate();
    }

    @Override
    public BlockType getType() {
        return BlockType.WARPED_PRESSURE_PLATE;
    }

}