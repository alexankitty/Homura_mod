package patches;

import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.ScoreBonusStrings;
import com.megacrit.cardcrawl.screens.GameOverScreen;
import com.megacrit.cardcrawl.screens.GameOverStat;
import com.megacrit.cardcrawl.screens.VictoryScreen;
import java.util.ArrayList;






public class ScorePatch
{
  public static ScoreBonusStrings ScoreString = CardCrawlGame.languagePack.getScoreString("SL");

  @SpirePatch(clz = VictoryScreen.class, method = "createGameOverStats")
  public static class PatchVictoryScreen {
    @SpireInsertPatch(rloc = 197)
    public static SpireReturn<Void> Insert(VictoryScreen _instance) {
      ArrayList<GameOverStat> stats = (ArrayList<GameOverStat>)ReflectionHacks.getPrivate(_instance, GameOverScreen.class, "stats");
      if (AbstractDungeon.player.hasRelic("MetalShield") && "Akemi_Homura".equals(AbstractDungeon.player.name)) {
        System.out.println(ScorePatch.ScoreString.NAME);
        System.out.println(ScorePatch.ScoreString.DESCRIPTIONS[0]);
        stats.add(new GameOverStat(ScorePatch.ScoreString.NAME, ScorePatch.ScoreString.DESCRIPTIONS[0], Integer.toString(500 - Patch.countSL() * 100)));
      }
      return SpireReturn.Continue();
    }
  }

  @SpirePatch(clz = GameOverScreen.class, method = "checkScoreBonus")
  public static class PatchGameOverScreen {
    @SpireInsertPatch(rloc = 91, localvars = {"points"})
    public static SpireReturn<Void> Insert(boolean victory, @ByRef int[] points) {
      if (victory &&
        AbstractDungeon.player.hasRelic("MetalShield") && "Akemi_Homura".equals(AbstractDungeon.player.name)) {
        points[0] = points[0] + 500 - Patch.countSL() * 100;
      }

      return SpireReturn.Continue();
    }
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/ScorePatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */