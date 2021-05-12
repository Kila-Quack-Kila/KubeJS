package dev.latvian.kubejs.item.custom;

import dev.latvian.kubejs.item.ItemBuilder;
import net.minecraft.world.item.ShovelItem;

public class ShovelItemJS extends ShovelItem {
	public ShovelItemJS(ItemBuilder builder) {
		super(builder.toolTier, builder.attackDamageBaseline, builder.attackSpeedBaseline, builder.createItemProperties());
	}
}
