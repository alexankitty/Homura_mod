/*    */ package action;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.UIStrings;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FeedingAction
/*    */   extends AbstractGameAction
/*    */ {
/*    */   public FeedingAction(int amount, boolean isRandom, boolean anyNumber, boolean canPickZero) {
/* 26 */     this.anyNumber = anyNumber;
/* 27 */     this.p = AbstractDungeon.player;
/* 28 */     this.canPickZero = canPickZero;
/* 29 */     this.isRandom = isRandom;
/* 30 */     this.amount = amount;
/* 31 */     this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
/* 32 */     this.actionType = AbstractGameAction.ActionType.EXHAUST;
/*    */   }
/*    */   
/*    */   public void update() {
/* 36 */     if (this.duration == this.startDuration) {
/* 37 */       if (this.p.hand.size() == 0) {
/* 38 */         this.isDone = true;
/*    */         
/*    */         return;
/*    */       } 
/* 42 */       if (!this.isRandom) {
/* 43 */         numExhausted = this.amount;
/* 44 */         AbstractDungeon.handCardSelectScreen.open(TEXT[0], this.amount, this.anyNumber, this.canPickZero);
/* 45 */         tickDuration();
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/*    */     
/* 51 */     if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
/*    */       
/* 53 */       for (AbstractCard c : AbstractDungeon.handCardSelectScreen.selectedCards.group) {
/* 54 */         this.p.hand.moveToExhaustPile(c);
/*    */         
/* 56 */         if (c.type == AbstractCard.CardType.CURSE) {
/* 57 */           addToBot((AbstractGameAction)new GainEnergyAction(1));
/*    */         }
/* 59 */         if (c.type == AbstractCard.CardType.STATUS) {
/* 60 */           addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)this.p, 1));
/*    */         }
/*    */       } 
/*    */ 
/*    */       
/* 65 */       AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
/*    */     } 
/*    */     
/* 68 */     this.isDone = true;
/*    */   }
/*    */ 
/*    */   
/* 72 */   private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("ExhaustAction");
/* 73 */   public static final String[] TEXT = uiStrings.TEXT;
/*    */   private AbstractPlayer p;
/*    */   private boolean isRandom;
/*    */   private boolean anyNumber;
/*    */   private boolean canPickZero;
/*    */   public static int numExhausted;
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/FeedingAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */