package cards;
import EgoMod.AbstractCardEnum;
import action.ProductionAction;
import basemod.abstracts.CustomCard;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import patches.Patch;

public class Production extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Production"); public static final String ID = "Production";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = 3;
  private float rotationTimer = 0.0F;
  private int previewIndex = 0;
  public static final String IMG_PATH = "img/cards/Prodution_skill.png";

  public Production() {
    super("Production", NAME, "img/cards/Prodution_skill.png", 3, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
    this.exhaust = true;
  }


  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new ProductionAction((AbstractCreature)p, 11 - p.hand.size()));
  }

  public void update() {
    super.update();
    if (this.hb.hovered) {
      AbstractCard[] ArmList = Patch.getArmsCard();
      if (this.rotationTimer <= 0.0F) {
        this.rotationTimer = 0.5F;
        this.cardsToPreview = ArmList[this.previewIndex];

        if (this.previewIndex == ArmList.length - 1) {
          this.previewIndex = 0;
        } else {
          this.previewIndex++;
        }

        if (this.upgraded) {
          this.cardsToPreview.upgrade();
        }
      } else {

        this.rotationTimer -= Gdx.graphics.getDeltaTime();
      }
    }
  }

  public AbstractCard makeCopy() {
    return (AbstractCard)new Production();
  }


  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBaseCost(2);
    }
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Production.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */