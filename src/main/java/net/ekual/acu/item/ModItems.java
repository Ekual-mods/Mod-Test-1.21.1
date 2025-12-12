/**
 * Ancient City Update
 *
 * @author: Corbin Webber
 * @version: 0.1
 *
 * This program defines and registers various custom items and tools into the game
 * such as armor, tools/weapons, and the Echovium Upgrade Smithing Template
 *
 * It also adds customization to the smithing table for use with Echovium
 */

package net.ekual.acu.item;

import net.ekual.acu.ACU;
import net.ekual.acu.item.custom.ModArmorItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ACU.MOD_ID);

    public static final RegistryObject<Item> ECHOVIUM = ITEMS.register("echovium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ECHO_GEM = ITEMS.register("echo_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ECHOVIUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("echovium_upgrade_smithing_template",
            () -> new SmithingTemplateItem(Component.translatable("item.acu.echovium_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.acu.echovium_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
                    Component.translatable("item.acu.echovium_upgrade.title").withStyle(ChatFormatting.GRAY),
                    Component.translatable("item.acu.echovium_upgrade.base_slot_description"),
                    Component.translatable("item.acu.echovium_upgrade.additions_slot_description"),
                    createEchoviumUpgradeEmptyBaseSlotTextures(),
                    createEchoviumUpgradeEmptyAdditionsSlotTextures()
            ));

    private static List<ResourceLocation> createEchoviumUpgradeEmptyBaseSlotTextures() {
        return List.of(
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_axe")
        );
    }

    private static List<ResourceLocation> createEchoviumUpgradeEmptyAdditionsSlotTextures() {
        return List.of(
                ResourceLocation.fromNamespaceAndPath(ACU.MOD_ID, "item/empty_slot_echovium")
        );
    }

    public static final RegistryObject<Item> ECHOVIUM_SWORD = ITEMS.register("echovium_sword",
            () -> new SwordItem(ModToolTiers.ECHOVIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ECHOVIUM, 4, -2.2f))));
    public static final RegistryObject<Item> ECHOVIUM_PICKAXE = ITEMS.register("echovium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ECHOVIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ECHOVIUM, 1, -2.8f))));
    public static final RegistryObject<Item> ECHOVIUM_SHOVEL = ITEMS.register("echovium_shovel",
            () -> new ShovelItem(ModToolTiers.ECHOVIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ECHOVIUM, 1.5f, -3.0f))));
    public static final RegistryObject<Item> ECHOVIUM_AXE = ITEMS.register("echovium_axe",
            () -> new AxeItem(ModToolTiers.ECHOVIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ECHOVIUM, 6, -2.8f))));
    public static final RegistryObject<Item> ECHOVIUM_HOE = ITEMS.register("echovium_hoe",
            () -> new HoeItem(ModToolTiers.ECHOVIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ECHOVIUM, -4, 1f))));

    public static final RegistryObject<Item> ECHOVIUM_HELMET = ITEMS.register("echovium_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ECHOVIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(47))));
    public static final RegistryObject<Item> ECHOVIUM_CHESTPLATE = ITEMS.register("echovium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ECHOVIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(47))));
    public static final RegistryObject<Item> ECHOVIUM_LEGGINGS = ITEMS.register("echovium_leggings",
            () -> new ArmorItem(ModArmorMaterials.ECHOVIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(47))));
    public static final RegistryObject<Item> ECHOVIUM_BOOTS = ITEMS.register("echovium_boots",
            () -> new ArmorItem(ModArmorMaterials.ECHOVIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(47))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
