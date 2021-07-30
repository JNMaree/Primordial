package primordial;


import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import primordial.startup.Config;
import primordial.startup.Registration;
import primordial.startup.Setup;
import primordial.startup.Client;

@Mod(Primordial.MODID)
public class Primordial
{
    public static final String MODID = "primordial";
    public static final Logger LOGGER = LogManager.getLogger();

    public Primordial() {

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

        Registration.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(Setup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::init);
    }

}

