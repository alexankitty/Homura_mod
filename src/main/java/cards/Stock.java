/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import patches.Patch;
import powers.StockPower;
import powers.StockUpPower;

/*    */
/*    */ public class Stock extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Stock"); public static final String ID = "Stock";
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   private static final int COST = 1;
/*    */   public static final String IMG_PATH = "img/cards/Stock_power.png";
/* 22 */   private float rotationTimer = 0.0F;
/* 23 */   private int previewIndex = 0;
/*    */   public Stock() {
/* 25 */     super("Stock", NAME, "img/cards/Stock_power.png", 1, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 30 */     if (this.upgraded) {
/* 31 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StockUpPower((AbstractCreature)p, 1)));
/*    */     } else {
/* 33 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StockPower((AbstractCreature)p, 1)));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 40 */     return (AbstractCard)new Stock();
/*    */   }
/*    */   
/*    */   public void update() {
/* 44 */     super.update();
/* 45 */     if (this.hb.hovered) {
/* 46 */       AbstractCard[] ArmList = Patch.getArmsCard();
/* 47 */       if (this.rotationTimer <= 0.0F) {
/* 48 */         this.rotationTimer = 0.5F;
/* 49 */         this.cardsToPreview = ArmList[this.previewIndex];
/*    */         
/* 51 */         if (this.previewIndex == ArmList.length - 1) {
/* 52 */           this.previewIndex = 0;
/*    */         } else {
/* 54 */           this.previewIndex++;
/*    */         } 
/*    */         
/* 57 */         if (this.upgraded) {
/* 58 */           this.cardsToPreview.upgrade();
/*    */         }
/*    */       } else {
/*    */         
/* 62 */         this.rotationTimer -= Gdx.graphics.getDeltaTime();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 68 */     if (!this.upgraded) {
/* 69 */       upgradeName();
/* 70 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 71 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Stock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */