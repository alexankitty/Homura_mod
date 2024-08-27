package powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class TimeBombPower extends AbstractPower {
  public static final String POWER_ID = "TimeBombPower";
  private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("TimeBombPower");
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
  public static final String NAME = powerStrings.NAME;
  private int damage;
  private static int bombIdOffset;

  public TimeBombPower(AbstractCreature owner, int turns, int damage) {
    this.name = NAME;
    this.ID = "TimeBombPower" + bombIdOffset;
    bombIdOffset++;
    this.owner = owner;
    this.amount = turns;
    this.damage = damage;
    this.type = AbstractPower.PowerType.DEBUFF;
    updateDescription();
    loadRegion("the_bomb");
  }



  public void atEndOfTurn(boolean isPlayer) {
    addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, 1));
  }




  public void atStartOfTurn() {}



  public void onRemove() {
    addToBot((AbstractGameAction)new DamageAction(this.owner, new DamageInfo(this.owner, this.damage), AbstractGameAction.AttackEffect.FIRE));
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.damage + DESCRIPTIONS[1];
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/TimeBombPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */