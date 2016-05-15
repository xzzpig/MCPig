package com.github.xzzpig.mcpig;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.xzzpig.mcpig.listener.TCPListener;
import com.github.xzzpig.pigapi.bukkit.TString;
import com.github.xzzpig.pigapi.event.Event;
import com.github.xzzpig.pigapi.tcp.Server;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info(getName() + getDescription().getVersion() + "插件已被加载");
		saveDefaultConfig();
		
		if(Vars.enable_tcp){
			try {
				Vars.server = new Server(10727);
				TString.Print("[MCPig]TCP服务器已启动");
				Event.registListener(new TCPListener());
			} catch (Exception e) {
				e.printStackTrace();
				TString.Print("[MCPig]TCP服务器启动失败");
			}
		}
	}
	
	// 插件停用函数
	@Override
	public void onDisable() {
		if(Vars.enable_tcp){
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
}
