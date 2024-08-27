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
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class No14 extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No14"); public static final String ID = "No14";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/No14_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 8;
  private static final int UPGRADE_PLUS_DMG = 3;

  public No14() {
    super("No14", NAME, "img/cards/No14_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
    this.baseDamage = 8;
    this.selfRetain = true;
  }


  public void triggerWhenDrawn() {}


  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
  }

  public void triggerOnManualDiscard() {
    addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
  }



  public AbstractCard makeCopy() {
    return (AbstractCard)new No14();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(3);
    }
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No14.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */