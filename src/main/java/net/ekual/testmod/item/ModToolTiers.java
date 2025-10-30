package net.ekual.testmod.item;

import net.ekual.testmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier ECHOVIUM = new ForgeTier(2550, 13.0f, 5.0f, 30,
            ModTags.Blocks.NEEDS_ECHOVIUM_TOOL, () -> Ingredient.of(ModItems.ECHOVIUM.get()),
            ModTags.Blocks.INCORRECT_FOR_ECHOVIUM_TOOL);
}
