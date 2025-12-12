/**
 * Ancient City Update
 *
 * @author: Corbin Webber
 * @version: 0.1
 *
 * This program defines the block state for blocks for the DataGenerator
 */

package net.ekual.acu.datagen;

import net.ekual.acu.ACU;
import net.ekual.acu.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ACU.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ECHOVIUM_BLOCK);
        blockWithItem(ModBlocks.ECHO_GEM_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
