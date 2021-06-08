package dev.latvian.kubejs.script;

import dev.architectury.annotations.ForgeEvent;
import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import dev.latvian.mods.rhino.BaseFunction;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.NativeJavaClass;
import dev.latvian.mods.rhino.Scriptable;
import dev.latvian.mods.rhino.ScriptableObject;
import dev.latvian.mods.rhino.util.DynamicFunction;

import java.util.function.Consumer;

/**
 * @author LatvianModder
 */
@ForgeEvent
public class BindingsEvent {
	public static final Event<Consumer<BindingsEvent>> EVENT = EventFactory.createConsumerLoop(BindingsEvent.class);
	public final ScriptManager manager;
	public final ScriptType type;
	public final Context context;
	public final Scriptable scope;

	public BindingsEvent(ScriptManager m, Context cx, Scriptable s) {
		manager = m;
		type = manager.type;
		context = cx;
		scope = s;
	}

	public ScriptType getType() {
		return type;
	}

	public void add(String name, Object value) {
		ScriptableObject.putProperty(scope, name, Context.javaToJS(value, scope));
	}

	public void addClass(String name, Class<?> clazz) {
		add(name, new NativeJavaClass(scope, clazz));
	}

	public void addFunction(String name, DynamicFunction.Callback callback) {
		add(name, new DynamicFunction(callback));
	}

	public void addFunction(String name, DynamicFunction.Callback callback, Class<?>... types) {
		add(name, new TypedDynamicFunction(callback, types));
	}

	public void addConstant(String name, Object value) {
		add(name, value);
	}

	public void addFunction(String name, BaseFunction function) {
		add(name, function);
	}
}