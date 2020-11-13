package pl.kokomistrz.glowy.listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import pl.kokomistrz.glowy.util.SpawningUtil;

public class OnChunkLoadListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onChunkLoad(org.bukkit.event.world.ChunkLoadEvent event) {

        //event.getChunk().getPersistentDataContainer();

        SpawningUtil.generateHeads(event.getChunk());


    }

}
