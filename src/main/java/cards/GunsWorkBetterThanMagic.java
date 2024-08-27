/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import action.GunsWorkBetterThanMagicAction;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class GunsWorkBetterThanMagic extends CustomCard {
/* 16 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GunsWorkBetterThanMagic"); public static final String ID = "GunsWorkBetterThanMagic";
/* 17 */   public static final String NAME = cardStrings.NAME;
/* 18 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   private static final int COST = -1;
/*    */   public static final String IMG_PATH = "img/cards/GunsWorkBetterThanMagic_skill.png";
/* 21 */   private float rotationTimer = 0.0F;
/* 22 */   private int previewIndex = 0;
/*    */   public GunsWorkBetterThanMagic() {
/* 24 */     super("GunsWorkBetterThanMagic", NAME, "img/cards/GunsWorkBetterThanMagic_skill.png", -1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
/* 25 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 30 */     if (this.energyOnUse < EnergyPanel.totalCount) {
/* 31 */       this.energyOnUse = EnergyPanel.totalCount;
/*    */     }
/* 33 */     addToBot((AbstractGameAction)new GunsWorkBetterThanMagicAction(p, this.upgraded, this.freeToPlayOnce, this.energyOnUse));
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 38 */     return (AbstractCard)new GunsWorkBetterThanMagic();
/*    */   }
/*    */   
/*    */   public void update() {
/* 42 */     super.update();
/* 43 */     if (this.hb.hovered) {
/* 44 */       AbstractCard[] ArmList = Patch.getArmsCard();
/* 45 */       if (this.rotationTimer <= 0.0F) {
/* 46 */         this.rotationTimer = 0.5F;
/* 47 */         this.cardsToPreview = ArmList[this.previewIndex];
/*    */         
/* 49 */         if (this.previewIndex == ArmList.length - 1) {
/* 50 */           this.previewIndex = 0;
/*    */         } else {
/* 52 */           this.previewIndex++;
/*    */         } 
/*    */         
/* 55 */         if (this.upgraded) {
/* 56 */           this.cardsToPreview.upgrade();
/*    */         }
/*    */       } else {
/*    */         
/* 60 */         this.rotationTimer -= Gdx.graphics.getDeltaTime();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 66 */     if (!this.upgraded) {
/* 67 */       upgradeName();
/* 68 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 69 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/GunsWorkBetterThanMagic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */