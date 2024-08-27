package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class CleanAction
  extends AbstractGameAction
{
  private final DamageInfo info;
  private final AbstractCard theCard;
  
  public CleanAction(AbstractCreature target, DamageInfo info, AbstractCard theCard) {
    this.info = info;
    setValues(target, info);
    this.actionType = AbstractGameAction.ActionType.DAMAGE;
    this.duration = 0.1F;
    this.theCard = theCard;
  }
  
  public void update() {
    if (this.duration == 0.1F && this.target != null) {
      AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
      this.target.damage(this.info);
      if (this.target.isDying || this.target.currentHealth <= 0) {
        AbstractCard c = this.theCard;
        if (c.upgraded) {
          c.upgrade();
        }
        c.setCostForTurn(0);
        addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, 1));
      } 
      
      if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead()) {
        AbstractDungeon.actionManager.clearPostCombatActions();
      }
    } 
    this.isDone = true;
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/CleanAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */