package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ThePriceOfMiracles extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("ThePriceOfMiracles");
  public static final String ID = "ThePriceOfMiracles";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  public static final String IMG_PATH =
    "img/cards/ThePriceOfMiracles_skill.png";
  private static final int COST = 0;

  public ThePriceOfMiracles() {
    super(
      "ThePriceOfMiracles",
      NAME,
      "img/cards/ThePriceOfMiracles_skill.png",
      0,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.COMMON,
      AbstractCard.CardTarget.ALL_ENEMY
    );
    this.cardsToPreview = (AbstractCard) new Miracle();
    this.baseMagicNumber = 2;
    this.magicNumber = this.baseMagicNumber;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new MakeTempCardInHandAction(
        (AbstractCard) new Miracle(),
        this.magicNumber
      )
    );
    AbstractCard card = AbstractDungeon.returnRandomCurse().makeCopy();
    addToBot((AbstractGameAction) new MakeTempCardInDiscardAction(card, 1));
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new ThePriceOfMiracles();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(1);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/ThePriceOfMiracles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
