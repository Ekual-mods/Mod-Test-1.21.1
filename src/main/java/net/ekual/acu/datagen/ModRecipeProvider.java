package net.ekual.acu.datagen;

import net.ekual.acu.ACU;
import net.ekual.acu.block.ModBlocks;
import net.ekual.acu.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

//Defines custom recipes for the DataGenerator
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        //List<ItemLike> ECHOVIUM_SMELTABLES = List.of(ModItems.ECHO_GEM.get(), ModBlocks.ECHO_GEM_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ECHOVIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ECHOVIUM.get())
                .unlockedBy(getHasName(ModItems.ECHOVIUM.get()), has(ModItems.ECHOVIUM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ECHO_GEM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ECHO_GEM.get())
                .unlockedBy(getHasName(ModItems.ECHO_GEM.get()), has(ModItems.ECHO_GEM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHO_GEM.get())
                .pattern(" A ")
                .pattern("A#A")
                .pattern(" A ")
                .define('A', Items.ECHO_SHARD)
                .define('#', Items.DIAMOND)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("#A#")
                .pattern("#B#")
                .pattern("###")
                .define('A', ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .define('#', Items.DIAMOND)
                .define('B', Items.DEEPSLATE)
                .unlockedBy(getHasName(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        has(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ECHOVIUM.get(), 9)
                .requires(ModBlocks.ECHOVIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ECHOVIUM_BLOCK.get()), has(ModBlocks.ECHOVIUM_BLOCK.get()))
                .save(pRecipeOutput, ACU.MOD_ID + ":echovium_from_echovium_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ECHO_GEM.get(), 9)
                .requires(ModBlocks.ECHO_GEM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ECHO_GEM_BLOCK.get()), has(ModBlocks.ECHO_GEM_BLOCK.get()))
                .save(pRecipeOutput, ACU.MOD_ID + ":echo_gem_from_echo_gem_block");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_PICKAXE),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_PICKAXE.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_pickaxe_upgrade");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_AXE),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_AXE.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_axe_upgrade");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_SHOVEL),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_SHOVEL.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_shovel_upgrade");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_SWORD),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_SWORD.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_sword_upgrade");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_HOE),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_HOE.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_hoe_upgrade");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_HELMET),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_HELMET.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_helmet_upgrade");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_CHESTPLATE),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_CHESTPLATE.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_helmet_upgrade");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_LEGGINGS),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_LEGGINGS.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_leggings_upgrade");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ECHOVIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.NETHERITE_BOOTS),
                Ingredient.of(ModItems.ECHOVIUM.get()),
                RecipeCategory.MISC, ModItems.ECHOVIUM_BOOTS.get()).unlocks("has_echovium",
                has(ModItems.ECHOVIUM.get())).save(pRecipeOutput, ACU.MOD_ID + ":echovium_boots_upgrade");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, ACU.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
