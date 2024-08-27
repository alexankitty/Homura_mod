/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import action.ProductionAction;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Production extends CustomCard {
/* 15 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Production"); public static final String ID = "Production";
/* 16 */   public static final String NAME = cardStrings.NAME;
/* 17 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   private static final int COST = 3;
/* 19 */   private float rotationTimer = 0.0F;
/* 20 */   private int previewIndex = 0;
/*    */   public static final String IMG_PATH = "img/cards/Prodution_skill.png";
/*    */   
/*    */   public Production() {
/* 24 */     super("Production", NAME, "img/cards/Prodution_skill.png", 3, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
/* 25 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 30 */     addToBot((AbstractGameAction)new ProductionAction((AbstractCreature)p, 11 - p.hand.size()));
/*    */   }
/*    */   
/*    */   public void update() {
/* 34 */     super.update();
/* 35 */     if (this.hb.hovered) {
/* 36 */       AbstractCard[] ArmList = Patch.getArmsCard();
/* 37 */       if (this.rotationTimer <= 0.0F) {
/* 38 */         this.rotationTimer = 0.5F;
/* 39 */         this.cardsToPreview = ArmList[this.previewIndex];
/*    */         
/* 41 */         if (this.previewIndex == ArmList.length - 1) {
/* 42 */           this.previewIndex = 0;
/*    */         } else {
/* 44 */           this.previewIndex++;
/*    */         } 
/*    */         
/* 47 */         if (this.upgraded) {
/* 48 */           this.cardsToPreview.upgrade();
/*    */         }
/*    */       } else {
/*    */         
/* 52 */         this.rotationTimer -= Gdx.graphics.getDeltaTime();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 58 */     return (AbstractCard)new Production();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 63 */     if (!this.upgraded) {
/* 64 */       upgradeName();
/* 65 */       upgradeBaseCost(2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Production.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */