package com.github.xzzpig.mcpig.listener;

import com.github.xzzpig.mcpig.Debuger;
import com.github.xzzpig.pigapi.customevent.ServerDataReachEvent;
import com.github.xzzpig.pigapi.event.EventHandler;
import com.github.xzzpig.pigapi.event.Listener;

public class TCPListener implements Listener {
	@EventHandler
	public void onServerDataReach(ServerDataReachEvent event){
		Debuger.print(event.getClient().s.getInetAddress().getHostName()+":\n"+event.getData());
	}
}
