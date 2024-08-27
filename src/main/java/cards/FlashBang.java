package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class FlashBang extends CustomCard {
  public static final String ID = "FlashBang";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FlashBang");
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/FlashBang_skill.png";
  private static final int COST = 1;
  
  public FlashBang() {
    super("FlashBang", NAME, "img/cards/FlashBang_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ALL_ENEMY);
    this.baseMagicNumber = 2;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
      addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
      addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
    } 
  }
  
  public void triggerOnManualDiscard() {
    addToTop((AbstractGameAction)new NewQueueCardAction((AbstractCard)this, null, false, true));
    AbstractDungeon.player.discardPile.group.remove(this);
  }
  
  public AbstractCard makeCopy() {
    return (AbstractCard)new FlashBang();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(1);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/FlashBang.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */