package dev.latvian.kubejs;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Fluid;

import static net.minecraft.core.Registry.*;

public class KubeJSRegistries {
	private static final Registries REGISTRIES = Registries.get(KubeJS.MOD_ID);

	public static Registrar<Block> blocks() {
		return REGISTRIES.get(BLOCK_REGISTRY);
	}

	public static Registrar<BlockEntityType<?>> blockEntities() {
		return REGISTRIES.get(BLOCK_ENTITY_TYPE_REGISTRY);
	}

	public static Registrar<Item> items() {
		return REGISTRIES.get(ITEM_REGISTRY);
	}

	public static Registrar<Fluid> fluids() {
		return REGISTRIES.get(FLUID_REGISTRY);
	}

	public static Registrar<EntityType<?>> entityTypes() {
		return REGISTRIES.get(ENTITY_TYPE_REGISTRY);
	}

	public static Registrar<SoundEvent> soundEvents() {
		return REGISTRIES.get(SOUND_EVENT_REGISTRY);
	}

	public static Registrar<RecipeSerializer<?>> recipeSerializers() {
		return REGISTRIES.get(RECIPE_SERIALIZER_REGISTRY);
	}
}
