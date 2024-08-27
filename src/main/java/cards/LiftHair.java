package cards;
import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class LiftHair extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("LiftHair"); public static final String ID = "LiftHair";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  private static final int COST = 0;
  public static final String IMG_PATH = "img/cards/LiftHair_skill.png";
  
  public LiftHair() {
    super("LiftHair", NAME, "img/cards/LiftHair_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.SELF);
    this.baseMagicNumber = 1;
    this.magicNumber = this.baseMagicNumber;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
    addToBot((AbstractGameAction)new DiscardAction((AbstractCreature)p, (AbstractCreature)p, this.magicNumber, false));
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new LiftHair();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(1);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/LiftHair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */