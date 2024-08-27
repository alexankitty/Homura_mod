package cards;

import EgoMod.AbstractCardEnum;
import action.TreatmentAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Treatment extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Treatment"); public static final String ID = "Treatment";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  private static final int COST = 0;
  public static final String IMG_PATH = "img/cards/Treatment_skill.png";
  
  public Treatment() {
    super("Treatment", NAME, "img/cards/Treatment_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
    this.exhaust = true;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToTop((AbstractGameAction)new TreatmentAction());
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Treatment();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.selfRetain = true;
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Treatment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */