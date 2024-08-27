/*    */ package patches;
/*    */ 
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.CardGroup;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ 
/*    */ public class CauseAndEffectPatch
/*    */ {
/*    */   @SpirePatch(clz = CardGroup.class, method = "getPurgeableCards")
/*    */   public static class getPurgeableCardsPatch
/*    */   {
/*    */     @SpirePostfixPatch
/*    */     public static CardGroup Postfix(CardGroup _return) {
/* 17 */       CardGroup retVal = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
/* 18 */       for (AbstractCard c : _return.group) {
/* 19 */         if (!c.cardID.equals("CauseAndEffect")) {
/* 20 */           retVal.group.add(c);
/*    */         }
/*    */       } 
/* 23 */       return retVal;
/*    */     }
/*    */   }
/*    */   
/*    */   @SpirePatch(clz = AbstractPlayer.class, method = "isCursed")
/*    */   public static class isCursedPatch {
/*    */     @SpirePostfixPatch
/*    */     public static boolean Postfix(boolean _return) {
/* 31 */       boolean cursed = false;
/* 32 */       for (AbstractCard c : AbstractDungeon.player.masterDeck.group) {
/* 33 */         if (c.type == AbstractCard.CardType.CURSE && 
/* 34 */           !c.cardID.equals("Necronomicurse") && 
/* 35 */           !c.cardID.equals("CurseOfTheBell") && 
/* 36 */           !c.cardID.equals("AscendersBane") && 
/* 37 */           !c.cardID.equals("CauseAndEffect")) {
/*    */           
/* 39 */           cursed = true;
/*    */           break;
/*    */         } 
/*    */       } 
/* 43 */       return cursed;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/CauseAndEffectPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */