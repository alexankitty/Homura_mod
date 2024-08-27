/*    */ package action;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ public class TreatmentAction
/*    */   extends AbstractGameAction
/*    */ {
/*    */   public TreatmentAction() {
/* 15 */     setValues((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player);
/* 16 */     this.actionType = AbstractGameAction.ActionType.EXHAUST;
/*    */   }
/*    */   
/*    */   public void update() {
/* 20 */     ArrayList<AbstractCard> cardsToExhaust = new ArrayList<>();
/* 21 */     for (AbstractCard c : AbstractDungeon.player.hand.group) {
/* 22 */       if (c.type == AbstractCard.CardType.STATUS) {
/* 23 */         addToTop((AbstractGameAction)new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
/*    */       }
/*    */     } 
/*    */     
/* 27 */     for (AbstractCard c : AbstractDungeon.player.drawPile.group) {
/* 28 */       if (c.type == AbstractCard.CardType.STATUS) {
/* 29 */         addToTop((AbstractGameAction)new ExhaustSpecificCardAction(c, AbstractDungeon.player.drawPile));
/*    */       }
/*    */     } 
/*    */     
/* 33 */     for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
/* 34 */       if (c.type == AbstractCard.CardType.STATUS) {
/* 35 */         addToTop((AbstractGameAction)new ExhaustSpecificCardAction(c, AbstractDungeon.player.discardPile));
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 46 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/TreatmentAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */