package com.github.xzzpig.mcpig.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.github.xzzpig.pigapi.TClass;
import com.github.xzzpig.pigapi.TData;

public class Command_RunClass {

	public static boolean run(CommandSender sender, Command command,
			String label, String[] args) {
		if(args.length == 0){
			sender.sendMessage("[MCPig]参数错误:/rc [类名] <参数>...");
			return true;
		}
		if(!(sender.hasPermission("runclass.*")||sender.hasPermission("runclass."+args[0]))){
			sender.sendMessage("[MCPig]"+ChatColor.RED+"你没有权限:runclass.*或runclass."+args[0]);
			return true;
			
		}
		TData data = new TData().setObject("from", sender).setString("command", label).setString("class", args[0]).setObject("args",args);
		TClass.run(args[0], data);
		return true;
	}

}
