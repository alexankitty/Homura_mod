package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import patches.Patch;







public class DemonPower
  extends AbstractPower
{
  public static final String POWER_ID = "DemonPower";
  private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("DemonPower");
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
  public DemonPower(AbstractCreature owner, int amount) {
    this.name = powerStrings.NAME;
    this.ID = "DemonPower";
    this.owner = owner;
    this.img = new Texture("img/powers/DemonPower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    this.amount = amount;
    updateDescription();
  }

  
  public void atEndOfTurn(boolean isPlayer) {
    if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
      int curseNum = Patch.countCurse();
      if (curseNum > 0 && this.amount > 0) {
        flash();
        AbstractPlayer p = AbstractDungeon.player;
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)p, curseNum * this.amount), curseNum * this.amount));
      } 
    } 
  }

  
  public void onInitialApplication() {}

  
  public void onRemove() {}
  
  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/DemonPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */