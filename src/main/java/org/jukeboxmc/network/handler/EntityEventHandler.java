package org.jukeboxmc.network.handler;

import org.cloudburstmc.protocol.bedrock.data.entity.EntityEventType;
import org.cloudburstmc.protocol.bedrock.packet.EntityEventPacket;
import org.jukeboxmc.Server;
import org.jukeboxmc.player.Player;

/**
 * @author LucGamesYT
 * @version 1.0
 */
public class EntityEventHandler implements PacketHandler<EntityEventPacket>{

    @Override
    public void handle( EntityEventPacket packet, Server server, Player player ) {
        if ( packet.getType().equals( EntityEventType.EATING_ITEM ) ) {
            if ( packet.getData() == 0 || packet.getRuntimeEntityId() != player.getEntityId() ) {
                return;
            }
            server.broadcastPacket( packet );
        }
    }
}

