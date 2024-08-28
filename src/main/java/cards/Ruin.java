package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import patches.Patch;

public class Ruin extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Ruin");
  public static final String ID = "Ruin";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/Ruin_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 3;
  private static final int UPGRADE_PLUS_DMG = 1;

  public Ruin() {
    super(
      "Ruin",
      NAME,
      "img/cards/Ruin_attack.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.ALL_ENEMY
    );
    this.baseDamage = 3;
    this.isMultiDamage = true;
    this.baseMagicNumber = 0;
    this.magicNumber = this.baseMagicNumber;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    for (int i = 0; i < Patch.countCurse(); i++) {
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

  public void calculateCardDamage(AbstractMonster m) {
    this.baseMagicNumber = Patch.countCurse();
    super.calculateCardDamage(m);
  }

  public void applyPowers() {
    this.baseMagicNumber = Patch.countCurse();
    super.applyPowers();
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Ruin();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(1);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Ruin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
