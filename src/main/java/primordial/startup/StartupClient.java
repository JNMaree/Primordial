package primordial.startup;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class StartupClient {
    @SubscribeEvent
    public static void onClientStartupEvent(FMLClientSetupEvent client_event){
        RenderTypeLookup.setRenderLayer(StartupCommon.simple_block, RenderType.solid());
    }
}
