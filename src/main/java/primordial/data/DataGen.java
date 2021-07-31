package primordial.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGen = event.getGenerator();
        if (event.includeServer()) {
            dataGen.addProvider(new LootTables(dataGen));
        }
        if (event.includeClient()) {
            dataGen.addProvider(new BlockStates(dataGen, event.getExistingFileHelper()));
            dataGen.addProvider(new Items(dataGen, event.getExistingFileHelper()));
        }
    }
}
