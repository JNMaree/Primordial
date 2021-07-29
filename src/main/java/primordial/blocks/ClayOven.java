package primordial.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.BlockStateProperties;

public class BlockSimple extends Block
{
    public BlockSimple() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .strength(0.8f)
                .sound(SoundType.ANVIL)
                .friction(0.98f)
                .lightLevel(state -> state.getValue(BlockStateProperties.POWERED) ? 14 : 0));
    }

    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }
}
