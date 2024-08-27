package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import patches.Patch;

public class Maze extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Maze"); public static final String ID = "Maze";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = 0;
  public static final String IMG_PATH = "img/cards/Maze_skill.png";
  
  public Maze() {
    super("Maze", NAME, "img/cards/Maze_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
    this.baseMagicNumber = 0;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
    this.cardsToPreview = (AbstractCard)new Despair();
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    this.magicNumber = Patch.countSL();
    addToBot((AbstractGameAction)new DrawCardAction(this.magicNumber));
    AbstractCard c = (new Despair()).makeCopy();
    addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(c, 1));
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
    return (AbstractCard)new Maze();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
      this.exhaust = false;
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Maze.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */