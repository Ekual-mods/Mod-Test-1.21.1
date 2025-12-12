/**
 * Ancient City Update
 *
 * @author: Corbin Webber
 * @version: 0.1
 *
 * This program defines custom tags for blocks for the Data Generator
 */

package net.ekual.acu.datagen;

import net.ekual.acu.ACU;
import net.ekual.acu.block.ModBlocks;
import net.ekual.acu.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ACU.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ECHOVIUM_BLOCK.get())
                .add(ModBlocks.ECHO_GEM_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ECHOVIUM_BLOCK.get())
                .add(ModBlocks.ECHO_GEM_BLOCK.get());

        tag(ModTags.Blocks.NEEDS_ECHOVIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_ECHOVIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(ModTags.Blocks.NEEDS_ECHOVIUM_TOOL);
    }
}
