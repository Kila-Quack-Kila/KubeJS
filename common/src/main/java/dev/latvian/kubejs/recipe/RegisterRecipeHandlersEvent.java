package dev.latvian.kubejs.recipe;

import dev.architectury.annotations.ForgeEvent;
import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import dev.architectury.registry.registries.Registries;
import dev.latvian.kubejs.KubeJS;
import dev.latvian.kubejs.KubeJSRegistries;
import dev.latvian.kubejs.recipe.minecraft.ShapedRecipeJS;
import dev.latvian.kubejs.recipe.minecraft.ShapelessRecipeJS;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author LatvianModder
 */
@ForgeEvent
public class RegisterRecipeHandlersEvent {
	public static final Event<Consumer<RegisterRecipeHandlersEvent>> EVENT = EventFactory.createConsumerLoop(RegisterRecipeHandlersEvent.class);
	private final Map<ResourceLocation, RecipeTypeJS> map;

	public RegisterRecipeHandlersEvent(Map<ResourceLocation, RecipeTypeJS> m) {
		map = m;
	}

	public void register(RecipeTypeJS type) {
		map.put(Registries.getId(type.serializer, Registry.RECIPE_SERIALIZER_REGISTRY), type);
		KubeJS.LOGGER.info("Registered custom recipe handler for type " + type);
	}

	public void register(ResourceLocation id, Supplier<RecipeJS> f) {
		register(new RecipeTypeJS(Objects.requireNonNull(KubeJSRegistries.recipeSerializers().get(id), "Cannot find recipe serializer: " + id), f));
	}

	public void register(String id, Supplier<RecipeJS> f) {
		register(new ResourceLocation(id), f);
	}

	public void ignore(ResourceLocation id) {
		register(new IgnoredRecipeTypeJS(Objects.requireNonNull(KubeJSRegistries.recipeSerializers().get(id), "Cannot find recipe serializer: " + id)));
	}

	public void ignore(String id) {
		ignore(new ResourceLocation(id));
	}

	public void registerShaped(ResourceLocation id) {
		register(id, ShapedRecipeJS::new);
	}

	public void registerShapeless(ResourceLocation id) {
		register(id, ShapelessRecipeJS::new);
	}
}