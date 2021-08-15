package primordial.fluids;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ItemClayMudBucket extends BucketItem
{
    public ItemClayMudBucket(Supplier<? extends Fluid> fluidSupplier){
        super(fluidSupplier, new Item.Properties()
                .tab(ItemGroup.TAB_MATERIALS)
                .stacksTo(1));
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return super.initCapabilities(stack, nbt);
    }
}
