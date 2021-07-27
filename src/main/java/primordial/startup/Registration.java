package primordial.startup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static primordial.Primordial.MODID;
import primordial.blocks.*;
import primordial.items.CrudePickaxe;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<BlockSimple> SIMPLEBLOCK = BLOCKS.register("simple_block", BlockSimple::new);
    public static final RegistryObject<Item> SIMPLEBLOCK_ITEM = ITEMS.register("simple_block", () -> new BlockItem(SIMPLEBLOCK.get(), new Item.Properties().tab(Setup.ITEM_GROUP)));

    public static final RegistryObject<CrudePickaxe> CRUDE_PICKAXE = ITEMS.register("CrudePickaxe", CrudePickaxe::new);
}
