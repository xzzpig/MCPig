package com.github.xzzpig.mcpig;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.xzzpig.mcpig.commands.Command_RunClass;
import com.github.xzzpig.mcpig.listener.TCPListener;
import com.github.xzzpig.pigapi.Debuger;
import com.github.xzzpig.pigapi.TClass;
import com.github.xzzpig.pigapi.bukkit.TString;
import com.github.xzzpig.pigapi.event.Event;
import com.github.xzzpig.pigapi.tcp.Server;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info(getName() + getDescription().getVersion() + "插件已被加载");
		saveDefaultConfig();

		if (Vars.enable_tcp) {
			try {
				Vars.server = new Server(10727);
				TString.Print("[MCPig]TCP服务器已启动");
				Event.registListener(new TCPListener());
				Debuger.debug = true;
			} catch (Exception e) {
				e.printStackTrace();
				TString.Print("[MCPig]TCP服务器启动失败");
			}
		}
		if (Vars.enable_lib) {
			boolean debug = Debuger.debug;
			Debuger.debug = true;
			TClass.classLoader = getClassLoader();
			TClass.loadClass(getDataFolder().toString() + "/lib");
			TClass.loadJar(getDataFolder().toString() + "/lib");
			Debuger.debug = debug;
			TString.Print("[MCPig]lib已加载完毕");
		}
	}

	// 插件停用函数
	@Override
	public void onDisable() {
		if (Vars.enable_tcp) {
			try {
				Vars.server.ss.close();
				TString.Print("[MCPig]TCP服务器已关闭");
			} catch (Exception e) {
				e.printStackTrace();
				TString.Print("[MCPig]TCP服务器关闭失败");
			}
		}
		getLogger().info(getName() + "插件已被停用 ");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (label.equalsIgnoreCase("runclass") || label.equalsIgnoreCase("rc"))
			return Command_RunClass.run(sender, command, label, args);
		else if (label.equalsIgnoreCase("mcpig") || label.equalsIgnoreCase("mp")){
			sender.sendMessage("[MCPig]命令帮助:");
			sender.sendMessage("/rc [类名] <参数>...   -执行CLASS");
			return true;
		}
			
		return false;
	}
}
