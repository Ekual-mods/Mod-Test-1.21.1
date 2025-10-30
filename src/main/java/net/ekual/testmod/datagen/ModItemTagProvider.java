package net.ekual.testmod.datagen;

import net.ekual.testmod.TestMod;
import net.ekual.testmod.item.ModItems;
import net.ekual.testmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ECHOVIUM_HELMET.get())
                .add(ModItems.ECHOVIUM_CHESTPLATE.get())
                .add(ModItems.ECHOVIUM_LEGGINGS.get())
                .add(ModItems.ECHOVIUM_BOOTS.get());
    }
}
