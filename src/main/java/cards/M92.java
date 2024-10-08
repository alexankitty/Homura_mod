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

public class M92 extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("M92");
  public static final String ID = "M92";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/M92_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 2;

  public M92() {
    super(
      "M92",
      NAME,
      "img/cards/M92_attack.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.COMMON,
      AbstractCard.CardTarget.ENEMY
    );
    this.baseDamage = 2;
    this.baseMagicNumber = 4;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    for (int i = 0; i < this.magicNumber; i++) {
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
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new M92();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(1);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/M92.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
