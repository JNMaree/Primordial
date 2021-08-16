package primordial.items.tools;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.List;

public class CrudeAxe extends CrudeTierItem
{
    public CrudeAxe(){
        super(ToolType.AXE);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flag) {
        list.add(new TranslationTextComponent("message.crude_axe"));
    }
}
