package com.github.xzzpig.mcpig.listener;

import com.github.xzzpig.mcpig.Debuger;
import com.github.xzzpig.pigapi.TData;
import com.github.xzzpig.pigapi.bukkit.MD5;
import com.github.xzzpig.pigapi.customevent.ClientConnectEvent;
import com.github.xzzpig.pigapi.customevent.ServerDataReachEvent;
import com.github.xzzpig.pigapi.event.EventHandler;
import com.github.xzzpig.pigapi.event.Listener;

public class TCPListener implements Listener {
	@EventHandler
	public void onServerDataReach(ServerDataReachEvent event) {
		Debuger.print(event.getClient().s.getInetAddress().getHostName()
				+ ":\n" + event.getData());
	}

	@EventHandler
	public void onClientLink(ClientConnectEvent event) {
		event.getClient().data.setString("key",
				MD5.GetMD5Code(event.getClient().toString()));
		event.getClient().sendData(
				new TData().setString("action", "key").setString("key",
						MD5.GetMD5Code(event.getClient().toString())));
	}
}
