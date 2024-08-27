package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class UntiePower extends AbstractPower {
  private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("UntiePower"); public static final String POWER_ID = "UntiePower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
  public UntiePower(AbstractCreature owner) {
    this.name = powerStrings.NAME;
    this.ID = "UntiePower";
    this.owner = owner;
    this.img = new Texture("img/powers/UntiePower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    updateDescription();
  }


  
  public void atStartOfTurn() {}

  
  public void updateDescription() {
    this.description = DESCRIPTIONS[0];
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/UntiePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */