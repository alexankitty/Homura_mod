package cards;
import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Flash extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Flash"); public static final String ID = "Flash";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  private static final int COST = 1;
  
  private static final int BLOCK_AMT = 5;
  private static final int UPGRADE_PLUS_BLOCK = 3;
  public static final String IMG_PATH = "img/cards/Flash_skill.png";
  
  public Flash() {
    super("Flash", NAME, "img/cards/Flash_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.SELF);
    this.baseBlock = 5;
    this.baseMagicNumber = 2;
    this.magicNumber = this.baseMagicNumber;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
    addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
    addToBot((AbstractGameAction)new DiscardAction((AbstractCreature)p, (AbstractCreature)p, 1, false));
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Flash();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBlock(3);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Flash.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */