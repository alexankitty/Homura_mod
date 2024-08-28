package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;

public class No12Action extends AbstractGameAction {

  private static final UIStrings uiStrings =
    CardCrawlGame.languagePack.getUIString("DiscardAction");
  public static final String[] TEXT = uiStrings.TEXT;
  private AbstractPlayer p;

  public No12Action(int amount) {
    this.p = AbstractDungeon.player;
    setValues(
      (AbstractCreature) this.p,
      (AbstractCreature) AbstractDungeon.player,
      amount
    );
    this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
    this.duration = Settings.ACTION_DUR_MED;
  }

  public void update() {
    if (this.duration == Settings.ACTION_DUR_MED) {
      CardGroup tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
      for (AbstractCard abstractCard : this.p.drawPile.group) {
        AbstractCard card = abstractCard;
        tmp.addToRandomSpot(card);
      }

      AbstractDungeon.gridSelectScreen.open(tmp, this.amount, true, TEXT[0]);
    } else if (AbstractDungeon.gridSelectScreen.selectedCards.size() != 0) {
      for (AbstractCard abstractCard : AbstractDungeon.gridSelectScreen.selectedCards) {
        AbstractCard card = abstractCard;
        card.unhover();
        card.isSelected = false;
        this.p.drawPile.moveToDiscardPile(card);
        this.p.hand.refreshHandLayout();
        this.p.hand.applyPowers();
      }

      AbstractDungeon.gridSelectScreen.selectedCards.clear();
      this.p.hand.refreshHandLayout();
    }
    tickDuration();
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/No12Action.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
