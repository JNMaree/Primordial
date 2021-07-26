package primordial;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod(primordial.MODID)
public class primordial
{
    public static final String MODID = "primordial";
    public static final Logger LOGGER = LogManager.getLogger();

    public primordial() {

    }

}

