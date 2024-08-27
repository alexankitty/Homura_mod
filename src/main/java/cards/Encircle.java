package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import patches.Patch;

public class Encircle extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Encircle"); public static final String ID = "Encircle";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/Encircle_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 2;
  private static final int UPGRADE_PLUS_DMG = 1;
  
  public Encircle() {
    super("Encircle", NAME, "img/cards/Encircle_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
    this.baseDamage = 2;
    this.baseMagicNumber = 0;
    this.magicNumber = this.baseMagicNumber;
  }


  
  public void use(AbstractPlayer p, AbstractMonster m) {
    for (int i = 0; i < Patch.countServantNum(); i++) {
      addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }
  }

  
  public void calculateCardDamage(AbstractMonster m) {
    if (m == null) {
      return;
    }
    this.baseMagicNumber = Patch.countServantNum();
    int realBaseDamage = this.baseDamage;
    if (m.hasPower("Minion")) {
      this.baseDamage *= 2;
    }
    super.calculateCardDamage(m);
    this.baseDamage = realBaseDamage;
    this.isDamageModified = (this.damage != this.baseDamage);
  }
  
  public void applyPowers() {
    this.baseMagicNumber = Patch.countServantNum();
    super.applyPowers();
  }
  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Encircle();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(1);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Encircle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */