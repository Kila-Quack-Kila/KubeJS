package dev.latvian.kubejs.integration.rei;

import dev.latvian.kubejs.event.EventJS;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.CollectionUtils;

import java.util.Collection;
import java.util.Set;

public class YeetREICategoryEventJS extends EventJS {
	private final Set<CategoryIdentifier<?>> categoriesYeeted;

	public YeetREICategoryEventJS(Set<CategoryIdentifier<?>> categoriesYeeted) {
		this.categoriesYeeted = categoriesYeeted;
	}

	public Collection<String> getCategories() {
		return CollectionUtils.map(CategoryRegistry.getInstance(), category -> category.getIdentifier().toString());
	}

	public void yeet(String categoryToYeet) {
		yeet(new String[]{categoryToYeet});
	}

	public void yeet(String[] categoriesToYeet) {
		for (String toYeet : categoriesToYeet) {
			categoriesYeeted.add(CategoryIdentifier.of(toYeet));
		}
	}
}
