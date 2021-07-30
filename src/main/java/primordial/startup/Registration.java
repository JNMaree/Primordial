package primordial.startup;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static primordial.Primordial.MODID;
import primordial.blocks.*;
import primordial.items.CrudePickaxe;

public class Registration
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //BLOCK: Clay Oven globals
    public static final RegistryObject<ClayOven> BLOCK_OVEN = BLOCKS.register("clay_oven", ClayOven::new);
    public static final RegistryObject<Item> BLOCK_OVEN_ITEM = ITEMS.register("clay_oven", () -> new BlockItem(BLOCK_OVEN.get(), new Item.Properties().tab(Setup.ITEM_GROUP)));
    public static final RegistryObject<TileEntityType<ClayOvenTileEntity>> BLOCK_OVEN_TILE = TILES.register("clay_oven", () -> TileEntityType.Builder.of(ClayOvenTileEntity::new, BLOCK_OVEN.get()).build(null));
    public static final RegistryObject<ContainerType<ClayOvenContainer>> BLOCK_OVEN_CONTAINER = CONTAINERS.register("clay_oven", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getCommandSenderWorld();
        return new ClayOvenContainer(windowId, world, pos, inv, inv.player);
    }));

    public static final RegistryObject<CrudePickaxe> CRUDE_PICKAXE = ITEMS.register("crude_pickaxe", CrudePickaxe::new);


}
