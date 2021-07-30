package primordial.startup;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import primordial.Primordial;
import primordial.blocks.ClayOvenScreen;


@Mod.EventBusSubscriber(modid = Primordial.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Client
{
    public static void init(final FMLClientSetupEvent event){
        ScreenManager.register(Registration.BLOCK_OVEN_CONTAINER.get(), ClayOvenScreen::new);
    }

    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.Pre event){
        Item item = event.getStack().getItem();
        if (item.getRegistryName().getNamespace().equals(Primordial.MODID)) {
            event.setMaxWidth(200);
        }
    }
}
