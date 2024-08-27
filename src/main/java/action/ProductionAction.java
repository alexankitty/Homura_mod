package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import java.util.ArrayList;
import java.util.Iterator;
import patches.Patch;









public class ProductionAction
  extends AbstractGameAction
{
  private final ArrayList<AbstractCard> cannotDuplicate = new ArrayList<>();
  
  public ProductionAction(AbstractCreature source, int amount) {
    setValues((AbstractCreature)AbstractDungeon.player, source, amount);
    this.actionType = AbstractGameAction.ActionType.DRAW;
    this.duration = 0.25F;
    this.p = AbstractDungeon.player;
    this.dupeAmount = amount;
  }



  
  public void update() {
    if (this.duration == Settings.ACTION_DUR_FAST) {
      Iterator<AbstractCard> var1 = this.p.hand.group.iterator();
      
      while (var1.hasNext()) {
        AbstractCard c = var1.next();
        if (!isDualWieldable(c)) {
          this.cannotDuplicate.add(c);
        }
      } 
      
      if (this.cannotDuplicate.size() == this.p.hand.group.size()) {
        this.isDone = true;
        
        return;
      } 
      if (this.p.hand.group.size() - this.cannotDuplicate.size() == 1) {
        var1 = this.p.hand.group.iterator();
        
        while (var1.hasNext()) {
          AbstractCard c = var1.next();
          if (isDualWieldable(c)) {
            for (int i = 0; i < this.dupeAmount; i++) {
              addToTop((AbstractGameAction)new MakeTempCardInHandAction(c.makeStatEquivalentCopy()));
            }
            
            this.isDone = true;
            
            return;
          } 
        } 
      } 
      this.p.hand.group.removeAll(this.cannotDuplicate);
      if (this.p.hand.group.size() > 1) {
        AbstractDungeon.handCardSelectScreen.open(TEXT[0], 1, false, false, false, false);
        tickDuration();
        
        return;
      } 
      if (this.p.hand.group.size() == 1) {
        for (int i = 0; i < this.dupeAmount; i++) {
          addToTop((AbstractGameAction)new MakeTempCardInHandAction(this.p.hand.getTopCard().makeStatEquivalentCopy()));
        }
        
        returnCards();
        this.isDone = true;
      } 
    } 
    
    if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
      Iterator<AbstractCard> var1 = AbstractDungeon.handCardSelectScreen.selectedCards.group.iterator();
      
      while (var1.hasNext()) {
        AbstractCard c = var1.next();
        addToTop((AbstractGameAction)new MakeTempCardInHandAction(c.makeStatEquivalentCopy()));
        
        for (int i = 0; i < this.dupeAmount; i++) {
          addToTop((AbstractGameAction)new MakeTempCardInHandAction(c.makeStatEquivalentCopy()));
        }
      } 
      
      returnCards();
      AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
      AbstractDungeon.handCardSelectScreen.selectedCards.group.clear();
      this.isDone = true;
    } 
    
    tickDuration();
  }

  
  private void returnCards() {
    for (AbstractCard c : this.cannotDuplicate) {
      this.p.hand.addToTop(c);
    }
    
    this.p.hand.refreshHandLayout();
  }
  
  private boolean isDualWieldable(AbstractCard card) {
    AbstractCard[] Arms = Patch.getArmsCard();
    for (AbstractCard c : Arms) {
      if (c.cardID.equals(card.cardID)) {
        return true;
      }
    } 
    return false;
  }


  
  private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("DualWieldAction");
  public static final String[] TEXT = uiStrings.TEXT;
  private final AbstractPlayer p;
  private final int dupeAmount;
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/ProductionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */