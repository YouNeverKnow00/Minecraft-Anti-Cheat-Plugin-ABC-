package me.plugin.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import AntiBot.CheckProxy;
import me.plugin.Event.BlockInteract;
import me.plugin.Event.ChatListener;
import me.plugin.Event.CombatListener;
import me.plugin.Event.CommandEvent;
import me.plugin.Event.JoinLeaveListener;
import me.plugin.Event.MoveListener;
import me.plugin.Event.PlayerListener;
import me.plugin.Event.TPBow;
import me.plugin.anticheat.gui.AntiCheatGui;
import me.plugin.anticheat.gui.AntiCheatGuiCommand;
import me.plugin.anticheat.gui.CheckGui;
import me.plugin.anticheat.gui.checkmenu.CombatGui;
import me.plugin.checks.CheckResult;
import me.plugin.commands.ChatColorCommands;
import me.plugin.commands.CommandBlocker;
// Simdilik kapali import me.plugin.commands.CommandBlocker;
import me.plugin.commands.CommandLogger;
import me.plugin.commands.DebugCommand;
import me.plugin.commands.StaffChatCommands;
import me.plugin.commands.WaitCommand;
import me.plugin.commands.CommandEffect.CommandEffect;
import me.plugin.funcommands.AdminSword;
import me.plugin.funcommands.Spawn;
import me.plugin.funcommands.Toggle;
import me.plugin.funcommands.Toggle2_TPBOW;
import me.plugin.oyuncueventleri.OyuncuEventler;
import me.plugin.sistem.PanicSystem;
import me.plugin.util.Settings;
import me.plugin.util.User;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import static org.bukkit.ChatColor.*;

public class Main extends JavaPlugin implements Listener {

	
	// --------------------------------------------------------------------------------------------
	//                   AntiBug
	//  Coder Discord: Emree#2023          
	//  Started: 21.03.2019 
	// --------------------------------------------------------------------------------------------
	
	/** Lisans Kayıt 2 Aşamalı **/

	// 1 Aşama Port lisans
	public static int port = 39704;
	
	// 2 Aşama Ip Lisans
	
	public static String ipadress = "127.0.0.1";

	// 3 Aşama Lisans kodu
	
	public static int lisanskey = 610625658;
	
	public static String sunucuadi = "antibug";
	
	/** **/
	
	private static Main instance;
	
	// Plugin adi
	public static String pluginame = "§f[§2§lAnti§a§lBug§f] §b > ";
	
	// /ab yazınca cikan mesaj pl adi 
	
	public static String abname = "§f[§2§lAnti§a§lBug§f]";
	
	public static String pluginname_anticheatname = "§f[§2§lA§a§lB§3§lC§f] ";
	
	public static String staffchatprefix = "§f[§2§lAnti§a§lBug§f] §f§l<§5§lStaff §8§l| §d§lChat§f§l> ";
 
	// Reloded Mesajı
	
	public static String reloaded = "§aEklenti başarıyla yenilendi!";
	
	// AntiCheat Mesajları
	
	public static String anticheaton = "§6§lAnti§e§lCheat §abasariyla etkin!";
	
	public static String anticheatoff = "§5§lAnti§d§lCheat §cdevredisi!";
	
	// Chat color ve Renk listesi
	
	public static String chatcoloruse = "§5Kullanabileceğin §drenkler:";
	
	public static String chatcolorlist = "§cred, §eyellow, §9blue, §baqua, §agreen, §fRESET";
	
	public static String chatcolorred = "§cRED §7yazı rengini seçtin!";
	
	public static String chatcoloryellow = "§eYELLOW §7yazı rengini seçtin!";
	
	public static String chatcolorblue = "§9BLUE §7yazı rengini seçtin!";
	
	public static String chatcoloraqua = "§bAQUA §7yazı rengini seçtin!";
	
	public static String chatcolorgreen = "§aGREEN §7yazı rengini seçtin!";
	
	public static String chatcolorreset = "§7Yazı rengini §fRESET §7ledin!";
	
	// Staff Chat kullanim Mesajlari
	
	public static String staffchatkullanim = "§c/staffchat <§emessage§c>";
	
	// Fun Menu
	
	/** Sword ismi **/
	
	public static String adminsword = "AdminSword";
	
	/** Admin Sword Komutunu başarıyla gerçekleşince çıkan yazı **/
	
	public static String adminswordkomutunuyazinca = "§eBaşarıyla §aAdminSword §eKılıcını Aldın!";

	/** Sword Loreleri **/
	
	public static String adminswordlore1 = "§bAdmin Kılıcı";
	
	public static String adminswordlore2 = "§3Not: §b§nEğer bu kılıcı yetkili dışında biri kullandığını görürsen hemen yetkililere bildir!";
	
	/** Spawnlanınca Çıkan Mesaj **/
	
	public static String spawntroll = "§2Mob başarıyla §aspawnlandı!";
	
	/** abSpawnKullanımı çıkan mesaj **/

	public static String spawnuse = "§2Kullanımı: §a/abspawn §b[MOB_NAME]";
	
	/** Spawnlanabilen mob listesi **/
	
	public static String spawnlist = "§9MOB LIST: \n§aZombie, §7Skeleton, §2Creeper, §8Spider, §fGhast, §0EnderDragon";
	
	/** Toggle Mesajları **/
	
	public static String toggleaktif = " §a§nAktif §eedildi!";
	
	public static String toggledevredisi = " §c§nDeaktif §eedildi!";
	
	/** Gravity Block Rod lore**/
	
	public static String gravityropelore1 = "§6Gravity...";
	
	public static String gravityropelore2 = "§eSopaya sağ tıkla ve olacakları izle :)";
	
	/** Blaze Rop ismi (GravityBlock eşyası) **/
	
	public static String gravityropename = "§7§lGravity§8§lBlock";
	
	/** Bow TP Kullanım Mesajı **/
	
	public static String bowtpuse = "§3Kullanımı: §b/abtpbow §b<§bon§b/§3off§b>";
	
	/** Açık kapalı mesajları **/
	
	public static String bowtpaktif = " §a§nAktif §eedildi!";
	
	public static String bowtpdeaktif = " §c§nDeaktif §eedildi!";
	
	/** BowTP Uyarı **/
	
	public static String bowtpaktifuyari = "§c§lUyarı " + "\n" + Main.pluginame + "§eAktif ederseniz oyuncular bunu kullanabilir!" ;
	
	public static String bowtpaktifuyari2 = "§6Bu sistem §b§nBETA §6aşamasında buglar oluşabilir." ;
	
	/** TPBow Adı **/
	
	public static String bowtpname = "§5§lTP§d§lBow ";
	
	/** TPBow Ok adı **/
	
	public static String arrowtpname = "§eArrow";
	
	/** TPBow Loreleri **/
	
	public static String tpbowlore1 = "§3TPBow...";
	
	public static String tpbowlore2 = "§bOk atarak gezmeyi denedinmi hiç?";
	
	/** Tpbow Zaten Aktif olma Deaktif olma Mesajları **/
	
	public static String tpbowzatenaktif = " §czaten §a§nAktif!";
	
	public static String tpbowzatendeaktif = " §czaten §c§nDeaktif!";
	
	// Command Logger kullanim mesaji
	
	public static String CommandloggerKullanimi = "§6Kullanımı §e/abcommandlogger §e<§aon§e/§coff§e>";

	public static String CommandloggerAcik = "§6CommandLogger: §a§lEtkin! \n§e§nArtık Oyuncuların komutlarını görebilirsin!";
	
	public static String CommandloggerKapali = "§6CommandLogger: §c§lDevredışı! \n§e§nArtık Oyuncuların komutlarını göremezsin!";
	
	public static String commandlogger_log = " §badlı oyuncu bu komutu kullandı! §d";
	
	//Yetkin yok mesaji
	public static String yetkinyok = "§cBunun için yetkin yok :(";
	
	/// Gerekliler ///

    public int timer;
	
	private static Main m;
	
	public static String buglu2nokta = "§3Ne yapmaya çalışıyorsun?";
	
	public List<String> toggleList = new ArrayList<String>();
	
	public ArrayList<Player> cmdplayers = new ArrayList<>();
	
	public static Main chatcolor;
	
	Boolean isEnabledAntiCheat;
	Boolean isEnabledChatColor;
	Boolean isEnabledBugluKomutEngelleyici;
	Boolean isEnabledNoProxy;
	
	// Command Effect Sistemi
	
	/** Kullanım mesaji **/
	
	public static String commandeffectuse = "§8Kullanımı: §7/effect §7<§eeffect_name§7>";
	
	/** Command Effect Listesi **/
	
	public static String commandeffectlist = "§aEFFECT LIST: \n§dTP";
	
	/** Effect başarıyla uygulandığında çıkan mesaj **/
	
	public static String commandeffectuygulandi = "§2§nEffect §abaşarıyla uygulandı!";
	
	
	// Yeni (Yakında Güvenlik Sistemi)
	
	public static String panicmodkullanım = "§cKullanımı §e/abpanic §e<§aon§e/§coff§e>";
	
	/** Uyarı Mesajı **/
	
	public static String panicmoduyari = "§4§lDikkat!!! \n§e§lEğer Panik modunu aktif ederseniz sunucunuz tüm sistemleri kapatılacaktır!";
	
	/** Aktif olma ve Deaktif olma Mesajları **/
	
	public static String panicmodaktif = "§bPanik modu §a§nAktif §bedildi!";
	
	public static String panicmoddeaktif = "§dPanik modu §c§nDeaktif §dedildi!";
	
	/** Zaten Aktif olma Deaktif olma Mesajları **/
	
	public static String panicmodzatenaktif = "§cPanik modu zaten §a§nAktif!";
	
	public static String panicmodzatendeaktif = "§cPanik modu zaten §c§nDeaktif!";
	
	
	
	
	
	/** Chat kapalı iken mesaj yazarsa çıkan mesaj**/
	
	public static String panicmodchatkapali = "§6Panik modu açık!" + "\n" + Main.pluginame + "§eSohbet kapalı!";
	
	/** Panic modu acik iken blok kırmaya calisirsa cikan mesaj**/

	public static String panicmodblokkirmakapali = "§3Panik modu açık!" + "\n" + Main.pluginame + "§bBlok kıramazsın!";
	
	/** Panic modu acik iken blok koymaya calisirsa cikan mesaj**/
	
	public static String panicmodblokkoymakapali = "§5Panik modu açık!" + "\n" + Main.pluginame + "§dBlok koyamazsın!";
			
			
			
			
	
	// Bos sadece duruyor spawn.java(class ında kullanıyoz)
	
	public static String bosstring = Main.pluginame + "";
	
	// Sadece Oyuncu Kullanabilir Mesaji
	
	public static String bukomutsadeceoyuncukullanabilir = "§cBu komutu sadece oyun içinden kullanabilirsin!";
	
	public static int ftplisans = 0;
	
	public static int lisans = 0;
	
	public static int bugkomutengelleme = 0;
	
	public static int proxyengel = 0;
	
	public static int iplisans2 = 0;
	
	public static HashMap<UUID, User> USERS = new HashMap<>();
	
	//§ renk kodu icin
	
	public void lisanssystem(){
	
	if(iplisans2 == 1){
		if(getConfig().getInt("Lisans") == lisanskey){
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "§aEklenti Lisansi basariyla dogrulandi!");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
			lisans = 1;
		}else{
			lisans = 0;
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "§6Warning!");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "§cEklenti lisansi dogrulanamadi...");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "§9Info:");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
			Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
		}
	 }else{
			lisans = 0;
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

	// Acilis mesaji
	public void onEnable(){
    ipLisans();
	lisanssystem();
	onConfig();
	Bukkit.getPluginManager().registerEvents(this, this);
	if(lisans == 1){
		m = this;
		Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
		Bukkit.getConsoleSender().sendMessage(Main.pluginame + " §eAktif!");
		Bukkit.getConsoleSender().sendMessage(Main.pluginame + "");
		// bazı fonksiyonlar
		TrueFalseSistemi();
		ProxyEngellemeSystem();
		AntiCheatOnOffSystem();
		ChatColorOnOffSystem();
		BugluKomutdenemeSystem();
		acilmamesaji();
		
		// Kisayol
		
		
		// Effect komut listesi
		getCommand("abeffect").setExecutor(new CommandEffect());
		
		//Gravity
		
		getCommand("abgravityblock").setExecutor(new Toggle(this));
		
		// Komut listesi 
		getCommand("abmov").setExecutor(new WaitCommand());
		getCommand("abc").setExecutor(new AntiCheatGuiCommand());
		getCommand("abtpbow").setExecutor(new Toggle2_TPBOW());
		getCommand("abspawn").setExecutor(new Spawn());
		getCommand("abpanic").setExecutor(new PanicSystem());
		getCommand("abstaffchat").setExecutor(new StaffChatCommands());
		getCommand("abcommandlogger").setExecutor(new CommandLogger());
		getCommand("abadminsword").setExecutor(new AdminSword());
		getCommand("abdebug").setExecutor(new DebugCommand());
		
		// Event Listesi
		
		Bukkit.getPluginManager().registerEvents(new CommandBlocker(), this);
		
		Bukkit.getPluginManager().registerEvents(new TPBow(), this);
		Bukkit.getPluginManager().registerEvents(new OyuncuEventler(), this);
		Bukkit.getPluginManager().registerEvents(new CommandEvent(), this);
		Bukkit.getPluginManager().registerEvents(new BlockInteract(this), this);
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§8-*-*-*-§9Check§bList§8-*-*-*-");
		// Anti Hile acik ise
		if(isEnabledAntiCheat){
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("    §6§lAnti§e§lCheat§7: §a§nAktif!");
		}else{
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("    §6§lAnti§e§lCheat§7: §c§nDevredisi!");
		}
		// Komut engelleyici acik ise
		if(isEnabledBugluKomutEngelleyici){
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("    §3§lSunucu§b§lGuvenligi§7: §a§nAktif!");
		}else{
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("    §3§lSunucu§b§lGuvenligi§7: §c§nDevredisi!");
		}
		// No Proxy Aktif ise
		if(isEnabledNoProxy){
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("    §7§lNo§8§lProxy§7: §a§nAktif!");
		}else{
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("    §7§lNo§8§lProxy§7: §c§nDevredisi!");
		}
		// Chat Color acik ise
		if(isEnabledChatColor){
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("    §5§lChat§d§lColor§7: §a§nAktif!");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("§8-*-*-*-*-*-*-*-*-*-*-*-");
		}else{
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("    §5§lChat§d§lColor§7: §c§nDevredisi!");
			Bukkit.getConsoleSender().sendMessage("");
			Bukkit.getConsoleSender().sendMessage("§8-*-*-*-*-*-*-*-*-*-*-*-");
		}

		//Chat color system
		
		for (Player p : Bukkit.getOnlinePlayers())
			USERS.put(p.getUniqueId(), new User(p));
		}
	
		
	}

	/*
	 
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
   {
        Player player = event.getPlayer();
        Action action = event.getAction();
    
       if(action.equals(Action.RIGHT_CLICK_BLOCK))
      {
       	if(player.getItemInHand().getTypeId() == 340){
                event.setCancelled(true);
            	player.getPlayer().kickPlayer(DARK_PURPLE.toString() + BOLD + Main.pluginname_anticheatname + RESET.toString() + GRAY + "\n" + "\n" + YELLOW + "Kicked by §f[§2§lAnti§a§lBug§3§lCheat§f]" + "\n" + "\n" + RED + "Modification: " + GRAY + "Crash");	
               System.out.println("Crash engellendi " + "§cBuyusuz kitap");
      	}
                
            if(player.getItemInHand().getTypeId() == 387){ // If player is holding a written book.
           	player.getPlayer().kickPlayer(DARK_PURPLE.toString() + BOLD + Main.pluginname_anticheatname + RESET.toString() + GRAY + "\n" + "\n" + YELLOW + "Kicked by §f[§2§lAnti§a§lBug§3§lCheat§f]" + "\n" + "\n" + RED + "Modification: " + GRAY + "Crash");	
              player.sendMessage(Main.pluginame + " Crash engellendi" + " §aBuyulu kitap");
                event.setCancelled(true);
          }
      }
    }
	
	public void Kitapeditlenme(PlayerEditBookEvent e){
		Player p = e.getPlayer();
		e.setCancelled(true);
		p.sendMessage(Main.pluginame + " Crash engellendi editleme amk cocu");
	}
	
	public void YeniKitapMetaEtiket​(getNewBookMeta e){
		Player p = e.getPlayer();
		e.setCancelled(true);
		p.sendMessage(Main.pluginame + " Crash engellendi");
	}
	
	*/
	
	  @EventHandler
	  	public void onJoin(PlayerJoinEvent e) throws Exception{
		Player oyuncu = e.getPlayer();
		CheckPlugin.checkPlugin(e.getPlayer().getAddress().getAddress().getHostAddress(), e.getPlayer());
		if(iplisans2 == 1){
			oyuncu.sendMessage(getConfig().getString("Giris_Mesaji").replace('&', '§').replace("%oyuncu%", oyuncu.getName()));
			oyuncu.sendMessage(getConfig().getString("Giris_Mesaji2").replace('&', '§').replace("%oyuncu%", oyuncu.getName()));
		}else{
			lisans = 0;
		    oyuncu.sendMessage("");
			oyuncu.sendMessage(YELLOW.toString() + BOLD + "Bu plugin lisanslanmamış lütfen plugini lisansı doğrulayıp tekrar deneyiniz...");
			oyuncu.sendMessage(Main.pluginame);
			oyuncu.sendMessage("");
			oyuncu.sendMessage(Main.pluginame + RED.toString() + BOLD + "Uyari!");
			oyuncu.sendMessage("");
		}
		if(proxyengel == 1){
			CheckProxy.checkProxy(e.getPlayer().getAddress().getAddress().getHostAddress(), e.getPlayer());
		}
		if(isEnabledChatColor){
			Giris();
		}
	  }
	  
	public void ipLisans(){
		if(Bukkit.getServer().getPort() == Main.port){
			iplisans2 = 1;
		}else {
			iplisans2 = 0;
		}
	}
	  
	  
	public void deneme(){
		
	 /* Calisan
		p.sendMessage("Sunucu ipsi " + Bukkit.getServer().getIp() + Bukkit.getServer().getPort());
		
        String serverIp = Bukkit.getServer().getIp();
		InetAddress IP;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
 
 	*/
	}
	  
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
	 if(lisans == 1){
		if(p.hasPermission("antibug.*")){
			if(cmd.getName().equalsIgnoreCase("antibug")){
				if(args.length == 0){
					if(p.hasPermission("antibug.about")){
						p.sendMessage(Bukkit.getServer().getIp().toString());
						p.sendMessage("§8§l❰--------§c§l⚛§8§l------" + Main.abname + "§8§l------§c§l⚛§8§l--------❱");
						p.sendMessage("");
						p.sendMessage(" §dNedir bu antibug?: " + "§eSunucumuz için geliştirdiğimiz çok faksiyonlu plugindir.");
						p.sendMessage("");
						p.sendMessage("");
						p.sendMessage(" §eHataları bildirmek için §9§lDiscord: §bEmree#2023");
						p.sendMessage("");
						p.sendMessage("§8§l❰--------§c§l⚛§8§l------" + Main.abname + "§8§l------§c§l⚛§8§l--------❱");
					}
				}else if(args.length == 1){
					if(p.hasPermission("antibug.admin.check")){
						if(args[0].equalsIgnoreCase("check")){
							p.sendMessage("§8-*-*-*-§9Check§bList§8-*-*-*-");
							// Anti Hile acik ise
							if(isEnabledAntiCheat){
								p.sendMessage("");
								p.sendMessage("    §6§lAnti§e§lCheat§7: §a§nAktif!");
							}else{
								p.sendMessage("");
								p.sendMessage("    §6§lAnti§e§lCheat§7: §c§nDevredışı!");
							}
							// Komut engelleyici acik ise
							if(isEnabledBugluKomutEngelleyici){
								p.sendMessage("");
								p.sendMessage("    §3§lSunucu§b§lGüvenliği§7: §a§nAktif!");
							}else{
								p.sendMessage("");
								p.sendMessage("    §3§lSunucu§b§lGüvenliği§7: §c§nDevredışı!");
							}
							// No Proxy Aktif ise
							if(isEnabledNoProxy){
								p.sendMessage("");
								p.sendMessage("    §7§lNo§8§lProxy§7: §a§nAktif!");
							}else{
								p.sendMessage("");
								p.sendMessage("    §7§lNo§8§lProxy§7: §c§nDevredışı!");
							}
							// Chat Color acik ise
							if(isEnabledChatColor){
								p.sendMessage("");
								p.sendMessage("    §5§lChat§d§lColor§7: §a§nAktif!");
								p.sendMessage("");
								p.sendMessage("§8-*-*-*-*-*-*-*-*-*-*-*-");
							}else{
								p.sendMessage("");
								p.sendMessage("    §5§lChat§d§lColor§7: §c§nDevredışı!");
								p.sendMessage("");
								p.sendMessage("§8-*-*-*-*-*-*-*-*-*-*-*-");
							}
						}
	
					}
				}
			}
		 }
		}else{
			if(lisans == 0);
			    p.sendMessage("");
				p.sendMessage(YELLOW.toString() + BOLD + "Bu plugin lisanslanmamış lütfen plugini lisansı doğrulayıp tekrar deneyiniz...");
				p.sendMessage(Main.pluginame);
				p.sendMessage("");
				p.sendMessage(Main.pluginame + RED.toString() + BOLD + "Uyari!");
				p.sendMessage("");
		}
		return false;
	}

	/*
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
	Entity damager = e.getDamager();
	Entity damageTaker = e.getEntity();

	if (damageTaker instanceof Player) {
	    //DamageTaker is a Player
	    Player taker = (Player) damageTaker;
	    if (damager instanceof Player) {
	    	damageTaker.sendMessage("Hasar aldın");
	    	damager.sendMessage("Adama vurdun");
	        Player damagerPlayer = (Player) damager;
	    }
	 }
	}
	
	@EventHandler
    public void onHit(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            event.setCancelled(true);
        }
    }
	*/
	
	public void acilmamesaji(){
		Bukkit.getConsoleSender().sendMessage(Main.pluginame);
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(Main.pluginame + RED.toString() + BOLD + "Uyari!");
		Bukkit.getConsoleSender().sendMessage("");
	}

		@EventHandler
		public void onPlayerChat(AsyncPlayerChatEvent e){
			infolisans();
			if(isEnabledChatColor){
				 Giris();
			}
			if(ftplisans == 1){
				
			}else{
				Player p = e.getPlayer();
				e.setCancelled(true);
				p.sendMessage(Main.pluginame + "");
				p.sendMessage(Main.pluginame + "§6Warning!");
				p.sendMessage(Main.pluginame + "");
				p.sendMessage(Main.pluginame + "§cEklenti lisansi dogrulanamadi...");
				p.sendMessage(Main.pluginame + "");
				p.sendMessage(Main.pluginame + "§9Info:");
				p.sendMessage(Main.pluginame + "");
				p.sendMessage(Main.pluginame + "");
			}
		}
		 
	public void infolisans(){
		 if(lisans == 0){
			for (Player p : Bukkit.getOnlinePlayers()){
					p.sendMessage(Main.pluginame + "");
					p.sendMessage(Main.pluginame + "§6Warning!");
					p.sendMessage(Main.pluginame + "");
					p.sendMessage(Main.pluginame + "§cEklenti lisansi dogrulanamadi...");
					p.sendMessage(Main.pluginame + "");
					p.sendMessage(Main.pluginame + "§9Info:");
					p.sendMessage(Main.pluginame + "");
					p.sendMessage(Main.pluginame + "");
				}
		    }
	}
		
	public void onConfig(){
		if(!new File(getDataFolder() , "config.yml").exists()){
			saveDefaultConfig();
		}
	}

	  @EventHandler
	  public void onCommand(PlayerCommandPreprocessEvent event)
	  {
         Player player = event.getPlayer();
		 String command = event.getMessage();
		if(iplisans2 == 0){
		  if(ftplisans == 0){
			event.setCancelled(true);
			player.sendMessage(Main.pluginame + "§cUyarı!");
			player.sendMessage(Main.pluginame + "§a");
			player.sendMessage(Main.pluginame + "§dEklentinin lisansı doğrulanamadı.");
			player.sendMessage(Main.pluginame + "§a");
			player.sendMessage(Main.pluginame + "§c");
		}
	    if(bugkomutengelleme == 1){
	      if (command.split(" ")[0].contains(":")) {
        	event.setCancelled(true);
        	player.sendMessage(Main.pluginame + Main.buglu2nokta);
         }
	     }
		}
	  }
	
	public static void log(CheckResult cr, User u){
	    String message = DARK_PURPLE.toString() + BOLD + Main.pluginname_anticheatname + " §b>" + RESET.toString() + " " + RED + u.getPlayer().getName() + GRAY + " " + cr.getLevel().toString().toLowerCase() + " " + Settings.CRINGE + " " + DARK_PURPLE + cr.getType().getName() + GRAY + "; " + cr.getMessage();
		for (Player p : Bukkit.getOnlinePlayers()) 
			if (p.hasPermission(Settings.NOTIFY))
				p.sendMessage(message);
		Bukkit.getConsoleSender().sendMessage(message);
		// Son uyari mesaji suanlik kapali calisiyordu fakat gereksiz :D
		// Eğer uyarı sayısı sınırı geçerse olucaklar
//		if (u.getWarnings(cr.getType()) > Settings.MAX_ENDWARNINGS){
		// Eğer oyuncunun OP(Yetkli) olup olmadığını kontrol ediyoruz.
		//	if(!u.getPlayer().isOp()){
//			u.getPlayer().sendMessage(Main.pluginname_anticheatname + " §6Biraz daha hile kullanmaya devam edersen sunucudan atılacaksın!");
//			}
//		}
		
		if(u.getWarnings(cr.getType()) > Settings.MAX_WARNINGS){
		 if(!u.getPlayer().hasPermission("abc.bypass.kick")){
			for (Player p : Bukkit.getOnlinePlayers())
			p.sendMessage(Main.pluginname_anticheatname + "§7" + u.getPlayer().getName() + " §6Hile kullanımdan dolayı sunucudan atıldı!");
			u.getPlayer().kickPlayer("§8§l❰-------------§c§l⚠§8§l------§f§l[§2§lA§a§lB§3§lC§f§l]§8§l------§c§l⚠§8§l-------------❱" + "\n" + " " + "\n" + 
			"       §dHmmm... Hiç normal değil, neden burdasın?" + "\n" + "" + "\n" + " §6Sunucuda hile kullandığın için atıldın." + "\n" + "" + "\n"
			+ "§cTespit edilen hile: " + "§7" + cr.getType().getName() + "\n"  + " " + "\n" + " §2Lütfen hile kullanmayınız!." + "\n"
			+ " §aAntiHile Sistemimiz §e§nBETA Aşamasındadır" + "\n" + " " + "\n" + "§9Discord: Emree#2023" + "\n" + "" + "\n" +
			"§8§l❰-------------§e§l⚠§8§l------§f§l[§2§lA§a§lB§3§lC§f§l]§8§l------§e§l⚠§8§l-------------❱");
			}
		}
	}
	  
	public static User getUser(Player p){
		return USERS.get(p.getUniqueId());
	}
	
	public static Main getCommandLogger() {
		return m;
	}
	
	  public static Plugin getInstance()
	  {
	    return instance;
	  }
	  
   public static Main getChatColorAPI(){
	   return chatcolor;
   }

   public void Giris(){
		for(Player all : Bukkit.getOnlinePlayers()){
			File data = new File(Bukkit.getPluginManager().getPlugin("AntiBug").getDataFolder() , File.separator + "userdata");
			File f = new File(data, File.separator + all.getName() + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			if(!f.exists()) {
				playerData.set("AntiBugChatColor", "WHITE");
			}
			try {
				playerData.save(f);
			}catch (IOException ex) {
				ex.printStackTrace();
			}

		}
   }
   
   public void TrueFalseSistemi(){
	   isEnabledAntiCheat = getConfig().getBoolean("AntiCheat");
	   isEnabledChatColor = getConfig().getBoolean("ChatColor");
	   isEnabledBugluKomutEngelleyici = getConfig().getBoolean("BugluKomutEngelleyici");
	   isEnabledNoProxy = getConfig().getBoolean("ProxyEngelleyici");
   }
   
   public void AntiCheatOnOffSystem(){
		PluginManager pm = Bukkit.getPluginManager();
	   if(isEnabledAntiCheat){
		   	Bukkit.getConsoleSender().sendMessage(Main.pluginame + " " + "§f[§2§lAnti§a§lBug§3§lCheat§f]" + " basariyla aktif edildi!");
			pm.registerEvents(new JoinLeaveListener(), this);
			pm.registerEvents(new MoveListener(), this);
			pm.registerEvents(new PlayerListener(), this);
			pm.registerEvents(new CombatListener(), this);
			
			// AntiBug Gui
			pm.registerEvents(new AntiCheatGui(null), this);
			pm.registerEvents(new CheckGui(null), this);
			pm.registerEvents(new CombatGui(null), this);
			
			new Cleaner().runTaskTimerAsynchronously(this, Settings.CLEAN_UP_DELAY, Settings.CLEAN_UP_DELAY);
			
	   }
   }
   
   public void ChatColorOnOffSystem(){
	   if(isEnabledChatColor){
		    Giris();
			Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
			getCommand("abcolor").setExecutor(new ChatColorCommands());
	   }
   }
   
   public void BugluKomutdenemeSystem(){
	   if(isEnabledBugluKomutEngelleyici){
		   bugkomutengelleme = 1;
	   }
   }
   
   public void ProxyEngellemeSystem(){
	   if(isEnabledNoProxy){
		   proxyengel = 1;
	   }
   }
   
}
