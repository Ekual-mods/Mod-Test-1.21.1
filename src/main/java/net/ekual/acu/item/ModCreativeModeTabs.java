/**
 * Ancient City Update
 *
 * @author: Corbin Webber
 * @version: 0.1
 *
 * This program adds custom tabs to the Creative Mode inventory inside the game
 *
 * It also lets me define which items go in which tab
 */

package net.ekual.acu.item;

import net.ekual.acu.ACU;
import net.ekual.acu.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ACU.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ECHO_ITEMS_TAB = CREATIVE_MODE_TABS.register("echo_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ECHOVIUM.get()))
                    .title(Component.translatable("creativetab.acu.echo_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ECHO_GEM.get());
                        output.accept(ModBlocks.ECHO_GEM_BLOCK.get());
                        output.accept(ModItems.ECHOVIUM.get());
                        output.accept(ModBlocks.ECHOVIUM_BLOCK.get());
                        output.accept(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> ECHO_GEAR_TAB = CREATIVE_MODE_TABS.register("echo_gear_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ECHO_GEM.get()))
                    .withTabsBefore(ECHO_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.acu.echo_gear"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ECHOVIUM_SHOVEL.get());
                        output.accept(ModItems.ECHOVIUM_PICKAXE.get());
                        output.accept(ModItems.ECHOVIUM_AXE.get());
                        output.accept(ModItems.ECHOVIUM_HOE.get());
                        output.accept(ModItems.ECHOVIUM_SWORD.get());

                        output.accept(ModItems.ECHOVIUM_HELMET.get());
                        output.accept(ModItems.ECHOVIUM_CHESTPLATE.get());
                        output.accept(ModItems.ECHOVIUM_LEGGINGS.get());
                        output.accept(ModItems.ECHOVIUM_BOOTS.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
