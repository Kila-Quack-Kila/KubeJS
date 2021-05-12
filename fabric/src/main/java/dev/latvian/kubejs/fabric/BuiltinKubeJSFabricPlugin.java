package dev.latvian.kubejs.fabric;

import dev.latvian.kubejs.BuiltinKubeJSPlugin;
import dev.latvian.kubejs.script.ScriptType;
import dev.latvian.kubejs.util.ClassFilter;

public class BuiltinKubeJSFabricPlugin extends BuiltinKubeJSPlugin {
	@Override
	public void addClasses(ScriptType type, ClassFilter filter) {
		super.addClasses(type, filter);

		filter.allow("net.fabricmc");
		filter.deny("net.fabricmc.accesswidener");
		filter.deny("net.fabricmc.devlaunchinjector");
		filter.deny("net.fabricmc.loader");
		filter.deny("net.fabricmc.tinyremapper");

		filter.deny("com.chocohead.mm"); // Manningham Mills
	}
}
