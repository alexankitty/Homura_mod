package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class DesertEagle extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("DesertEagle");
  public static final String ID = "DesertEagle";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/DesertEagle_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 5;
  private static final int UPGRADE_PLUS_DMG = 2;

  public DesertEagle() {
    super(
      "DesertEagle",
      NAME,
      "img/cards/DesertEagle_attack.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.COMMON,
      AbstractCard.CardTarget.ENEMY
    );
    this.baseDamage = 5;
    this.baseMagicNumber = 1;
    this.magicNumber = this.baseMagicNumber;
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
    addToBot(
      (AbstractGameAction) new ApplyPowerAction(
        (AbstractCreature) m,
        (AbstractCreature) p,
        (AbstractPower) new VulnerablePower(
          (AbstractCreature) m,
          this.magicNumber,
          false
        ),
        this.magicNumber,
        true,
        AbstractGameAction.AttackEffect.NONE
      )
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new DesertEagle();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(2);
      upgradeMagicNumber(1);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/DesertEagle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
