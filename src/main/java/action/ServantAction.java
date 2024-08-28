package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.actions.utility.UnlimboAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ServantAction extends AbstractGameAction {

  private final boolean exhaustCards;

  public ServantAction(AbstractCard card, boolean exhausts) {
    this.duration = Settings.ACTION_DUR_FAST;
    this.actionType = AbstractGameAction.ActionType.WAIT;
    this.source = (AbstractCreature) AbstractDungeon.player;
    this.exhaustCards = exhausts;
    this.card = card;
  }

  private final AbstractCard card;

  public void update() {
    if (this.duration == Settings.ACTION_DUR_FAST) {
      this.target =
        (AbstractCreature) (AbstractDungeon.getCurrRoom()).monsters.getRandomMonster(
            null,
            true,
            AbstractDungeon.cardRandomRng
          );
      System.out.println(this.card.name);
      if (this.target == null) {
        this.isDone = true;
        return;
      }
      if (
        AbstractDungeon.player.discardPile.findCardById(this.card.cardID) !=
        null
      ) {
        AbstractDungeon.player.discardPile.group.remove(this.card);
      }
      if (
        AbstractDungeon.player.drawPile.findCardById(this.card.cardID) != null
      ) {
        AbstractDungeon.player.drawPile.group.remove(this.card);
      }

      (AbstractDungeon.getCurrRoom()).souls.remove(this.card);
      this.card.exhaustOnUseOnce = this.exhaustCards;
      AbstractDungeon.player.limbo.group.add(this.card);
      this.card.current_y = -200.0F * Settings.scale;
      this.card.target_x = Settings.WIDTH / 2.0F + 200.0F * Settings.xScale;
      this.card.target_y = Settings.HEIGHT / 2.0F;
      this.card.targetAngle = 0.0F;
      this.card.lighten(false);
      this.card.drawScale = 0.12F;
      this.card.targetDrawScale = 0.75F;
      this.card.applyPowers();
      addToTop(
        (AbstractGameAction) new NewQueueCardAction(
          this.card,
          this.target,
          false,
          true
        )
      );
      addToTop((AbstractGameAction) new UnlimboAction(this.card));
      if (!Settings.FAST_MODE) {
        addToTop((AbstractGameAction) new WaitAction(Settings.ACTION_DUR_MED));
      } else {
        addToTop(
          (AbstractGameAction) new WaitAction(Settings.ACTION_DUR_FASTER)
        );
      }
      this.isDone = true;
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/ServantAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
