package org.jukeboxmc.block;

import org.jukeboxmc.block.direction.BlockFace;
import org.jukeboxmc.item.Item;
import org.jukeboxmc.item.ItemCobbledDeepslateSlab;
import org.jukeboxmc.item.type.ItemToolType;
import org.jukeboxmc.math.Vector;
import org.jukeboxmc.player.Player;
import org.jukeboxmc.world.World;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class BlockCobbledDeepslateSlab extends BlockSlab {

    public BlockCobbledDeepslateSlab() {
        super( "minecraft:cobbled_deepslate_slab" );
    }

    @Override
    public boolean placeBlock( Player player, World world, Vector blockPosition, Vector placePosition, Vector clickedPosition, Item itemIndHand, BlockFace blockFace ) {
        Block targetBlock = world.getBlock( blockPosition );
        Block block = world.getBlock( placePosition );

        if ( blockFace == BlockFace.DOWN ) {
            if ( targetBlock instanceof BlockCobbledDeepslateSlab && ( (BlockCobbledDeepslateSlab) targetBlock ).isTopSlot() ) {
                world.setBlock( blockPosition, new BlockCobbledDeepslateDoubleSlab() );
                return true;
            } else if ( block instanceof BlockCobbledDeepslateSlab ) {
                world.setBlock( placePosition, new BlockCobbledDeepslateDoubleSlab() );
                return true;
            }
        } else if ( blockFace == BlockFace.UP ) {
            if ( targetBlock instanceof BlockCobbledDeepslateSlab && !( (BlockCobbledDeepslateSlab) targetBlock ).isTopSlot() ) {
                world.setBlock( blockPosition, new BlockCobbledDeepslateDoubleSlab() );
                return true;
            } else if ( block instanceof BlockCobbledDeepslateSlab ) {
                world.setBlock( placePosition, new BlockCobbledDeepslateDoubleSlab() );
                return true;
            }
        } else {
            if ( block instanceof BlockCobbledDeepslateSlab ) {
                world.setBlock( placePosition, new BlockCobbledDeepslateDoubleSlab() );
                return true;
            } else {
                this.setTopSlot( clickedPosition.getY() > 0.5 && !world.getBlock( blockPosition ).canBeReplaced( this ) );
            }
        }
        super.placeBlock( player, world, blockPosition, placePosition, clickedPosition, itemIndHand, blockFace );
        world.setBlock( placePosition, this );
        return true;
    }

    @Override
    public ItemCobbledDeepslateSlab toItem() {
        return new ItemCobbledDeepslateSlab();
    }

    @Override
    public BlockType getType() {
        return BlockType.COBBLED_DEEPSLATE_SLAB;
    }

    @Override
    public double getHardness() {
        return 3.5;
    }

    @Override
    public ItemToolType getToolType() {
        return ItemToolType.PICKAXE;
    }

    @Override
    public boolean canBreakWithHand() {
        return false;
    }
}
