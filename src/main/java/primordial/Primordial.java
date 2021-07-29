package primordial;


import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import primordial.startup.Registration;
import primordial.startup.Setup;

@Mod(Primordial.MODID)
public class Primordial
{
    public static final String MODID = "primordial";
    public static final Logger LOGGER = LogManager.getLogger();

    public Primordial() {
        Registration.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(Setup::init);
    }

}

