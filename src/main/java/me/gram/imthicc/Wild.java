package me.gram.imthicc;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Wild {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("wildesttp")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("Wildesttp")) {
                    int randomx = (int) (Math.random() * 5000);
                    int randomz = (int) (Math.random() * 5000);
                    int randomy = player.getWorld().getHighestBlockYAt(randomx, randomz);

                    Location randomLocation = new Location(player.getWorld(), randomx, randomy, randomz);
                    player.teleport(randomLocation);
                    player.sendMessage("You've been teleported bruh enjoy");


                }

            }
        }

        return true;

    }
}
