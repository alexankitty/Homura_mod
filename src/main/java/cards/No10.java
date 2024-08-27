package cards;

import EgoMod.AbstractCardEnum;
import action.ServantAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class No10 extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No10"); public static final String ID = "No10";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  public static final String IMG_PATH = "img/cards/No10_attack.png";
  private static final int COST = 1;
  
  public No10() {
    super("No10", NAME, "img/cards/No10_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
    this.baseDamage = 0;
    this.damage = this.baseDamage;
    this.baseMagicNumber = 3;
    this.magicNumber = this.baseMagicNumber;
  }

  
  public void triggerWhenDrawn() {}

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
  }

  
  public void triggerOnManualDiscard() {
    addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
  }
  public void calculateCardDamage(AbstractMonster m) {
    this.baseDamage = AbstractDungeon.player.gold / 50 * this.magicNumber;
    super.calculateCardDamage(m);
  }
  public void applyPowers() {
    this.baseDamage = AbstractDungeon.player.gold / 50 * this.magicNumber;
    super.applyPowers();
  }
  
  public AbstractCard makeCopy() {
    return (AbstractCard)new No10();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(1);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */