package primordial.startup;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import primordial.Primordial;
import primordial.startup.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Primordial.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Setup {

    public static final ItemGroup ITEM_GROUP = new ItemGroup("primordial") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.SIMPLEBLOCK.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event){

    }

}
