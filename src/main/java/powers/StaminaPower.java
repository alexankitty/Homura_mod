package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.DrawPileToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class StaminaPower extends AbstractPower {

  private static final PowerStrings powerStrings =
    CardCrawlGame.languagePack.getPowerStrings("StaminaPower");
  public static final String POWER_ID = "StaminaPower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

  public StaminaPower(AbstractCreature owner, int amount) {
    this.name = powerStrings.NAME;
    this.ID = "StaminaPower";
    this.owner = owner;
    this.amount = amount;
    this.img = new Texture("img/powers/StaminaPower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    updateDescription();
  }

  public void onAfterCardPlayed(AbstractCard usedCard) {
    if (usedCard.type == AbstractCard.CardType.ATTACK) {
      addToBot(
        (AbstractGameAction) new DrawPileToHandAction(
          this.amount,
          AbstractCard.CardType.SKILL
        )
      );
    }
    if (usedCard.type == AbstractCard.CardType.SKILL) {
      addToBot(
        (AbstractGameAction) new DrawPileToHandAction(
          this.amount,
          AbstractCard.CardType.ATTACK
        )
      );
    }
    super.onAfterCardPlayed(usedCard);
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0] +
    this.amount +
    DESCRIPTIONS[1] +
    this.amount +
    DESCRIPTIONS[2];
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/StaminaPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
