package cards;
import EgoMod.AbstractCardEnum;
import action.ServantAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.curses.Shame;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class No11 extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No11"); public static final String ID = "No11";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/No11_skill.png";
  private static final int COST = 1;
  private static final int BLOCK_AMT = 12;
  private static final int UPGRADE_PLUS_BLOCK = 3;
  
  public No11() {
    super("No11", NAME, "img/cards/No11_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.SELF);
    this.baseBlock = 12;
    this.cardsToPreview = (AbstractCard)new Shame();
  }

  
  public void triggerWhenDrawn() {}
  
  public void triggerOnManualDiscard() {
    addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
    AbstractDungeon.player.discardPile.group.remove(this);
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new No11();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBlock(3);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */