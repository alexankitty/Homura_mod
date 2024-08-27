/*    */ package action;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.CardGroup;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.UIStrings;
/*    */ 
/*    */ public class No12Action
/*    */   extends AbstractGameAction {
/* 15 */   private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("DiscardAction");
/* 16 */   public static final String[] TEXT = uiStrings.TEXT;
/*    */   private AbstractPlayer p;
/*    */   
/*    */   public No12Action(int amount) {
/* 20 */     this.p = AbstractDungeon.player;
/* 21 */     setValues((AbstractCreature)this.p, (AbstractCreature)AbstractDungeon.player, amount);
/* 22 */     this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
/* 23 */     this.duration = Settings.ACTION_DUR_MED;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 28 */     if (this.duration == Settings.ACTION_DUR_MED) {
/* 29 */       CardGroup tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
/* 30 */       for (AbstractCard abstractCard : this.p.drawPile.group) {
/* 31 */         AbstractCard card = abstractCard;
/* 32 */         tmp.addToRandomSpot(card);
/*    */       } 
/*    */       
/* 35 */       AbstractDungeon.gridSelectScreen.open(tmp, this.amount, true, TEXT[0]);
/* 36 */     } else if (AbstractDungeon.gridSelectScreen.selectedCards.size() != 0) {
/* 37 */       for (AbstractCard abstractCard : AbstractDungeon.gridSelectScreen.selectedCards) {
/* 38 */         AbstractCard card = abstractCard;
/* 39 */         card.unhover();
/* 40 */         card.isSelected = false;
/* 41 */         this.p.drawPile.moveToDiscardPile(card);
/* 42 */         this.p.hand.refreshHandLayout();
/* 43 */         this.p.hand.applyPowers();
/*    */       } 
/*    */       
/* 46 */       AbstractDungeon.gridSelectScreen.selectedCards.clear();
/* 47 */       this.p.hand.refreshHandLayout();
/*    */     } 
/* 49 */     tickDuration();
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/No12Action.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */