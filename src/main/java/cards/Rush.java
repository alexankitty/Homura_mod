package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Rush extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Rush"); public static final String ID = "Rush";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/Rush_skill.png";
  
  public Rush() {
    super("Rush", NAME, "img/cards/Rush_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
    this.baseMagicNumber = 3;
    this.magicNumber = this.baseMagicNumber;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new DrawCardAction(this.magicNumber));
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Rush();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(1);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Rush.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */