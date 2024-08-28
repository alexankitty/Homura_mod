package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import java.util.Iterator;

public class ZeroEnergePower extends AbstractPower {

  private static final PowerStrings powerStrings =
    CardCrawlGame.languagePack.getPowerStrings("ZeroEnergePower");
  public static final String POWER_ID = "ZeroEnergePower";
  public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

  public ZeroEnergePower(AbstractCreature owner) {
    this.name = powerStrings.NAME;
    this.ID = "ZeroEnergePower";
    this.owner = owner;
    this.img = new Texture("img/powers/ZeroEnergePower32.png");
    this.type = AbstractPower.PowerType.BUFF;
    updateDescription();
  }

  public void onInitialApplication() {
    CardCrawlGame.sound.play("TimeStop");
    Iterator<AbstractCard> var1 = AbstractDungeon.player.hand.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.costForTurn == 0) {
        c.isCostModifiedForTurn = false;
        continue;
      }
      c.setCostForTurn(0);
    }
    var1 = AbstractDungeon.player.drawPile.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.costForTurn == 0) {
        c.isCostModifiedForTurn = false;
        continue;
      }
      c.setCostForTurn(0);
    }
    var1 = AbstractDungeon.player.discardPile.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.costForTurn == 0) {
        c.isCostModifiedForTurn = false;
        continue;
      }
      c.setCostForTurn(0);
    }
  }

  public void onUseCard(AbstractCard card, UseCardAction action) {
    flash();
    AbstractDungeon.actionManager.addToBottom(
      (AbstractGameAction) new RemoveSpecificPowerAction(
        this.owner,
        this.owner,
        "ZeroEnergePower"
      )
    );
  }

  public void onRemove() {
    Iterator<AbstractCard> var1 = AbstractDungeon.player.hand.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.isCostModifiedForTurn) {
        c.costForTurn = c.cost;
        c.isCostModifiedForTurn = false;
      }
    }
    var1 = AbstractDungeon.player.drawPile.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.isCostModifiedForTurn) {
        c.costForTurn = c.cost;
        c.isCostModifiedForTurn = false;
      }
    }
    var1 = AbstractDungeon.player.discardPile.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.isCostModifiedForTurn) {
        c.costForTurn = c.cost;
        c.isCostModifiedForTurn = false;
      }
    }
  }

  public void atEndOfTurn(boolean isPlayer) {
    AbstractDungeon.actionManager.addToBottom(
      (AbstractGameAction) new RemoveSpecificPowerAction(
        this.owner,
        this.owner,
        "ZeroEnergePower"
      )
    );
  }

  public void updateDescription() {
    this.description = DESCRIPTIONS[0];
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/ZeroEnergePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
