package cards;

import EgoMod.AbstractCardEnum;
import action.CleanAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Clean extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Clean");
  public static final String ID = "Clean";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/Clean_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 9;
  private static final int UPGRADE_PLUS_DMG = 3;

  public Clean() {
    super(
      "Clean",
      NAME,
      "img/cards/Clean_attack.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.ENEMY
    );
    this.baseDamage = 9;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    DamageInfo DI = new DamageInfo(
      (AbstractCreature) p,
      this.damage,
      this.damageTypeForTurn
    );
    addToBot(
      (AbstractGameAction) new CleanAction(
        (AbstractCreature) m,
        DI,
        (AbstractCard) this
      )
    );
  }

  public void calculateCardDamage(AbstractMonster m) {
    if (m == null) {
      return;
    }
    int realBaseDamage = this.baseDamage;
    if (m.hasPower("Minion")) {
      this.baseDamage *= 2;
    }
    super.calculateCardDamage(m);
    this.baseDamage = realBaseDamage;
    this.isDamageModified = (this.damage != this.baseDamage);
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Clean();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(3);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Clean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
