package patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class CauseAndEffectPatch {

  @SpirePatch(clz = CardGroup.class, method = "getPurgeableCards")
  public static class getPurgeableCardsPatch {

    @SpirePostfixPatch
    public static CardGroup Postfix(CardGroup _return) {
      CardGroup retVal = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
      for (AbstractCard c : _return.group) {
        if (!c.cardID.equals("CauseAndEffect")) {
          retVal.group.add(c);
        }
      }
      return retVal;
    }
  }

  @SpirePatch(clz = AbstractPlayer.class, method = "isCursed")
  public static class isCursedPatch {

    @SpirePostfixPatch
    public static boolean Postfix(boolean _return) {
      boolean cursed = false;
      for (AbstractCard c : AbstractDungeon.player.masterDeck.group) {
        if (
          c.type == AbstractCard.CardType.CURSE &&
          !c.cardID.equals("Necronomicurse") &&
          !c.cardID.equals("CurseOfTheBell") &&
          !c.cardID.equals("AscendersBane") &&
          !c.cardID.equals("CauseAndEffect")
        ) {
          cursed = true;
          break;
        }
      }
      return cursed;
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/CauseAndEffectPatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
