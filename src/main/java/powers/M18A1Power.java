package powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class M18A1Power extends AbstractPower {

  public static final String POWER_ID = "M18A1Power";
  private static final PowerStrings powerStrings =
    CardCrawlGame.languagePack.getPowerStrings("M18A1Power");
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

  public M18A1Power(AbstractCreature owner, int amount) {
    this.name = powerStrings.NAME;
    this.ID = "M18A1Power";
    this.owner = owner;
    loadRegion("flameBarrier");
    this.type = AbstractPower.PowerType.BUFF;
    this.amount = amount;
    updateDescription();
  }

  public int onAttacked(DamageInfo info, int damageAmount) {
    if (
      info.owner != null &&
      info.type != DamageInfo.DamageType.THORNS &&
      info.type != DamageInfo.DamageType.HP_LOSS &&
      info.owner != this.owner
    ) {
      flash();
      if (this.amount <= 0) {
        AbstractDungeon.actionManager.addToBottom(
          (AbstractGameAction) new RemoveSpecificPowerAction(
            this.owner,
            this.owner,
            "M18A1Power"
          )
        );
      } else {
        this.amount--;
        addToTop(
          (AbstractGameAction) new DamageAction(
            info.owner,
            new DamageInfo(
              this.owner,
              info.output,
              DamageInfo.DamageType.THORNS
            ),
            AbstractGameAction.AttackEffect.FIRE
          )
        );
      }
    }

    return damageAmount;
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/M18A1Power.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
