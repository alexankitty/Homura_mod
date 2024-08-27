package cards;
import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import patches.Patch;
import powers.StockPower;
import powers.StockUpPower;

public class Stock extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Stock"); public static final String ID = "Stock";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/Stock_power.png";
  private float rotationTimer = 0.0F;
  private int previewIndex = 0;
  public Stock() {
    super("Stock", NAME, "img/cards/Stock_power.png", 1, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    if (this.upgraded) {
      addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StockUpPower((AbstractCreature)p, 1)));
    } else {
      addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StockPower((AbstractCreature)p, 1)));
    } 
  }


  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Stock();
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


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Stock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */