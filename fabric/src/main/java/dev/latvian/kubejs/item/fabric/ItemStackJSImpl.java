package dev.latvian.kubejs.item.fabric;

import dev.architectury.registry.block.ToolType;
import dev.latvian.kubejs.item.ItemStackJS;
import dev.latvian.kubejs.player.PlayerJS;
import dev.latvian.kubejs.world.BlockContainerJS;
import org.jetbrains.annotations.Nullable;

public class ItemStackJSImpl {
	public static int _getHarvestLevel(ItemStackJS stack, ToolType tool, @Nullable PlayerJS<?> player, @Nullable BlockContainerJS block) {
		throw new UnsupportedOperationException("Getting harvest level of item is currently unsupported!");
	}
}
