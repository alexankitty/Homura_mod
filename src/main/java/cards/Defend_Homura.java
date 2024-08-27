package cards;
import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defend_Homura extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Defend_Homura"); public static final String ID = "Defend_Homura";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  private static final int COST = 1;
  private static final int BLOCK_AMT = 5;
  private static final int UPGRADE_PLUS_BLOCK = 3;
  public static final String IMG_PATH = "img/cards/Defend_Homura_skill.png";
  
  public Defend_Homura() {
    super("Defend_Homura", NAME, "img/cards/Defend_Homura_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.BASIC, AbstractCard.CardTarget.SELF);
    this.tags.add(AbstractCard.CardTags.STARTER_DEFEND);
    this.baseBlock = 5;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Defend_Homura();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBlock(3);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Defend_Homura.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */