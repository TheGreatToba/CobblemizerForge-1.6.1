package git.dragomordor.cobblemizer.fabric.item.custom;

import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.IVs;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

public class IVMaxerItem extends PokemonUseItem {

    public IVMaxerItem() {
        super(new Item.Settings().maxCount(1));
    }

    @Override
    public ActionResult processInteraction(ItemStack itemStack, PlayerEntity player, PokemonEntity target, Pokemon pokemon) {
        IVs ivs = pokemon.getIvs(); // Access the IVs of the PokÃƒÆ’Ã‚Â©mon
        // max stats
        int IVsMaxed = 0;
        Stat[] stats = new Stat[]{
                Stats.HP,
                Stats.ATTACK,
                Stats.DEFENCE,
                Stats.SPECIAL_ATTACK,
                Stats.SPECIAL_DEFENCE,
                Stats.SPEED
        };
        for (Stat stat : stats) { // checks how many stats are maxed
            Integer currentIV = ivs.get(stat);
            if (currentIV == null) { // should not be null for permanent stats, but guard anyway
                continue;
            }
            if (currentIV == IVs.MAX_VALUE) {
                IVsMaxed++;
            }
        }
        if (IVsMaxed == 6) { //fail, all stats maxed (only 6 IV stats)
            player.sendMessage(Text.of("All IVs at max already!"));
            return ActionResult.FAIL;
        }
        // Pass: set the six permanent IV stats to max
        for (Stat stat : stats) {
            Integer currentIV = ivs.get(stat);
            if (currentIV == null) {
                continue;
            }
            ivs.set(stat, IVs.MAX_VALUE);
        }
        // maximise all stats
        itemStack.decrement(1); // remove item after use
        player.sendMessage(Text.of("All IVs boosted to maximum"));
        return ActionResult.SUCCESS;
    }
}

