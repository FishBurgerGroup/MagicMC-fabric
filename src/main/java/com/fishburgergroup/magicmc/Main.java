package com.fishburgergroup.magicmc;

import com.fishburgergroup.magicmc.items.SpellItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	//register("iron_golem", EntityType.Builder.create(IronGolemEntity::new, SpawnGroup.MISC).setDimensions(1.4F, 2.7F).maxTrackingRange(10));
	//
	/*private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
		return (EntityType)Registry.register(Registry.ENTITY_TYPE, id, type.build(id));
	}*/

	public static final EntityType<SpellEntity> SPELL = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("magicmc", "spell"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SpellEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.6f)).build()
	);
	public static final SpellItem SPELL_SPAWN_EGG = new SpellItem(SPELL , 12895428, 11382189, new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		FabricDefaultAttributeRegistry.register(SPELL, SpellEntity.createMobAttributes());
		Registry.register(Registry.ITEM, new Identifier("magicmc", "spellitem"), SPELL_SPAWN_EGG);

	}

}
