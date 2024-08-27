package cards;
import EgoMod.AbstractCardEnum;
import action.GunsWorkBetterThanMagicAction;
import basemod.abstracts.CustomCard;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import patches.Patch;

public class GunsWorkBetterThanMagic extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GunsWorkBetterThanMagic"); public static final String ID = "GunsWorkBetterThanMagic";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = -1;
  public static final String IMG_PATH = "img/cards/GunsWorkBetterThanMagic_skill.png";
  private float rotationTimer = 0.0F;
  private int previewIndex = 0;
  public GunsWorkBetterThanMagic() {
    super("GunsWorkBetterThanMagic", NAME, "img/cards/GunsWorkBetterThanMagic_skill.png", -1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
    this.exhaust = true;
  }


  public void use(AbstractPlayer p, AbstractMonster m) {
    if (this.energyOnUse < EnergyPanel.totalCount) {
      this.energyOnUse = EnergyPanel.totalCount;
    }
    addToBot((AbstractGameAction)new GunsWorkBetterThanMagicAction(p, this.upgraded, this.freeToPlayOnce, this.energyOnUse));
  }


  public AbstractCard makeCopy() {
    return (AbstractCard)new GunsWorkBetterThanMagic();
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

  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
    }
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/GunsWorkBetterThanMagic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */