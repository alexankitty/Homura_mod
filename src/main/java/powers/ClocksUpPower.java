package powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.purple.Vault;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ClocksUpPower extends AbstractPower {

  private static final PowerStrings powerStrings =
    CardCrawlGame.languagePack.getPowerStrings("ClocksUpPower");
  public static final String POWER_ID = "ClocksUpPower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
  private int count;

  public ClocksUpPower(AbstractCreature owner, int count) {
    this.name = powerStrings.NAME;
    this.ID = "ClocksUpPower";
    this.owner = owner;

    loadRegion("time");
    this.type = AbstractPower.PowerType.BUFF;
    this.amount = 0;
    this.count = count;
    updateDescription();
  }

  public void stackPower(int stackAmount) {
    this.fontScale = 8.0F;
    this.count++;
    updateDescription();
  }

  public void onUseCard(AbstractCard card, UseCardAction action) {
    this.amount++;
    if (this.amount == 12) {
      flash();
      AbstractCard c = (new Vault()).makeCopy();
      c.upgrade();
      addToBot(
        (AbstractGameAction) new MakeTempCardInHandAction(c, this.count)
      );
      this.amount = 0;
    }
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.count + DESCRIPTIONS[1];
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/ClocksUpPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
