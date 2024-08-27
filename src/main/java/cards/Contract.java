package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.purple.Wish;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Contract extends CustomCard {
  public static final String ID = "Contract";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Contract");
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/Contract_skill.png";
  
  public Contract() {
    super("Contract", NAME, "img/cards/Contract_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
    this.cardsToPreview = (AbstractCard)new Wish();
    this.exhaust = true;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractCard c = (new Wish()).makeCopy();
    if (this.upgraded) {
      c.upgrade();
    }
    c.setCostForTurn(0);
    addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, 1));
    
    c = AbstractDungeon.returnRandomCurse().makeCopy();
    addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(c, 1));
  }



  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Contract();
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


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Contract.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */