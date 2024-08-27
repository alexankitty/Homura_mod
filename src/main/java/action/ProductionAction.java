/*     */ package action;
/*     */ 
/*     */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*     */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*     */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*     */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*     */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*     */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*     */ import com.megacrit.cardcrawl.core.Settings;
/*     */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*     */ import com.megacrit.cardcrawl.localization.UIStrings;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import patches.Patch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProductionAction
/*     */   extends AbstractGameAction
/*     */ {
/*  27 */   private final ArrayList<AbstractCard> cannotDuplicate = new ArrayList<>();
/*     */   
/*     */   public ProductionAction(AbstractCreature source, int amount) {
/*  30 */     setValues((AbstractCreature)AbstractDungeon.player, source, amount);
/*  31 */     this.actionType = AbstractGameAction.ActionType.DRAW;
/*  32 */     this.duration = 0.25F;
/*  33 */     this.p = AbstractDungeon.player;
/*  34 */     this.dupeAmount = amount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/*  41 */     if (this.duration == Settings.ACTION_DUR_FAST) {
/*  42 */       Iterator<AbstractCard> var1 = this.p.hand.group.iterator();
/*     */       
/*  44 */       while (var1.hasNext()) {
/*  45 */         AbstractCard c = var1.next();
/*  46 */         if (!isDualWieldable(c)) {
/*  47 */           this.cannotDuplicate.add(c);
/*     */         }
/*     */       } 
/*     */       
/*  51 */       if (this.cannotDuplicate.size() == this.p.hand.group.size()) {
/*  52 */         this.isDone = true;
/*     */         
/*     */         return;
/*     */       } 
/*  56 */       if (this.p.hand.group.size() - this.cannotDuplicate.size() == 1) {
/*  57 */         var1 = this.p.hand.group.iterator();
/*     */         
/*  59 */         while (var1.hasNext()) {
/*  60 */           AbstractCard c = var1.next();
/*  61 */           if (isDualWieldable(c)) {
/*  62 */             for (int i = 0; i < this.dupeAmount; i++) {
/*  63 */               addToTop((AbstractGameAction)new MakeTempCardInHandAction(c.makeStatEquivalentCopy()));
/*     */             }
/*     */             
/*  66 */             this.isDone = true;
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*  72 */       this.p.hand.group.removeAll(this.cannotDuplicate);
/*  73 */       if (this.p.hand.group.size() > 1) {
/*  74 */         AbstractDungeon.handCardSelectScreen.open(TEXT[0], 1, false, false, false, false);
/*  75 */         tickDuration();
/*     */         
/*     */         return;
/*     */       } 
/*  79 */       if (this.p.hand.group.size() == 1) {
/*  80 */         for (int i = 0; i < this.dupeAmount; i++) {
/*  81 */           addToTop((AbstractGameAction)new MakeTempCardInHandAction(this.p.hand.getTopCard().makeStatEquivalentCopy()));
/*     */         }
/*     */         
/*  84 */         returnCards();
/*  85 */         this.isDone = true;
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
/*  90 */       Iterator<AbstractCard> var1 = AbstractDungeon.handCardSelectScreen.selectedCards.group.iterator();
/*     */       
/*  92 */       while (var1.hasNext()) {
/*  93 */         AbstractCard c = var1.next();
/*  94 */         addToTop((AbstractGameAction)new MakeTempCardInHandAction(c.makeStatEquivalentCopy()));
/*     */         
/*  96 */         for (int i = 0; i < this.dupeAmount; i++) {
/*  97 */           addToTop((AbstractGameAction)new MakeTempCardInHandAction(c.makeStatEquivalentCopy()));
/*     */         }
/*     */       } 
/*     */       
/* 101 */       returnCards();
/* 102 */       AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
/* 103 */       AbstractDungeon.handCardSelectScreen.selectedCards.group.clear();
/* 104 */       this.isDone = true;
/*     */     } 
/*     */     
/* 107 */     tickDuration();
/*     */   }
/*     */ 
/*     */   
/*     */   private void returnCards() {
/* 112 */     for (AbstractCard c : this.cannotDuplicate) {
/* 113 */       this.p.hand.addToTop(c);
/*     */     }
/*     */     
/* 116 */     this.p.hand.refreshHandLayout();
/*     */   }
/*     */   
/*     */   private boolean isDualWieldable(AbstractCard card) {
/* 120 */     AbstractCard[] Arms = Patch.getArmsCard();
/* 121 */     for (AbstractCard c : Arms) {
/* 122 */       if (c.cardID.equals(card.cardID)) {
/* 123 */         return true;
/*     */       }
/*     */     } 
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 131 */   private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("DualWieldAction");
/* 132 */   public static final String[] TEXT = uiStrings.TEXT;
/*     */   private final AbstractPlayer p;
/*     */   private final int dupeAmount;
/*     */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/ProductionAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */