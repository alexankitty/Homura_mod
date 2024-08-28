package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import patches.Patch;

public class Alone extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Alone");
  public static final String ID = "Alone";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 2;
  public static final String IMG_PATH = "img/cards/Alone_skill.png";

  public Alone() {
    super(
      "Alone",
      NAME,
      "img/cards/Alone_skill.png",
      2,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.SELF
    );
    this.baseMagicNumber = 1;
    this.magicNumber = this.baseMagicNumber;
    this.baseBlock = 0;
    this.cardsToPreview = (AbstractCard) new Despair();
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new GainBlockAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        this.block
      )
    );
    AbstractCard c = (new Despair()).makeCopy();
    addToBot((AbstractGameAction) new MakeTempCardInDiscardAction(c, 1));
  }

  public void calculateCardDamage(AbstractMonster m) {
    this.baseBlock = Patch.countHighlander();
    if (this.upgraded) {
      this.baseBlock += Patch.countCurse();
    }
    super.calculateCardDamage(m);
  }

  public void applyPowers() {
    this.baseBlock = Patch.countHighlander();
    if (this.upgraded) {
      this.baseBlock += Patch.countCurse();
    }
    super.applyPowers();
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Alone();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Alone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
