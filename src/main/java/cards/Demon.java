package cards;

import EgoMod.AbstractCardEnum;
import EgoMod.HomuraMod;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.InstantKillAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.stances.AbstractStance;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.GrandFinalEffect;
import patches.Patch;
import stance.DemonStance;

public class  Demon extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Demon");
  public static final String ID = "Demon";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/Demon_attack.png";
  private static final int COST = 3;
  private static final int ATTACK_DMG = 10;

  public Demon() {
    super(
      "Demon",
      NAME,
      "img/cards/Demon_attack.png",
      3,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.RARE,
      AbstractCard.CardTarget.ALL_ENEMY
    );
    this.baseMagicNumber = 0;
    this.baseDamage = 8;
    this.magicNumber = this.baseMagicNumber;
    this.isMultiDamage = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    if (HomuraMod.isSchoolUniform || HomuraMod.isMagicalGirl) {
      addToBot(
        (AbstractGameAction) new ChangeStanceAction(
          (AbstractStance) new DemonStance()
        )
      );
    }
    int hitCount = Patch.countServantNum() + Patch.countCurse();
    int potentialDamage = hitCount * this.damage;
    boolean doDamage = false;
    addToBot(
      (AbstractGameAction) new VFXAction(
        (AbstractGameEffect) new GrandFinalEffect(),
        1.0F
      )
    );
    for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
      if (mo.currentHealth > 0) {
        for (int i = 0; i < 3; i++) {
          addToBot((AbstractGameAction) new WaitAction(0.1F));
        }
        if (
          mo.type != AbstractMonster.EnemyType.NORMAL ||
          mo.currentHealth > (potentialDamage + 30)
        ) {
          doDamage = true;
        } else {
          addToBot(
            (AbstractGameAction) new InstantKillAction((AbstractCreature) mo)
          );
        }
      }
    }
    if (doDamage) {
      for (int i = 0; i < hitCount; i++) {
        addToBot(
          (AbstractGameAction) new DamageAllEnemiesAction(
            (AbstractCreature) p,
            this.multiDamage,
            this.damageTypeForTurn,
            AbstractGameAction.AttackEffect.FIRE
          )
        );
      }
    }
  }

  public void calculateCardDamage(AbstractMonster m) {
    this.baseMagicNumber = Patch.countServantNum() + Patch.countCurse();
    super.calculateCardDamage(m);
  }

  public void applyPowers() {
    this.baseMagicNumber = Patch.countServantNum() + Patch.countCurse();
    super.applyPowers();
  }

  public boolean canUse(AbstractPlayer p, AbstractMonster m) {
    boolean canUse = super.canUse(p, m);
    if (!canUse) {
      return false;
    }
    if (this.baseMagicNumber < 15) {
      canUse = false;
    }
    return canUse;
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Demon();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
      this.selfRetain = true;
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Demon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
