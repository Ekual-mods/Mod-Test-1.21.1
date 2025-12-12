/**
 * Ancient City Update
 *
 * @author: Corbin Webber
 * @version: 0.1
 *
 * This is a placeholder class for future updates
 * such as a custom dimension.
 */

package net.ekual.acu.event;

import net.ekual.acu.ACU;
import net.minecraft.core.BlockPos;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

//This is a placeholder event for future updates
@Mod.EventBusSubscriber(modid = ACU.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();


}
