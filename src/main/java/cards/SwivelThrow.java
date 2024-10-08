package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.BetterDrawPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SwivelThrow extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("SwivelThrow");
  public static final String ID = "SwivelThrow";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 2;
  private static final int BLOCK_AMT = 8;
  private static final int UPGRADE_PLUS_BLOCK = 4;
  public static final String IMG_PATH = "img/cards/SwivelThrow_skill.png";

  public SwivelThrow() {
    super(
      "SwivelThrow",
      NAME,
      "img/cards/SwivelThrow_skill.png",
      2,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.SELF
    );
    this.baseBlock = 8;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new GainBlockAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        this.block
      )
    );
    addToBot((AbstractGameAction) new BetterDrawPileToHandAction(1));
    addToBot(
      (AbstractGameAction) new DiscardAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        1,
        false
      )
    );
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new SwivelThrow();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBlock(4);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/SwivelThrow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
