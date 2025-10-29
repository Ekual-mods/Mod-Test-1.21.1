package net.ekual.testmod.item;

import net.ekual.testmod.TestMod;
import net.ekual.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ECHO_ITEMS_TAB = CREATIVE_MODE_TABS.register("echo_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ECHOVIUM.get()))
                    .title(Component.translatable("creativetab.testmod.echo_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ECHO_GEM.get());
                        output.accept(ModBlocks.ECHO_GEM_BLOCK.get());
                        output.accept(ModItems.ECHOVIUM.get());
                        output.accept(ModBlocks.ECHOVIUM_BLOCK.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> ECHO_GEAR_TAB = CREATIVE_MODE_TABS.register("echo_gear_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ECHO_GEM.get()))
                    .withTabsBefore(ECHO_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.testmod.echo_gear"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ECHOVIUM.get());
                        output.accept(ModItems.ECHO_GEM.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
