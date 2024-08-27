package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class Smoke extends CustomCard {
  public static final String ID = "Smoke";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Smoke");
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/Smoke_skill.png";
  private static final int COST = 1;
  
  public Smoke() {
    super("Smoke", NAME, "img/cards/Smoke_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ALL_ENEMY);
    this.baseMagicNumber = 1;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
    this.baseBlock = 5;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
    for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
      addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    }
  }
  
  public void triggerOnManualDiscard() {
    addToTop((AbstractGameAction)new NewQueueCardAction((AbstractCard)this, null, false, true));
    AbstractDungeon.player.discardPile.group.remove(this);
  }
  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Smoke();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBlock(2);
      upgradeMagicNumber(1);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Smoke.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */