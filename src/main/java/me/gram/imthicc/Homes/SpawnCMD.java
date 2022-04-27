package me.gram.imthicc.Homes;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("spawn.perm")) {
            if(command.getName().equalsIgnoreCase("spawn")){
                if(args.length != 0){
                    p.sendMessage("Do /spawn");
                }else if(args.length == 0){
                   Location loc = LocationManager.getLocation("Spawn");
                    p.teleport(loc);
                    p.sendMessage("Teleported to spawn");
                }

            }

        }
        return false;
    }
}

