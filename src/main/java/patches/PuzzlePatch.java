/*    */ package patches;
/*    */ 
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ @SpirePatch(cls = "com.megacrit.cardcrawl.relics.AbstractRelic", method = "onObtainCard")
/*    */ public class PuzzlePatch {
/*    */   @SpirePostfixPatch
/*    */   public static void Postfix(AbstractRelic _r, AbstractCard _c) {
/* 13 */     if (_c.cardID.equals("Puzzle") && AbstractDungeon.player.masterDeck.findCardById("Puzzle") != null)
/* 14 */       for (int i = AbstractDungeon.player.masterDeck.group.size() - 1; i >= 0; i--) {
/* 15 */         AbstractCard P = AbstractDungeon.player.masterDeck.group.get(i);
/* 16 */         if ("Puzzle".equals(P.cardID)) {
/* 17 */           _c.misc += P.misc;
/* 18 */           _c.applyPowers();
/* 19 */           AbstractDungeon.player.masterDeck.removeCard(P);
/*    */         } 
/*    */       }  
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/PuzzlePatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */