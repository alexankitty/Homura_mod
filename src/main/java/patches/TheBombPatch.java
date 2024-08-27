/*    */ package patches;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ 
/*    */ @SpirePatch(cls = "com.megacrit.cardcrawl.cards.AbstractCard", method = "triggerOnManualDiscard")
/*    */ public class TheBombPatch {
/*    */   @SpirePostfixPatch
/*    */   public static void Postfix(AbstractCard _c) {
/* 12 */     if ("The Bomb".equals(_c.cardID)) {
/*    */ 
/*    */       
/* 15 */       _c.exhaust = true;
/* 16 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new NewQueueCardAction(_c, null, false, true));
/* 17 */       AbstractDungeon.player.discardPile.group.remove(_c);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/TheBombPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */