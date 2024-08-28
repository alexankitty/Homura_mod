package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SSM1 extends CustomCard {

  public static final String ID = "SSM1";
  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("SSM1");
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  public static final String IMG_PATH = "img/cards/SSM1_attack.png";
  private static final int COST = 3;
  private static final int ATTACK_DMG = 4;
  private static final int UPGRADE_PLUS_DMG = 2;

  public SSM1() {
    super(
      "SSM1",
      NAME,
      "img/cards/SSM1_attack.png",
      3,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.ALL_ENEMY
    );
    this.baseDamage = 4;
    this.exhaust = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    for (int i = 0; i < 6; i++) {
      addToBot(
        (AbstractGameAction) new AttackDamageRandomEnemyAction(
          (AbstractCard) this,
          AbstractGameAction.AttackEffect.SLASH_HORIZONTAL
        )
      );
    }
  }

  public void calculateCardDamage(AbstractMonster m) {
    if (m != null) {
      int realBaseDamage = this.baseDamage;
      if (m.currentBlock > 0) {
        this.baseDamage *= 2;
      }
      super.calculateCardDamage(m);
      this.baseDamage = realBaseDamage;
      this.isDamageModified = (this.damage != this.baseDamage);
    }
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new SSM1();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(2);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/SSM1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
