package cards;

import EgoMod.AbstractCardEnum;
import action.ServantAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import java.util.ArrayList;

public class No7 extends CustomCard {
  public static final String ID = "No7";
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No7");
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/No7_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 6;
  private static final int UPGRADE_PLUS_DMG = 2;
  
  public No7() {
    super("No7", NAME, "img/cards/No7_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
    this.baseDamage = 6;
  }


  
  public void triggerWhenDrawn() {}

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    if (m == null) {
      return;
    }
    addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    
    if (m.type != AbstractMonster.EnemyType.BOSS)
    {
      if (this.upgraded) {
        for (AbstractPower pow : m.powers) {
          if (pow.type == AbstractPower.PowerType.BUFF && 
            !pow.ID.equals("Fading") && 
            !pow.ID.equals("Shifting") && 
            !pow.ID.equals("Life Link")) {
            AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)m, (AbstractCreature)p, pow));
          }
        }
      
      } else if (!m.powers.isEmpty()) {
        ArrayList<AbstractPower> pows = new ArrayList<>();
        for (AbstractPower pow : m.powers) {
          if (pow.type == AbstractPower.PowerType.BUFF && 
            !pow.ID.equals("Fading") && 
            !pow.ID.equals("Shifting") && 
            !pow.ID.equals("Life Link")) {
            pows.add(pow);
          }
        } 
        if (!pows.isEmpty()) {
          AbstractPower po = pows.get((int)(Math.random() * pows.size()));
          AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)m, (AbstractCreature)p, po));
        } 
      } 
    }
  }



  
  public void triggerOnManualDiscard() {
    addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
  }
  
  public AbstractCard makeCopy() {
    return (AbstractCard)new No7();
  }
  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
      upgradeDamage(2);
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No7.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */