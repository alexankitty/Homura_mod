package cards;
import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import java.util.Iterator;
import patches.Patch;

public class Suppress extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Suppress"); public static final String ID = "Suppress";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/Suppress_skill.png";
  private static final int COST = 0;
  
  public Suppress() {
    super("Suppress", NAME, "img/cards/Suppress_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ALL_ENEMY);
    this.baseMagicNumber = 0;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    Iterator<AbstractMonster> monsterGroup = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
    while (monsterGroup.hasNext()) {
      AbstractMonster mo = monsterGroup.next();
      if (Patch.countCurse() >= 5) {
        addToBot((AbstractGameAction)new StunMonsterAction(mo, (AbstractCreature)p, 1)); continue;
      } 
      addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, 1, false), 1, true, AbstractGameAction.AttackEffect.NONE));
    } 
  }
  
  public void calculateCardDamage(AbstractMonster mo) {
    this.baseMagicNumber = Patch.countCurse();
    super.calculateCardDamage(mo);
  }
  public void applyPowers() {
    this.baseMagicNumber = Patch.countCurse();
    super.applyPowers();
  }
  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Suppress();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
      this.selfRetain = true;
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Suppress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */