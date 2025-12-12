/**
 * Ancient City Update
 *
 * @author: Corbin Webber
 * @version: 0.1
 *
 * This program adds a custom tier to define durability, speed,
 * attack damage, and enchantability as a base for the tools.
 *
 * It also adds custom tags that can be applied to blocks for if
 * an Echovium tool can only be used to break it.
 */

package net.ekual.acu.item;

import net.ekual.acu.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier ECHOVIUM = new ForgeTier(2550, 13.0f, 5.0f, 30,
            ModTags.Blocks.NEEDS_ECHOVIUM_TOOL, () -> Ingredient.of(ModItems.ECHOVIUM.get()),
            ModTags.Blocks.INCORRECT_FOR_ECHOVIUM_TOOL);
}
