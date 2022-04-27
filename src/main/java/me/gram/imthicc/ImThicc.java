package me.gram.imthicc;
import jdk.tools.jmod.Main;
import me.gram.imthicc.Homes.Home;
import me.gram.imthicc.Homes.LocationManager;
import me.gram.imthicc.Homes.SpawnCMD;
import me.gram.imthicc.Homes.setSpawn;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class ImThicc  extends JavaPlugin{
    public static ImThicc main;
    public static int lobbycd = 16;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new invisibility(), this);
        main = this;
        registerEvents();
        registerCommand();
        System.out.println("Spawn works");



    }


    @Override
    public void onDisable() {

    }

    private void registerEvents(){

        PluginManager pm = Bukkit.getPluginManager();
    }
    private void registerCommand(){
        getCommand("setspawn").setExecutor(new setSpawn());
        getCommand("spawn").setExecutor(new SpawnCMD());
    }
}


