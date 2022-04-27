package me.gram.imthicc.Homes;

import me.gram.imthicc.Files.DataManager;
import me.gram.imthicc.ImThicc;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bukkit.Bukkit.getServer;

public class Home  implements Listener {


    public DataManager data;

    private final ImThicc plugin;
    public Home(ImThicc plugin){
        this.plugin = plugin;}



    Logger myplugin = Bukkit.getLogger();


    HashMap<String, Location> playerHomes = new HashMap<String, Location>();


    public boolean onCommand(CommandSender theSender, Command cmd, String commandLabel, String[] args) {
        if (theSender instanceof ConsoleCommandSender) //if console tell him to piss off////
        {
            System.out.println("Only players may use this");

        }

        if (theSender instanceof Player) //make sure its a player who is doing the command  and sequence if it's a player
        {
            Player player = (Player) theSender;
            Location location = player.getLocation();

            plugin.getConfig().set("Home", location);

            if (commandLabel.equalsIgnoreCase("sethome")) //implementing sethome, home and delhome commands
            {
                playerHomes.put(player.getName(), player.getLocation());
                player.sendMessage(ChatColor.GREEN + "Home set!");
                int amount = 0;

                if (this.data.getConfig().contains("players." + player.getUniqueId().toString() + ".total"))
                    amount = this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".total");
                data.getConfig().set("players." + player.getUniqueId().toString() + ".total", (amount + 1));
                plugin.getConfig().set("spawn", location);
                data.saveConfig();

                if (commandLabel.equalsIgnoreCase("delhome")) {
                    location = playerHomes.remove(player.getName());
                    player.sendMessage(ChatColor.GREEN + "Home deleted!");

                    if (this.data.getConfig().contains("players." + player.getUniqueId().toString() + ".total"))
                        amount = this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".total");
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".total", (amount - 1));
                    data.saveConfig();



                }
            }

            if (commandLabel.equalsIgnoreCase("Home")) {
                Location homeLocation = playerHomes.get(player.getName());
                player.teleport(homeLocation);
                player.sendMessage(ChatColor.GREEN + "Teleported back to Home!");

            }


        }

        return true;

    }




}

