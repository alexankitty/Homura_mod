package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import powers.UntiePower;

public class Untie extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Untie");
  public static final String ID = "Untie";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 2;
  public static final String IMG_PATH = "img/cards/Untie_power.png";

  public Untie() {
    super(
      "Untie",
      NAME,
      "img/cards/Untie_power.png",
      2,
      DESCRIPTION,
      AbstractCard.CardType.POWER,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.RARE,
      AbstractCard.CardTarget.SELF
    );
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new ApplyPowerAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        (AbstractPower) new UntiePower((AbstractCreature) p)
      )
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Untie();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBaseCost(1);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Untie.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
