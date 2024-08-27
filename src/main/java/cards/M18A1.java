package cards;

import EgoMod.AbstractCardEnum;
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
import powers.M18A1Power;

public class M18A1
  extends CustomCard {
  public static final String ID = "M18A1";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("M18A1");
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  private static final int COST = 2;
  public static final String IMG_PATH = "img/cards/M18A1_skill.png";
  
  public M18A1() {
    super("M18A1", NAME, "img/cards/M18A1_skill.png", 2, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
    this.baseMagicNumber = 3;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new M18A1Power((AbstractCreature)p, this.magicNumber), this.magicNumber));
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new M18A1();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(2);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/M18A1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */