package dev.latvian.kubejs.server;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import dev.latvian.kubejs.script.AttachDataEvent;
import dev.latvian.kubejs.script.DataType;

import java.util.function.Consumer;

/**
 * @author LatvianModder
 */
public class AttachServerDataEvent extends AttachDataEvent<ServerJS> {
	public static final Event<Consumer<AttachServerDataEvent>> EVENT = EventFactory.createConsumerLoop(AttachServerDataEvent.class);

	public AttachServerDataEvent(ServerJS s) {
		super(DataType.SERVER, s);
	}
}