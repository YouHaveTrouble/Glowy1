package pl.kokomistrz.glowy.util;

import org.bukkit.*;
import pl.kokomistrz.glowy.Glowy;

import java.util.Random;

public class SpawningUtil {

    public static void generateHeads(Chunk chunk) {

        Bukkit.getScheduler().runTaskAsynchronously(Glowy.getInstance(), () -> {
            int x = randomInt();
            int z = randomInt();

            for (int y = 0; y < 256; y++) {
                if (!chunk.getBlock(x, y, z).getType().equals(Material.GRASS_BLOCK) && !chunk.getBlock(x, y, z).getType().toString().endsWith("_LEAVES"))
                    continue;

                if (!chunk.getBlock(x, y + 1, z).getType().equals(Material.AIR))
                    continue;

                genHead(chunk, x, y, z);

            }
        });
    }

    public static void genHead(Chunk chunk, int x, int y, int z) {
        Bukkit.getScheduler().runTask(Glowy.getInstance(), () -> {
            chunk.getBlock(x, y + 1, z).setType(Material.BEDROCK);
        });

    }

    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(15);
    }

}
