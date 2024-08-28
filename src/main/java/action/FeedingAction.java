package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;

public class FeedingAction extends AbstractGameAction {

  public FeedingAction(
    int amount,
    boolean isRandom,
    boolean anyNumber,
    boolean canPickZero
  ) {
    this.anyNumber = anyNumber;
    this.p = AbstractDungeon.player;
    this.canPickZero = canPickZero;
    this.isRandom = isRandom;
    this.amount = amount;
    this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
    this.actionType = AbstractGameAction.ActionType.EXHAUST;
  }

  public void update() {
    if (this.duration == this.startDuration) {
      if (this.p.hand.size() == 0) {
        this.isDone = true;

        return;
      }
      if (!this.isRandom) {
        numExhausted = this.amount;
        AbstractDungeon.handCardSelectScreen.open(
          TEXT[0],
          this.amount,
          this.anyNumber,
          this.canPickZero
        );
        tickDuration();

        return;
      }
    }

    if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
      for (AbstractCard c : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
        this.p.hand.moveToExhaustPile(c);

        if (c.type == AbstractCard.CardType.CURSE) {
          addToBot((AbstractGameAction) new GainEnergyAction(1));
        }
        if (c.type == AbstractCard.CardType.STATUS) {
          addToBot(
            (AbstractGameAction) new DrawCardAction(
              (AbstractCreature) this.p,
              1
            )
          );
        }
      }

      AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
    }

    this.isDone = true;
  }

  private static final UIStrings uiStrings =
    CardCrawlGame.languagePack.getUIString("ExhaustAction");
  public static final String[] TEXT = uiStrings.TEXT;
  private AbstractPlayer p;
  private boolean isRandom;
  private boolean anyNumber;
  private boolean canPickZero;
  public static int numExhausted;
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/FeedingAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
