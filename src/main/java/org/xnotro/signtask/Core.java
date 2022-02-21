package org.xnotro.signtask;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Core extends JavaPlugin implements Listener {

    Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        logger.info("[SignTask] > Plugin Enabled.");
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        BlockState blockState = block.getState();

        String reward1 = getConfig().getString("rewards.reward1");
        String reward2 = getConfig().getString("rewards.reward2");
        String reward3 = getConfig().getString("rewards.reward3");
        String reward4 = getConfig().getString("rewards.reward4");
        String reward5 = getConfig().getString("rewards.reward5");

        String signText1 = getConfig().getString("rewards.signText1");
        String signText2 = getConfig().getString("rewards.signText2");
        String signText3 = getConfig().getString("rewards.signText3");
        String signText4 = getConfig().getString("rewards.signText4");
        String signText5 = getConfig().getString("rewards.signText5");

        if (blockState instanceof Sign) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Sign sign = (Sign) blockState;
                if (player.hasPermission("signtask.reward")) {
                    if (sign.getLine(0).equalsIgnoreCase(signText1)) {
                        ItemStack re1 = new ItemStack(Material.valueOf(reward1.toUpperCase()));
                        player.getInventory().addItem(re1);
                    } else if (sign.getLine(0).equalsIgnoreCase(signText2)) {
                        ItemStack re2 = new ItemStack(Material.valueOf(reward2.toUpperCase()));
                        player.getInventory().addItem(re2);
                    } else if (sign.getLine(0).equalsIgnoreCase(signText3)) {
                        ItemStack re3 = new ItemStack(Material.valueOf(reward3.toUpperCase()));
                        player.getInventory().addItem(re3);
                    } else if (sign.getLine(0).equalsIgnoreCase(signText4)) {
                        ItemStack re4 = new ItemStack(Material.valueOf(reward4.toUpperCase()));
                        player.getInventory().addItem(re4);
                    } else if (sign.getLine(0).equalsIgnoreCase(signText5)) {
                        ItemStack re5 = new ItemStack(Material.valueOf(reward5.toUpperCase()));
                        player.getInventory().addItem(re5);
                    }
                }
            }
        }
    }
}
