package primordial.fluids;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class BlockClayMud extends FlowingFluidBlock
{
    public BlockClayMud(Supplier<? extends FlowingFluid> fluidSupplier){
        super(fluidSupplier, AbstractBlock.Properties.of(Material.WATER)
                .friction(10.00f));
    }

    @Override
    public void stepOn(World world, BlockPos pos, Entity entity) {
        super.stepOn(world, pos, entity);

        if (entity instanceof LivingEntity) {
            entity.animateHurt();
        } else if (entity instanceof ItemEntity) {
            System.out.println("Entity is InstanceOf:ItemEntity");
        }
    }
}
