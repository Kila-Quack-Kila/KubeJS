package dev.latvian.kubejs.player;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import dev.latvian.kubejs.script.AttachDataEvent;
import dev.latvian.kubejs.script.DataType;

import java.util.function.Consumer;

/**
 * @author LatvianModder
 */
public class AttachPlayerDataEvent extends AttachDataEvent<PlayerDataJS> {
	public static final Event<Consumer<AttachPlayerDataEvent>> EVENT = EventFactory.createConsumerLoop(AttachPlayerDataEvent.class);

	public AttachPlayerDataEvent(PlayerDataJS p) {
		super(DataType.PLAYER, p);
	}
}