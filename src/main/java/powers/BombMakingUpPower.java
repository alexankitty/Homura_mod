package powers;

import cards.IED;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class BombMakingUpPower extends AbstractPower {

  private static final PowerStrings powerStrings =
    CardCrawlGame.languagePack.getPowerStrings("BombMakingUpPower");
  public static final String POWER_ID = "BombMakingUpPower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

  public BombMakingUpPower(AbstractCreature owner, int amount) {
    this.name = powerStrings.NAME;
    this.ID = "BombMakingUpPower";
    this.owner = owner;
    this.img = new Texture("img/powers/BombMakingPower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    this.amount = amount;
    updateDescription();
  }

  public void atStartOfTurn() {
    AbstractCard c = (new IED()).makeCopy();
    c.upgrade();
    addToBot((AbstractGameAction) new MakeTempCardInHandAction(c, this.amount));
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/BombMakingUpPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
