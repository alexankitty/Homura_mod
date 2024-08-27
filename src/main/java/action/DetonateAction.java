package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;







public class DetonateAction
  extends AbstractGameAction
{
  public static final String[] TEXT = (CardCrawlGame.languagePack.getUIString("WishAction")).TEXT;
  private final AbstractPlayer player;
  private final int playAmt;
  
  public DetonateAction(int numberOfCards) {
    this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
    this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
    this.player = AbstractDungeon.player;
    this.playAmt = numberOfCards;
  }

  
  public void update() {
    if (this.duration == this.startDuration) {
      
      if (this.player.discardPile.isEmpty()) {
        this.isDone = true;
      } else {
        CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        for (AbstractCard c : this.player.discardPile.group) {
          if (c.exhaust || "The Bomb".equals(c.cardID)) {
            temp.addToTop(c);
          }
        } 
        if (temp.isEmpty()) {
          this.isDone = true;
        } else {
          temp.sortAlphabetically(true);
          temp.sortByRarityPlusStatusCardType(false);
          AbstractDungeon.gridSelectScreen.open(temp, 1, TEXT[0], false);
        } 
        tickDuration();
      } 
    } else {
      if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
        
        for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
          c.exhaust = true;
          AbstractDungeon.player.discardPile.group.remove(c);
          (AbstractDungeon.getCurrRoom()).souls.remove(c);
          if ("The Bomb".equals(c.cardID)) {
            addToBot((AbstractGameAction)new DamageAllEnemiesAction(null, DamageInfo.createDamageMatrix(c.magicNumber, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
          } else {
            addToBot((AbstractGameAction)new NewQueueCardAction(c, true, false, true));
          } 
          for (int i = 0; i < this.playAmt - 1; i++) {
            AbstractCard tmp = c.makeStatEquivalentCopy();
            tmp.purgeOnUse = true;
            addToBot((AbstractGameAction)new NewQueueCardAction(tmp, true, false, true));
          } 
        } 
        
        AbstractDungeon.gridSelectScreen.selectedCards.clear();
        AbstractDungeon.player.hand.refreshHandLayout();
      } 
      
      tickDuration();
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/DetonateAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */