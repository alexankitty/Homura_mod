package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class MoveAndFirePower extends AbstractPower {

  private static final PowerStrings powerStrings =
    CardCrawlGame.languagePack.getPowerStrings("MoveAndFirePower");
  public static final String POWER_ID = "MoveAndFirePower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

  public MoveAndFirePower(AbstractCreature owner, int Block) {
    this.name = powerStrings.NAME;
    this.ID = "MoveAndFirePower";
    this.owner = owner;
    this.img = new Texture("img/powers/MoveAndFirePower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    this.amount = Block;
    updateDescription();
  }

  public void onUseCard(AbstractCard card, UseCardAction action) {
    if (card.type == AbstractCard.CardType.ATTACK) {
      addToBot(
        (AbstractGameAction) new GainBlockAction(
          (AbstractCreature) AbstractDungeon.player,
          (AbstractCreature) AbstractDungeon.player,
          this.amount
        )
      );
    }
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/MoveAndFirePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
