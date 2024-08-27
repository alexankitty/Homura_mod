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

public class StockPower extends AbstractPower {
  private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("StockPower"); public static final String POWER_ID = "StockPower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

  public StockPower(AbstractCreature owner, int amount) {
    this.name = powerStrings.NAME;
    this.ID = "StockPower";
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
      AbstractCard c = ArmsGroup[AbstractDungeon.cardRandomRng.random(ArmsGroup.length - 1)];
      addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, 1));
    }
  }



  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/StockPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */