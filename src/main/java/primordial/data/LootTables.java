package primordial.data;


import net.minecraft.data.DataGenerator;
import primordial.startup.Registration;

public class LootTables extends BaseLootTableProvider
{
    public LootTables(DataGenerator dataGen) {
        super(dataGen);
    }

    @Override
    protected void addTables() {
        lootTables.put(Registration.BLOCK_OVEN.get(), createStandardTable("clay_oven", Registration.BLOCK_OVEN.get()));
    }
}


