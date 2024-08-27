package cards;
import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import powers.LawOfCyclesPower;

public class LawOfCycles extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("LawOfCycles"); public static final String ID = "LawOfCycles";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  private static final int COST = 3;
  public static final String IMG_PATH = "img/cards/LawOfCycles_power.png";
  
  public LawOfCycles() {
    super("LawOfCycles", NAME, "img/cards/LawOfCycles_power.png", 3, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
    this.cardsToPreview = (AbstractCard)new Miracle();
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new LawOfCyclesPower((AbstractCreature)p, 1)));
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new LawOfCycles();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBaseCost(2);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/LawOfCycles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */