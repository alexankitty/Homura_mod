package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import java.util.ArrayList;


public class TreatmentAction
  extends AbstractGameAction
{
  public TreatmentAction() {
    setValues((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player);
    this.actionType = AbstractGameAction.ActionType.EXHAUST;
  }
  
  public void update() {
    ArrayList<AbstractCard> cardsToExhaust = new ArrayList<>();
    for (AbstractCard c : AbstractDungeon.player.hand.group) {
      if (c.type == AbstractCard.CardType.STATUS) {
        addToTop((AbstractGameAction)new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
      }
    } 
    
    for (AbstractCard c : AbstractDungeon.player.drawPile.group) {
      if (c.type == AbstractCard.CardType.STATUS) {
        addToTop((AbstractGameAction)new ExhaustSpecificCardAction(c, AbstractDungeon.player.drawPile));
      }
    } 
    
    for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
      if (c.type == AbstractCard.CardType.STATUS) {
        addToTop((AbstractGameAction)new ExhaustSpecificCardAction(c, AbstractDungeon.player.discardPile));
      }
    } 







    
    this.isDone = true;
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/TreatmentAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */