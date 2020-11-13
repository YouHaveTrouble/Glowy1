package pl.kokomistrz.glowy;

import jdk.nashorn.internal.ir.Block;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public final class Glowy extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Włączyłem się");

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("test")) {
            int random = ThreadLocalRandom.current().nextInt(32, 128);
           // sender.sendMessage(String.valueOf(random));
           // if(random == 1){

             for (World world : getServer().getWorlds()) {
                    for (Chunk chunk : world.getLoadedChunks()) {
                        int cx = chunk.getX() << 4;
                        int cz = chunk.getZ() << 4;
                        for (int x = cx; x < cx + random; x++) {
                            for (int z = cz; z < cz + random; z++) {
                                for (int y = 0; y < 256; y++) {
                                    if (world.getBlockAt(x, y, z).getType().equals(Material.GRASS_BLOCK) || world.getBlockAt(x, y, z).getType().equals(Material.ACACIA_LEAVES) || world.getBlockAt(x, y, z).getType().equals(Material.BIRCH_LEAVES) || world.getBlockAt(x, y, z).getType().equals(Material.DARK_OAK_LEAVES) || world.getBlockAt(x, y, z).getType().equals(Material.JUNGLE_LEAVES) || world.getBlockAt(x, y, z).getType().equals(Material.OAK_LEAVES) || world.getBlockAt(x, y, z).getType().equals(Material.SPRUCE_LEAVES)) {
                                        world.getBlockAt(x, y + 1, z).setType(Material.BEDROCK);
                                        sender.sendMessage("test");
                                        int random1= ThreadLocalRandom.current().nextInt(33, 123);
                                        z = z+random1;
                                        x= x+random1;
                                        return true;



                                    }
                                }
                            }
                        }
                    }

                }

            }


       // }
        return super.onCommand(sender, command, label, args);
    }
}