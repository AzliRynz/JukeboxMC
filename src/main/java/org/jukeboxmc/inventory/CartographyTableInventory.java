package org.jukeboxmc.inventory;

import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerType;
import org.jukeboxmc.player.Player;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class CartographyTableInventory extends ContainerInventory {

    public CartographyTableInventory( InventoryHolder holder ) {
        super( holder, -1, 3 );
    }

    @Override
    public Player getInventoryHolder() {
        return (Player) this.holder;
    }

    @Override
    public InventoryType getType() {
        return InventoryType.CARTOGRAPHY_TABLE;
    }

    @Override
    public ContainerType getWindowTypeId() {
        return ContainerType.CARTOGRAPHY;
    }
}
