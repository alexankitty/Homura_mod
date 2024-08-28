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
import powers.MoveAndFirePower;

public class MoveAndFire extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("MoveAndFire");
  public static final String ID = "MoveAndFire";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 1;

  public static final String IMG_PATH = "img/cards/MoveAndFire_power.png";

  public MoveAndFire() {
    super(
      "MoveAndFire",
      NAME,
      "img/cards/MoveAndFire_power.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.POWER,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.SELF
    );
    this.baseMagicNumber = 2;
    this.magicNumber = this.baseMagicNumber;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new ApplyPowerAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        (AbstractPower) new MoveAndFirePower(
          (AbstractCreature) p,
          this.magicNumber
        )
      )
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new MoveAndFire();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(1);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/MoveAndFire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
