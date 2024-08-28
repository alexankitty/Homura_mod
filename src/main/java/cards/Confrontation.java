package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Confrontation extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Confrontation");
  public static final String ID = "Confrontation";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 1;
  private static final int BLOCK_AMT = 12;
  private static final int UPGRADE_PLUS_BLOCK = 4;
  public static final String IMG_PATH = "img/cards/Confrontation_skill.png";

  public Confrontation() {
    super(
      "Confrontation",
      NAME,
      "img/cards/Confrontation_skill.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.SELF
    );
    this.baseBlock = 12;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot(
      (AbstractGameAction) new GainBlockAction(
        (AbstractCreature) p,
        (AbstractCreature) p,
        this.block
      )
    );
    addToBot((AbstractGameAction) new PressEndTurnButtonAction());
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Confrontation();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBlock(4);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Confrontation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
