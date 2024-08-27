package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import patches.Patch;



public class GunsWorkBetterThanMagicAction
  extends AbstractGameAction
{
  private final boolean freeToPlayOnce;
  private final boolean upgraded;
  private final AbstractPlayer p;
  private final int energyOnUse;
  
  public GunsWorkBetterThanMagicAction(AbstractPlayer p, boolean upgraded, boolean freeToPlayOnce, int energyOnUse) {
    this.p = p;
    this.upgraded = upgraded;
    this.freeToPlayOnce = freeToPlayOnce;
    this.duration = Settings.ACTION_DUR_XFAST;
    this.actionType = AbstractGameAction.ActionType.SPECIAL;
    this.energyOnUse = energyOnUse;
  }
  
  public void update() {
    int effect = EnergyPanel.totalCount;
    if (this.energyOnUse != -1) {
      effect = this.energyOnUse;
    }
    
    if (this.p.hasRelic("Chemical X")) {
      effect += 2;
      this.p.getRelic("Chemical X").flash();
    } 
    AbstractCard[] ArmsGroup = Patch.getArmsCard();
    if (effect > 0) {
      for (int i = 0; i < effect; i++) {
        AbstractCard c = ArmsGroup[AbstractDungeon.cardRandomRng.random(ArmsGroup.length - 1)];
        
        if (this.upgraded) {
          c.upgrade();
        }
        c.setCostForTurn(0);
        addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, 1));
      } 
      
      if (!this.freeToPlayOnce) {
        this.p.energy.use(EnergyPanel.totalCount);
      }
    } 
    
    this.isDone = true;
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/GunsWorkBetterThanMagicAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */