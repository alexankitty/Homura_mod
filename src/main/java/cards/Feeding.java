package cards;

import EgoMod.AbstractCardEnum;
import action.FeedingAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Feeding extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Feeding");
  public static final String ID = "Feeding";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/Feeding_skill.png";

  public Feeding() {
    super(
      "Feeding",
      NAME,
      "img/cards/Feeding_skill.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.SELF
    );
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction) new FeedingAction(1, false, false, false));
    addToBot((AbstractGameAction) new DrawCardAction((AbstractCreature) p, 1));
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Feeding();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBaseCost(0);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Feeding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
