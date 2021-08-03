package primordial.items;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.List;

public class CrudePickaxe extends CrudeTierItem
{
    public CrudePickaxe(){
        super(ToolType.PICKAXE);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flag){
        list.add(new TranslationTextComponent("message.crude_pickaxe"));
    }

    @Override
    public boolean mineBlock(ItemStack stack, World world, BlockState bState, BlockPos pos, LivingEntity entity) {
        if(world.isClientSide){
            stack.setDamageValue(stack.getDamageValue() - 1);
        }
        return true;
    }
}
