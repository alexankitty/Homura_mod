package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class AT4 extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("AT4");
  public static final String ID = "AT4";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/AT4_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 12;
  private static final int UPGRADE_PLUS_DMG = 4;

  public AT4() {
    super(
      "AT4",
      NAME,
      "img/cards/AT4_attack.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.ENEMY
    );
    this.baseDamage = 12;
    this.exhaust = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new DamageAction(
        (AbstractCreature) m,
        new DamageInfo(
          (AbstractCreature) p,
          this.damage,
          this.damageTypeForTurn
        ),
        AbstractGameAction.AttackEffect.SLASH_HORIZONTAL
      )
    );
  }

  public void calculateCardDamage(AbstractMonster m) {
    if (m == null) {
      return;
    }
    int realBaseDamage = this.baseDamage;
    if (m.currentBlock > 0) {
      this.baseDamage *= 2;
    }
    super.calculateCardDamage(m);
    this.baseDamage = realBaseDamage;
    this.isDamageModified = (this.damage != this.baseDamage);
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new AT4();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(4);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/AT4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
