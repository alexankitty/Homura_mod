package cards;

import EgoMod.AbstractCardEnum;
import action.ServantAction;
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
import com.megacrit.cardcrawl.powers.SlowPower;

public class No9 extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("No9");
  public static final String ID = "No9";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/No9_skill.png";
  private static final int COST = 1;

  public No9() {
    super(
      "No9",
      NAME,
      "img/cards/No9_skill.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.ALL_ENEMY
    );
    this.baseMagicNumber = 3;
    this.magicNumber = this.baseMagicNumber;
  }

  public void triggerWhenDrawn() {}

  public void use(AbstractPlayer p, AbstractMonster m) {
    if (this.upgraded) {
      for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
        addToBot(
          (AbstractGameAction) new ApplyPowerAction(
            (AbstractCreature) mo,
            (AbstractCreature) AbstractDungeon.player,
            (AbstractPower) new SlowPower(
              (AbstractCreature) mo,
              this.magicNumber
            ),
            this.magicNumber,
            true,
            AbstractGameAction.AttackEffect.NONE
          )
        );
      }
    } else {
      m = AbstractDungeon.getRandomMonster();
      addToBot(
        (AbstractGameAction) new ApplyPowerAction(
          (AbstractCreature) m,
          (AbstractCreature) AbstractDungeon.player,
          (AbstractPower) new SlowPower((AbstractCreature) m, this.magicNumber),
          this.magicNumber,
          true,
          AbstractGameAction.AttackEffect.NONE
        )
      );
    }
  }

  public void triggerOnManualDiscard() {
    addToBot(
      (AbstractGameAction) new ServantAction((AbstractCard) this, false)
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new No9();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No9.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
