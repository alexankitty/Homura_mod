package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DodgeShot extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("DodgeShot");
  public static final String ID = "DodgeShot";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 1;
  private static final int BLOCK_AMT = 5;
  private static final int ATTACK_DMG = 5;
  private static final int UPGRADE_PLUS_BLOCK = 2;
  private static final int UPGRADE_PLUS_DMG = 2;
  public static final String IMG_PATH = "img/cards/DodgeShot_attack.png";

  public DodgeShot() {
    super(
      "DodgeShot",
      NAME,
      "img/cards/DodgeShot_attack.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.ATTACK,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.COMMON,
      AbstractCard.CardTarget.ENEMY
    );
    this.baseBlock = 5;
    this.baseDamage = 5;
    this.baseMagicNumber = 1;
    this.magicNumber = this.baseMagicNumber;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new DiscardAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        1,
        false
      )
    );
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
    addToTop(
      (AbstractGameAction) new GainBlockAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        this.block
      )
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new DodgeShot();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBlock(2);
      upgradeDamage(2);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/DodgeShot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
