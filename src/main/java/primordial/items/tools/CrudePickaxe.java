package primordial.items.tools;


import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
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


}
