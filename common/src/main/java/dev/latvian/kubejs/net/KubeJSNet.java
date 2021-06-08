package dev.latvian.kubejs.net;

import dev.architectury.networking.NetworkChannel;
import dev.latvian.kubejs.KubeJS;
import net.minecraft.resources.ResourceLocation;

/**
 * @author LatvianModder
 */
public class KubeJSNet {
	public static final NetworkChannel MAIN = NetworkChannel.create(new ResourceLocation(KubeJS.MOD_ID, "main"));

	public static void init() {
		MAIN.register(MessageSendDataFromClient.class, MessageSendDataFromClient::write, MessageSendDataFromClient::new, MessageSendDataFromClient::handle);
		MAIN.register(MessageSendDataFromServer.class, MessageSendDataFromServer::write, MessageSendDataFromServer::new, MessageSendDataFromServer::handle);
		MAIN.register(MessageOpenOverlay.class, MessageOpenOverlay::write, MessageOpenOverlay::new, MessageOpenOverlay::handle);
		MAIN.register(MessageCloseOverlay.class, MessageCloseOverlay::write, MessageCloseOverlay::new, MessageCloseOverlay::handle);
	}
}