package cards;
import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Puzzle extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Puzzle"); public static final String ID = "Puzzle";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/Puzzle_skill.png";
  
  public Puzzle() {
    super("Puzzle", NAME, "img/cards/Puzzle_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.SELF);
    this.misc = 5;
    this.baseBlock = this.misc;
    this.block = this.baseBlock;
  }
  public static void loadMagicNumber() {
    if (AbstractDungeon.player == null || AbstractDungeon.player.masterDeck == null) {
      return;
    }
    AbstractDungeon.player.masterDeck.group.stream().filter(c -> c instanceof Puzzle).forEach(Puzzle::load);
  }
  private static void load(AbstractCard c) {
    c.baseBlock = c.misc;
  }
  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
  }


  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Puzzle();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.misc += 3;
      this.baseBlock = this.misc;
    } 
  }

  
  public void applyPowers() {
    if (this.baseBlock < this.misc) {
      this.baseBlock = this.misc;
    }
    initializeDescription();
    super.applyPowers();
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Puzzle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */