package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.ShopScreen;

public class SaleArmsPatch {

  @SpirePatch(clz = ShopScreen.class, method = "updatePurge")
  public static class PatchUpdatePurge {

    @SpireInsertPatch(rloc = 1)
    public static SpireReturn<Void> Insert(ShopScreen _instance) {
      if (
        AbstractDungeon.player.hasRelic("Membership Card") ||
        AbstractDungeon.player.hasRelic("The Courier") ||
        AbstractDungeon.player.hasRelic("Smiling Mask") ||
        AbstractDungeon.player.hasRelic("MerchantsRug")
      ) {
        for (AbstractCard card : AbstractDungeon.gridSelectScreen.selectedCards) {
          for (AbstractCard Arms : Patch.getArmsCard()) {
            if (card.cardID.equals(Arms.cardID)) {
              int price = 0;
              switch (card.rarity) {
                case BASIC:
                  price = 5;
                  break;
                case COMMON:
                  price = 10;
                  break;
                case UNCOMMON:
                  price = 20;
                  break;
                case RARE:
                  price = 40;
                  break;
              }

              AbstractDungeon.player.gainGold(price);
              CardCrawlGame.sound.play("SHOP_PURCHASE", 0.1F);
              CardCrawlGame.sound.play("VO_MERCHANT_KA", 0.1F);
              CardCrawlGame.metricData.addPurgedItem(card.getMetricID());
              AbstractDungeon.player.masterDeck.removeCard(card);
              AbstractDungeon.gridSelectScreen.selectedCards.clear();
              AbstractDungeon.shopScreen.purgeAvailable = true;

              return SpireReturn.Return(null);
            }
          }
        }
      }

      return SpireReturn.Continue();
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/SaleArmsPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
