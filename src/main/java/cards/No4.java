package cards;

import EgoMod.AbstractCardEnum;
import action.ServantAction;
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
import com.megacrit.cardcrawl.powers.ArtifactPower;

public class No4 extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("No4");
  public static final String ID = "No4";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  public static final String IMG_PATH = "img/cards/No4_skill.png";
  private static final int COST = 1;

  public No4() {
    super(
      "No4",
      NAME,
      "img/cards/No4_skill.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.SELF
    );
    this.baseMagicNumber = 1;
    this.magicNumber = this.baseMagicNumber;
  }

  public void triggerWhenDrawn() {}

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new ApplyPowerAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        (AbstractPower) new ArtifactPower(
          (AbstractCreature) p,
          this.magicNumber
        ),
        this.magicNumber
      )
    );
  }

  public void triggerOnManualDiscard() {
    addToBot(
      (AbstractGameAction) new ServantAction((AbstractCard) this, false)
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new No4();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(1);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
