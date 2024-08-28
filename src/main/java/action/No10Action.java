package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class No10Action extends AbstractGameAction {

  private final DamageInfo info;
  private static final float DURATION = 0.1F;

  public No10Action(AbstractCreature target, DamageInfo info) {
    this.info = info;
    setValues(target, info);
    this.actionType = AbstractGameAction.ActionType.DAMAGE;
    this.duration = 0.1F;
  }

  public void update() {
    if (this.duration == 0.1F && this.target != null) {
      int res;
      AbstractDungeon.effectList.add(
        new FlashAtkImgEffect(
          this.target.hb.cX,
          this.target.hb.cY,
          AbstractGameAction.AttackEffect.BLUNT_HEAVY
        )
      );

      AbstractMonster mon = (AbstractMonster) this.target;

      int tmp = mon.currentHealth;

      this.target.damage(this.info);

      if (this.target.isDying || this.target.currentHealth <= 0) {
        res = tmp;
      } else {
        res = tmp - mon.currentHealth;
      }

      AbstractPlayer p = AbstractDungeon.player;

      p.gainGold(res);
      for (int i = 0; i < res; i++) {
        AbstractDungeon.effectList.add(
          new GainPennyEffect(
            (AbstractCreature) p,
            this.target.hb.cX,
            this.target.hb.cY,
            p.hb.cX,
            p.hb.cY,
            true
          )
        );
      }

      if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead()) {
        AbstractDungeon.actionManager.clearPostCombatActions();
      }
    }
    tickDuration();
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/No10Action.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
