package cards;

import EgoMod.HomuraMod;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.NecronomicurseEffect;

public class CauseAndEffect extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("CauseAndEffect");
  public static final String ID = "CauseAndEffect";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = -2;

  public static final String IMG_PATH = "img/cards/CauseAndEffect.png";

  public CauseAndEffect() {
    super(
      "CauseAndEffect",
      NAME,
      "img/cards/CauseAndEffect.png",
      -2,
      DESCRIPTION,
      AbstractCard.CardType.CURSE,
      AbstractCard.CardColor.CURSE,
      AbstractCard.CardRarity.SPECIAL,
      AbstractCard.CardTarget.NONE
    );
    this.baseMagicNumber = 0;
    this.magicNumber = this.baseMagicNumber;
  }

  public static void loadGame() {
    if (
      AbstractDungeon.player == null ||
      AbstractDungeon.player.masterDeck == null
    ) {
      return;
    }
    AbstractDungeon.player.masterDeck.group
      .stream()
      .filter(c -> c instanceof CauseAndEffect)
      .forEach(CauseAndEffect::load);
  }

  private static void load(AbstractCard c) {
    c.baseMagicNumber = HomuraMod.getSaveLoadCount();
    c.magicNumber = c.baseMagicNumber;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {}

  public void onRemoveFromMasterDeck() {
    AbstractDungeon.effectsQueue.add(
      new NecronomicurseEffect(
        (AbstractCard) new CauseAndEffect(),
        Settings.WIDTH / 2.0F,
        Settings.HEIGHT / 2.0F
      )
    );
    load((AbstractCard) this);
  }

  public void triggerOnExhaust() {
    addToBot((AbstractGameAction) new MakeTempCardInHandAction(makeCopy()));
    load((AbstractCard) this);
  }

  public void calculateCardDamage(AbstractMonster m) {
    this.baseMagicNumber = HomuraMod.getSaveLoadCount();
    this.magicNumber = this.baseMagicNumber;
  }

  public void applyPowers() {
    this.baseMagicNumber = HomuraMod.getSaveLoadCount();
    this.magicNumber = this.baseMagicNumber;
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new CauseAndEffect();
  }

  public void upgrade() {}
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/CauseAndEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
