package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Hope extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Hope");
  public static final String ID = "Hope";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 0;
  public static final String IMG_PATH = "img/cards/Hope_skill.png";

  public Hope() {
    super(
      "Hope",
      NAME,
      "img/cards/Hope_skill.png",
      0,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.SELF
    );
    this.baseMagicNumber = 8;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
    this.cardsToPreview = (AbstractCard) new Despair();
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new HealAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        this.magicNumber
      )
    );
    AbstractCard c = (new Despair()).makeCopy();
    addToBot((AbstractGameAction) new MakeTempCardInDiscardAction(c, 1));
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Hope();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(2);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Hope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
