package net.ekual.testmod.datagen;

import net.ekual.testmod.TestMod;
import net.ekual.testmod.block.ModBlocks;
import net.ekual.testmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ECHOVIUM.get(), 9)
                .requires(ModBlocks.ECHOVIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ECHOVIUM_BLOCK.get()), has(ModBlocks.ECHOVIUM_BLOCK.get()))
                .save(pRecipeOutput, TestMod.MOD_ID + ":echovium_from_echovium_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ECHO_GEM.get(), 9)
                .requires(ModBlocks.ECHO_GEM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ECHO_GEM_BLOCK.get()), has(ModBlocks.ECHO_GEM_BLOCK.get()))
                .save(pRecipeOutput, TestMod.MOD_ID + ":echo_gem_from_echo_gem_block");

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
                    .save(recipeOutput, TestMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
