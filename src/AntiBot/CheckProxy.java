package AntiBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.plugin.main.Main;

public class CheckProxy {

	
	public static void checkProxy(String IP, Player player) throws Exception {
        if (!IP.equals("127.0.0.1")) {
          try {
              if(readUrl("https://proxycheck.io/v2/" + IP).contains("yes")) {
                  player.getPlayer().kickPlayer(Main.pluginame + "\n" + "\n" + ChatColor.DARK_PURPLE + " Proxy kullandığınız tespit edilmiştir." + "\n" + "\n" + ChatColor.AQUA + "Modeminizi yeniden başlatın.");
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
