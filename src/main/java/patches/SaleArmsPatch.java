/*    */ package patches;
/*    */ 
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.shop.ShopScreen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SaleArmsPatch
/*    */ {
/*    */   @SpirePatch(clz = ShopScreen.class, method = "updatePurge")
/*    */   public static class PatchUpdatePurge
/*    */   {
/*    */     @SpireInsertPatch(rloc = 1)
/*    */     public static SpireReturn<Void> Insert(ShopScreen _instance) {
/* 21 */       if (AbstractDungeon.player.hasRelic("Membership Card") || AbstractDungeon.player
/* 22 */         .hasRelic("The Courier") || AbstractDungeon.player
/* 23 */         .hasRelic("Smiling Mask") || AbstractDungeon.player
/* 24 */         .hasRelic("MerchantsRug")) {
/* 25 */         for (AbstractCard card : AbstractDungeon.gridSelectScreen.selectedCards) {
/* 26 */           for (AbstractCard Arms : Patch.getArmsCard()) {
/* 27 */             if (card.cardID.equals(Arms.cardID)) {
/* 28 */               int price = 0;
/* 29 */               switch (card.rarity) {
/*    */                 case BASIC:
/* 31 */                   price = 5;
/*    */                   break;
/*    */                 case COMMON:
/* 34 */                   price = 10;
/*    */                   break;
/*    */                 case UNCOMMON:
/* 37 */                   price = 20;
/*    */                   break;
/*    */                 case RARE:
/* 40 */                   price = 40;
/*    */                   break;
/*    */               } 
/*    */ 
/*    */               
/* 45 */               AbstractDungeon.player.gainGold(price);
/* 46 */               CardCrawlGame.sound.play("SHOP_PURCHASE", 0.1F);
/* 47 */               CardCrawlGame.sound.play("VO_MERCHANT_KA", 0.1F);
/* 48 */               CardCrawlGame.metricData.addPurgedItem(card.getMetricID());
/* 49 */               AbstractDungeon.player.masterDeck.removeCard(card);
/* 50 */               AbstractDungeon.gridSelectScreen.selectedCards.clear();
/* 51 */               AbstractDungeon.shopScreen.purgeAvailable = true;
/*    */               
/* 53 */               return SpireReturn.Return(null);
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       }
/*    */       
/* 59 */       return SpireReturn.Continue();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/SaleArmsPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */