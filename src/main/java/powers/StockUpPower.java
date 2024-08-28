package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import patches.Patch;

public class StockUpPower extends AbstractPower {

  private static final PowerStrings powerStrings =
    CardCrawlGame.languagePack.getPowerStrings("StockUpPower");
  public static final String POWER_ID = "StockUpPower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

  public StockUpPower(AbstractCreature owner, int amount) {
    this.name = powerStrings.NAME;
    this.ID = "StockUpPower";
    this.owner = owner;
    this.img = new Texture("img/powers/StockPower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    this.amount = amount;
    updateDescription();
  }

  public void atStartOfTurn() {
    flash();
    AbstractCard[] ArmsGroup = Patch.getArmsCard();

    for (int i = 0; i < this.amount; i++) {
      AbstractCard c =
        ArmsGroup[AbstractDungeon.cardRandomRng.random(ArmsGroup.length - 1)];
      c.upgrade();
      addToBot((AbstractGameAction) new MakeTempCardInHandAction(c, 1));
    }
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/StockUpPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
