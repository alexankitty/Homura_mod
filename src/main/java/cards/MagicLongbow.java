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

public class MagicLongbow extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("MagicLongbow");
  public static final String ID = "MagicLongbow";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/MagicLongbow_attack.png";
  private static final int COST = 1;
  private static final int ATTACK_DMG = 14;
  private static final int UPGRADE_PLUS_DMG = 4;

  public MagicLongbow() {
    super(
      "MagicLongbow",
      NAME,
      "img/cards/MagicLongbow_attack.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.RARE,
      AbstractCard.CardTarget.ENEMY
    );
    this.baseDamage = 14;
    this.selfRetain = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    if (m == null) {
      return;
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
    m.rollMove();
    m.createIntent();
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new MagicLongbow();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeDamage(4);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/MagicLongbow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
