package me.gram.imthicc.Homes;

import jdk.tools.jmod.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class setSpawn implements CommandExecutor {


   //@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("spawn.perm")) {
            if(command.getName().equalsIgnoreCase("setspawn")){
                if(args.length != 0){
                    p.sendMessage("Do /setspawn");
                }else if(args.length == 0){
                    LocationManager.setLocation("Spawn", p.getLocation());
                    p.sendMessage("Spawn set");
                }
            }
        }
        else{p.sendMessage("No permission to use spawn");
        }
        return false;
    }
}
