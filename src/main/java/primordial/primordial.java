package primordial;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;

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

public class BlockSimple extends Block
{
    public BlockSimple()
    {
        super(Block.Properties.create(Material.STONE));
    }

    @java.lang.Override
    public BlockRenderType getRenderType(BlockState b_state) {
        return BlockRenderType.MODEL;
    }
}
