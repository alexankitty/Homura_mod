package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ModifyMemory extends CustomCard {

  public static final String ID = "ModifyMemory";
  private static final CardStrings cardStrings =
    CardCrawlGame.languagePack.getCardStrings("ModifyMemory");
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/ModifyMemory_skill.png";

  public ModifyMemory() {
    super(
      "ModifyMemory",
      NAME,
      "img/cards/ModifyMemory_skill.png",
      1,
      DESCRIPTION,
      AbstractCard.CardType.SKILL,
      AbstractCardEnum.Homura_COLOR,
      AbstractCard.CardRarity.UNCOMMON,
      AbstractCard.CardTarget.ENEMY
    );
    this.selfRetain = true;
  }

  public void use(AbstractPlayer p, AbstractMonster m) {
    if (m == null) {
      return;
    }
    m.rollMove();
    m.createIntent();
  }

  public AbstractCard makeCopy() {
    return (AbstractCard) new ModifyMemory();
  }

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBaseCost(0);
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/ModifyMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
