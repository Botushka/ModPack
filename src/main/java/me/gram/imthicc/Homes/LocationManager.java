package me.gram.imthicc.Homes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class LocationManager {

    private static File file = new File("plugins/ImThicc/locations.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void saveCfg(){
        try{
            cfg.save(file);}
        catch(IOException e){
        }
    }



    public static void setLocation(String name, Location loc){

            
            cfg.set(name + ".world", loc.getWorld().getName().toString());
            cfg.set(name + ".x", loc.getBlockX());
            cfg.set(name + ".y", loc.getBlockY());
            cfg.set(name + ".z", loc.getBlockZ());
            cfg.set(name + ".Yaw", loc.getYaw());
            cfg.set(name + ".Pitch", loc.getPitch());
            saveCfg();
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                }
            }
    }

    public static Location getLocation(String name){
        World world = Bukkit.getWorld(cfg.getString(name +".world"));
        double x = cfg.getDouble(name+".x");
        double y = cfg.getDouble(name+".y");
        double z = cfg.getDouble(name+".z");
        Location loc = new Location(world, x, y, z);
        loc.setYaw(cfg.getInt(name+".yaw"));
        loc.setPitch(cfg.getInt(name+".pitch"));
        return loc;
    }


}

