package dev.latvian.kubejs.loot;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.latvian.kubejs.util.MapJS;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

/**
 * @author LatvianModder
 */
public class LootBuilderPool {
	private NumberProvider rolls = ConstantValue.exactly(1);
	private final JsonArray conditions = new JsonArray();
	private final JsonArray entries = new JsonArray();

	public void toJson(LootEventJS<?> event, JsonArray array) {
		JsonObject json = new JsonObject();
		json.add("rolls", event.gsonConditions.toJsonTree(rolls));

		if (conditions.size() > 0) {
			json.add("conditions", conditions);
		}

		if (entries.size() > 0) {
			json.add("entries", entries);
		}

		array.add(json);
	}

	public void setRolls(float r) {
		rolls = ConstantValue.exactly(r);
	}

	public void setUniformRolls(float min, float max) {
		rolls = UniformGenerator.between(min, max);
	}

	public void setBinomialRolls(int n, float p) {
		rolls = BinomialDistributionGenerator.binomial(n, p);
	}

	public void addCondition(Object o) {
		conditions.add(MapJS.json(o));
	}

	public void addEntry(Object o) {
		entries.add(MapJS.json(o));
	}

	public void addItem(ResourceLocation item) {
		JsonObject json = new JsonObject();
		json.addProperty("type", "minecraft:item");
		json.addProperty("name", item.toString());
		addEntry(json);
	}
}
