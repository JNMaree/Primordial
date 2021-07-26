package primordial.startup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import primordial.Primordial;
import primordial.blocks.BlockSimple;

public class StartupCommon {

    public static BlockSimple simple_block;
    public static BlockItem item_simple_block;

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent){
        simple_block = (BlockSimple) new BlockSimple().setRegistryName(Primordial.MODID, "simple_block_RegistryName");
        blockRegisterEvent.getRegistry().register(simple_block);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent){
        final int MAXIMUM_STACK_SIZE = 17;
        Item.Properties item_simple_block_properties = new Item.Properties();

        item_simple_block_properties.stacksTo(MAXIMUM_STACK_SIZE);
        item_simple_block = new BlockItem(simple_block, item_simple_block_properties);
        item_simple_block.setRegistryName(simple_block.getRegistryName());
        itemRegisterEvent.getRegistry().register(item_simple_block);
    }

    @SubscribeEvent
    public static void onCommonStartupEvent(FMLCommonSetupEvent common_event){

    }

}
