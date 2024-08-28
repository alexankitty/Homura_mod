package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import java.util.ArrayList;
import patches.Patch;

public class FalseTownPower extends AbstractPower {

  private static final PowerStrings powerStrings =
    CardCrawlGame.languagePack.getPowerStrings("FalseTownPower");
  public static final String POWER_ID = "FalseTownPower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
  boolean isUpgrade;

  public FalseTownPower(AbstractCreature owner, boolean isUpgrade, int Amount) {
    this.name = powerStrings.NAME;
    this.ID = "FalseTownPower";
    this.owner = owner;
    this.img = new Texture("img/powers/FalseTownPower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    this.isUpgrade = isUpgrade;
    this.amount = Amount;
    updateDescription();
  }

  public void stackPower(int stackAmount) {
    this.fontScale = 8.0F;
    this.amount += stackAmount;
    updateDescription();
  }

  public void atStartOfTurn() {
    ArrayList<AbstractCard> cl = Patch.getServant(this.amount);
    for (AbstractCard c : cl) {
      addToBot(
        (AbstractGameAction) new MakeTempCardInDrawPileAction(c, 1, true, true)
      );
      AbstractCard curse = AbstractDungeon.returnRandomCurse().makeCopy();
      addToBot((AbstractGameAction) new MakeTempCardInDiscardAction(curse, 1));
    }
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0] +
    this.amount +
    DESCRIPTIONS[1] +
    this.amount +
    DESCRIPTIONS[2];
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/FalseTownPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
