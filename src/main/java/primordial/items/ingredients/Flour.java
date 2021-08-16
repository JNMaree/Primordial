package primordial.items.ingredients;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Flour extends Item
{
    public Flour() {
        super(new Item.Properties()
                .tab(ItemGroup.TAB_FOOD)
                .stacksTo(64));
    }
}
