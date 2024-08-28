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

public class No8 extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("No8");
  public static final String ID = "No8";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/No8_attack.png";
  private static final int COST = 1;

  public No8() {
    super(
      "No8",
      NAME,
      "img/cards/No8_attack.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.COMMON,
      AbstractCard.CardTarget.NONE
    );
    this.baseDamage = 9;
    this.damage = this.baseDamage;
  }

  public void triggerWhenDrawn() {}

  public void use(AbstractPlayer p, AbstractMonster m) {
    m = AbstractDungeon.getRandomMonster();
    if (m == null) {
      return;
    }
    for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
      if (mo.currentHealth > m.currentHealth) {
        m = mo;
      }
    }
    addToBot(
      (AbstractGameAction) new DamageAction(
        (AbstractCreature) m,
        new DamageInfo(
          (AbstractCreature) p,
          this.damage,
          this.damageTypeForTurn
        ),
        AbstractGameAction.AttackEffect.SLASH_HORIZONTAL
      )
    );
  }

  public void triggerOnManualDiscard() {
    addToBot(
      (AbstractGameAction) new ServantAction((AbstractCard) this, false)
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new No8();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(3);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No8.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
