/*    */ package action;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.CardGroup;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DetonateAction
/*    */   extends AbstractGameAction
/*    */ {
/* 23 */   public static final String[] TEXT = (CardCrawlGame.languagePack.getUIString("WishAction")).TEXT;
/*    */   private final AbstractPlayer player;
/*    */   private final int playAmt;
/*    */   
/*    */   public DetonateAction(int numberOfCards) {
/* 28 */     this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
/* 29 */     this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
/* 30 */     this.player = AbstractDungeon.player;
/* 31 */     this.playAmt = numberOfCards;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 36 */     if (this.duration == this.startDuration) {
/*    */       
/* 38 */       if (this.player.discardPile.isEmpty()) {
/* 39 */         this.isDone = true;
/*    */       } else {
/* 41 */         CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
/* 42 */         for (AbstractCard c : this.player.discardPile.group) {
/* 43 */           if (c.exhaust || "The Bomb".equals(c.cardID)) {
/* 44 */             temp.addToTop(c);
/*    */           }
/*    */         } 
/* 47 */         if (temp.isEmpty()) {
/* 48 */           this.isDone = true;
/*    */         } else {
/* 50 */           temp.sortAlphabetically(true);
/* 51 */           temp.sortByRarityPlusStatusCardType(false);
/* 52 */           AbstractDungeon.gridSelectScreen.open(temp, 1, TEXT[0], false);
/*    */         } 
/* 54 */         tickDuration();
/*    */       } 
/*    */     } else {
/* 57 */       if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
/*    */         
/* 59 */         for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
/* 60 */           c.exhaust = true;
/* 61 */           AbstractDungeon.player.discardPile.group.remove(c);
/* 62 */           (AbstractDungeon.getCurrRoom()).souls.remove(c);
/* 63 */           if ("The Bomb".equals(c.cardID)) {
/* 64 */             addToBot((AbstractGameAction)new DamageAllEnemiesAction(null, DamageInfo.createDamageMatrix(c.magicNumber, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
/*    */           } else {
/* 66 */             addToBot((AbstractGameAction)new NewQueueCardAction(c, true, false, true));
/*    */           } 
/* 68 */           for (int i = 0; i < this.playAmt - 1; i++) {
/* 69 */             AbstractCard tmp = c.makeStatEquivalentCopy();
/* 70 */             tmp.purgeOnUse = true;
/* 71 */             addToBot((AbstractGameAction)new NewQueueCardAction(tmp, true, false, true));
/*    */           } 
/*    */         } 
/*    */         
/* 75 */         AbstractDungeon.gridSelectScreen.selectedCards.clear();
/* 76 */         AbstractDungeon.player.hand.refreshHandLayout();
/*    */       } 
/*    */       
/* 79 */       tickDuration();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/DetonateAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */