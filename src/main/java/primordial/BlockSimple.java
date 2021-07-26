package primordial;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;

public class BlockSimple extends Block
{
    public BlockSimple() {
        super(Block.Properties.of(Material.STONE));
    }

    @Override
    public BlockRenderType getRenderType(BlockState block_state) {
        return BlockRenderType.MODEL;
    }
}
