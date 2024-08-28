package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class No15 extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("No15");
  public static final String ID = "No15";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/No15_skill.png";
  private static final int COST = -2;

  public No15() {
    super(
      "No15",
      NAME,
      "img/cards/No15_skill.png",
      -2,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.RARE,
      AbstractCard.CardTarget.SELF
    );
    this.baseMagicNumber = 1;
    this.magicNumber = this.baseMagicNumber;
  }

  public void triggerWhenDrawn() {
    addToBot((AbstractGameAction) new GainEnergyAction(this.magicNumber));
  }

  public void triggerOnManualDiscard() {
    addToBot((AbstractGameAction) new GainEnergyAction(this.magicNumber));
  }

  public boolean canUse(AbstractPlayer p, AbstractMonster m) {
    return false;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {}

  public AbstractCard makeCopy() {
    return (AbstractCard) new No15();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
      upgradeMagicNumber(1);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No15.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
