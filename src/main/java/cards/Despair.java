package cards;

import EgoMod.HomuraMod;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import patches.Patch;

public class Despair extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Despair");
  public static final String ID = "Despair";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = -2;

  public static final String IMG_PATH = "img/cards/Despair.png";

  public Despair() {
    super(
      "Despair",
      NAME,
      "img/cards/Despair.png",
      -2,
      DESCRIPTION,
      AbstractCard.CardType.CURSE,
      AbstractCard.CardColor.CURSE,
      AbstractCard.CardRarity.CURSE,
      AbstractCard.CardTarget.NONE
    );
    this.baseMagicNumber = 0;
    this.magicNumber = this.baseMagicNumber;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    if (
      this.dontTriggerOnUseCard &&
      AbstractDungeon.player.masterDeck.findCardById("CauseAndEffect") != null
    ) {
      addToTop(
        (AbstractGameAction) new LoseHPAction(
          (AbstractCreature) AbstractDungeon.player,
          (AbstractCreature) AbstractDungeon.player,
          this.magicNumber,
          AbstractGameAction.AttackEffect.FIRE
        )
      );
    }
  }

  public void calculateCardDamage(AbstractMonster m) {
    this.baseMagicNumber = HomuraMod.getSaveLoadCount();
    this.magicNumber = this.baseMagicNumber;
  }

  public void applyPowers() {
    this.baseMagicNumber = HomuraMod.getSaveLoadCount();
    this.magicNumber = this.baseMagicNumber;
  }

  public void triggerOnEndOfTurnForPlayingCard() {
    this.dontTriggerOnUseCard = true;
    this.magicNumber = this.baseMagicNumber = Patch.countSL();
    AbstractDungeon.actionManager.cardQueue.add(
      new CardQueueItem((AbstractCard) this, true)
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Despair();
  }

  public void upgrade() {}
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Despair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
