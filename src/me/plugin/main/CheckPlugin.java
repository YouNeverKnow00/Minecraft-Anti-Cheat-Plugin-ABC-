package me.plugin.main;

import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.BLUE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CheckPlugin {

	public static void checkPlugin(String IP, Player player) throws Exception {
        if (!IP.equals("open")) {
          try {
        	  /*I REMOVE MY LINK ADD YOUR NEW LINK FOR LICENSE*/
              if(readUrl("YOUR LINK").contains("pass")) {
            	  Main.iplisans2 = 1;
            	  Main.ftplisans = 1;
            	  Main.lisans = 1;
              }else{
            	Main.iplisans2 = 0;
      			Main.lisans = 0;
      				Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
      				Bukkit.getConsoleSender().sendMessage(Main.pluginame + "§6Warning!");
    				Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
    				Bukkit.getConsoleSender().sendMessage(Main.pluginame + "§cEklenti lisansi dogrulanamadi...");
    				Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
    				Bukkit.getConsoleSender().sendMessage(Main.pluginame + "§9Info:");
    				Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
    				Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
                 }
              }
            catch(IOException ex) {
              ex.printStackTrace();
            }
        }
    }

    private static String readUrl(String url2) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(url2);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if (reader != null) reader.close();
        }
    }
	
}
