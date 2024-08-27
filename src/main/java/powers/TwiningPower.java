package powers;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class TwiningPower extends AbstractPower {
  private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("TwiningPower"); public static final String POWER_ID = "TwiningPower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
  public TwiningPower(AbstractCreature owner, int amount) {
    this.name = powerStrings.NAME;
    this.ID = "TwiningPower";
    this.owner = owner;
    this.amount = amount;
    this.img = new Texture("img/powers/TwiningPower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    updateDescription();
  }


  
  public void atStartOfTurn() {
    addToBot((AbstractGameAction)new GainEnergyAction(this.amount));
    flash();
  }
  
  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/TwiningPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */