package pl.kokomistrz.glowy;

import org.bukkit.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import pl.kokomistrz.glowy.listeners.OnChunkLoadListener;

public final class Glowy extends JavaPlugin implements Listener {

    private static Glowy plugin;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Włączyłem się");
        plugin = this;
        getServer().getPluginManager().registerEvents(new OnChunkLoadListener(), this);

    }

    public static Glowy getInstance() {
        return plugin;
    }

}