package dev.latvian.kubejs.item.custom;

import dev.latvian.kubejs.item.ItemBuilder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class ArmorItemJS extends ArmorItem {
	public ArmorItemJS(ItemBuilder builder, EquipmentSlot equipmentSlot) {
		super(builder.armorTier, equipmentSlot, builder.createItemProperties());
	}
}
