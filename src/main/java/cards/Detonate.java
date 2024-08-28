package cards;

import EgoMod.AbstractCardEnum;
import action.DetonateAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Detonate extends CustomCard {

  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("Detonate");
  public static final String ID = "Detonate";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/Detonate_skill.png";

  public Detonate() {
    super(
      "Detonate",
      NAME,
      "img/cards/Detonate_skill.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.SELF
    );
    this.baseMagicNumber = 1;
    this.magicNumber = this.baseMagicNumber;
    this.selfRetain = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction) new DetonateAction(this.magicNumber));
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new Detonate();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBaseCost(0);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Detonate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
