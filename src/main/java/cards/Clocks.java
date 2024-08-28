package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.purple.Vault;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import powers.ClocksPower;
import powers.ClocksUpPower;

public class Clocks extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Clocks");
  public static final String ID = "Clocks";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 2;
  public static final String IMG_PATH = "img/cards/Clocks_power.png";

  public Clocks() {
    super(
      "Clocks",
      NAME,
      "img/cards/Clocks_power.png",
      2,
      DESCRIPTION,
      AbstractCard.CardType.POWER,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.RARE,
      AbstractCard.CardTarget.SELF
    );
    this.cardsToPreview = (AbstractCard) new Vault();
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    if (this.upgraded) {
      addToBot(
        (AbstractGameAction) new ApplyPowerAction(
          (AbstractCreature) p,
          (AbstractCreature) p,
          (AbstractPower) new ClocksUpPower((AbstractCreature) p, 1)
        )
      );
    } else {
      addToBot(
        (AbstractGameAction) new ApplyPowerAction(
          (AbstractCreature) p,
          (AbstractCreature) p,
          (AbstractPower) new ClocksPower((AbstractCreature) p, 1)
        )
      );
    }
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Clocks();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.cardsToPreview.upgrade();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Clocks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
