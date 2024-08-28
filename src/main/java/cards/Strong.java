package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import patches.Patch;

public class Strong extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Strong");
  public static final String ID = "Strong";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/Strong_power.png";

  public Strong() {
    super(
      "Strong",
      NAME,
      "img/cards/Strong_power.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.POWER,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.RARE,
      AbstractCard.CardTarget.SELF
    );
    this.baseMagicNumber = 0;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    this.magicNumber = Patch.countSL();
    if (this.magicNumber != 0) {
      addToBot(
        (AbstractGameAction) new LoseHPAction(
          (AbstractCreature) p,
          (AbstractCreature) p,
          this.magicNumber
        )
      );
      addToBot(
        (AbstractGameAction) new ApplyPowerAction(
          (AbstractCreature) p,
          (AbstractCreature) p,
          (AbstractPower) new StrengthPower(
            (AbstractCreature) p,
            this.magicNumber
          ),
          this.magicNumber
        )
      );
    }
  }

  public void calculateCardDamage(AbstractMonster mo) {
    this.baseMagicNumber = Patch.countSL();
    super.calculateCardDamage(mo);
  }

  public void applyPowers() {
    this.baseMagicNumber = Patch.countSL();
    super.applyPowers();
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Strong();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBaseCost(0);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Strong.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
