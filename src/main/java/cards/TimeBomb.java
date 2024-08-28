package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import powers.TimeBombPower;

public class TimeBomb extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("TimeBomb");
  public static final String ID = "TimeBomb";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final String IMG_PATH = "img/cards/TimeBomb_skill.png";
  private static final int COST = 2;

  public TimeBomb() {
    super(
      "TimeBomb",
      NAME,
      "img/cards/TimeBomb_skill.png",
      2,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.ENEMY
    );
    this.baseMagicNumber = 20;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new ApplyPowerAction(
        (AbstractCreature) m,
        (AbstractCreature) p,
        (AbstractPower) new TimeBombPower(
          (AbstractCreature) m,
          1,
          this.magicNumber
        ),
        2,
        true,
        AbstractGameAction.AttackEffect.NONE
      )
    );
  }

  public void triggerOnManualDiscard() {
    addToTop(
      (AbstractGameAction) new NewQueueCardAction(
        (AbstractCard) this,
        (AbstractCreature) AbstractDungeon.getRandomMonster(),
        false,
        true
      )
    );
    AbstractDungeon.player.discardPile.group.remove(this);
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new TimeBomb();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(10);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/TimeBomb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
