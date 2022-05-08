package org.jukeboxmc.block;

import org.jukeboxmc.item.ItemWarpedFenceGate;

public class BlockWarpedFenceGate extends BlockFenceGate {

    public BlockWarpedFenceGate() {
        super("minecraft:warped_fence_gate");
    }

    @Override
    public ItemWarpedFenceGate toItem() {
        return new ItemWarpedFenceGate();
    }

    @Override
    public BlockType getType() {
        return BlockType.WARPED_FENCE_GATE;
    }

}