package primordial.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;

public class BlockSimple extends Block
{
    public BlockSimple() {
        super(Block.Properties.of(Material.STONE));
    }

    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }
}
