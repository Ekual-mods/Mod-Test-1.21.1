package net.ekual.testmod.event;

import net.ekual.testmod.TestMod;
import net.ekual.testmod.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID)
public class EchoviumBonusDamageHandler {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }

        LivingEntity target = event.getEntity();
        ItemStack heldItem = player.getMainHandItem();

        // Check if the player is holding an Echovium weapon
        if (heldItem.is(ModItems.ECHOVIUM_SWORD.get()) ||
                heldItem.is(ModItems.ECHOVIUM_AXE.get()) ||
                heldItem.is(ModItems.ECHOVIUM_PICKAXE.get()) ||
                heldItem.is(ModItems.ECHOVIUM_SHOVEL.get()) ||
                heldItem.is(ModItems.ECHOVIUM_HOE.get())) {

            // TEMP: only for Wardens (will change to tag later)
            if (target.getType() == EntityType.WARDEN) {
                float baseDamage = 0f;

                if (heldItem.is(ModItems.ECHOVIUM_SWORD.get())) {
                    baseDamage = 10f;
                } else if (heldItem.is(ModItems.ECHOVIUM_AXE.get())) {
                    baseDamage = 12f;
                } else if (heldItem.is(ModItems.ECHOVIUM_PICKAXE.get())) {
                    baseDamage = 7f;
                } else if (heldItem.is(ModItems.ECHOVIUM_SHOVEL.get())) {
                    baseDamage = 7.5f;
                } else if (heldItem.is(ModItems.ECHOVIUM_HOE.get())) {
                    baseDamage = 2f;
                }
                float bonus = baseDamage * 2.5f;
                event.setAmount(event.getAmount() + bonus);

                TestMod.LOGGER.info("Echovium bonus applied! +{} damage to Warden", bonus);
            }
        }
    }
}
