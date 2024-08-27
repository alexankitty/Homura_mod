package patches;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.TextAboveCreatureAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;





@SpirePatch(clz = ApplyPowerAction.class, method = "<ctor>", paramtypez = {AbstractCreature.class, AbstractCreature.class, AbstractPower.class, int.class, boolean.class, AbstractGameAction.AttackEffect.class})
public class UntiePowerPatch
{
  @SpireInsertPatch(rloc = 24, localvars = {"amount", "duration"})
  public static SpireReturn<Void> Insert(ApplyPowerAction _instance, AbstractCreature target, AbstractCreature source, AbstractPower powerToApply, int stackAmount, boolean isFast, AbstractGameAction.AttackEffect effect, @ByRef int[] amount, @ByRef float[] duration) {
    if (target == AbstractDungeon.player && AbstractDungeon.player.hasPower("UntiePower"))
    {
      if (powerToApply.ID.equals("Weakened") || powerToApply.ID.equals("Frail") || powerToApply.ID.equals("Vulnerable")) {
        AbstractDungeon.actionManager.addToTop((AbstractGameAction)new TextAboveCreatureAction(target, (CardCrawlGame.languagePack.getUIString("ApplyPowerAction")).TEXT[1]));
        duration[0] = duration[0] - Gdx.graphics.getDeltaTime();
      } 
    }
    
    return SpireReturn.Continue();
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/UntiePowerPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */