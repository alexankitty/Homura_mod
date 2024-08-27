package cards;

import EgoMod.AbstractCardEnum;
import action.ServantAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class No5 extends CustomCard {
  public static final String ID = "No5";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No5");
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/No5_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 9;
  private static final int UPGRADE_PLUS_DMG = 3;
  
  public No5() {
    super("No5", NAME, "img/cards/No5_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ALL_ENEMY);
    this.baseDamage = 9;
  }


  
  public void triggerWhenDrawn() {}

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new AttackDamageRandomEnemyAction((AbstractCard)this, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
  }
  
  public void triggerOnManualDiscard() {
    addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
  }
  
  public AbstractCard makeCopy() {
    return (AbstractCard)new No5();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(3);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */