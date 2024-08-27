package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
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
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import java.util.Iterator;
import patches.Patch;

public class Mud extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Mud"); public static final String ID = "Mud";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/Mud_skill.png";
  private static final int COST = 1;
  
  public Mud() {
    super("Mud", NAME, "img/cards/Mud_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ALL_ENEMY);
    this.baseMagicNumber = 0;
    this.magicNumber = this.baseMagicNumber;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    Iterator<AbstractMonster> monsterGroup = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
    this.magicNumber = Patch.countCurse();
    while (monsterGroup.hasNext()) {
      AbstractMonster mo = monsterGroup.next();
      addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
      addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
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
    return (AbstractCard)new Mud();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBaseCost(0);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Mud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */