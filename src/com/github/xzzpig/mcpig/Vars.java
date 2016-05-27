package com.github.xzzpig.mcpig;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.xzzpig.pigapi.bukkit.TConfig;
import com.github.xzzpig.pigapi.tcp.Server;

public class Vars {
	public static FileConfiguration config = TConfig.getConfigFile("MCPig",
			"config.yml");

	public static boolean enable_tcp = config.getBoolean("mcpig.enable.tcp",
			true);
	public static boolean enable_lib = config.getBoolean("mcpig.enable.lib",
			true);

	public static Server server;
}
