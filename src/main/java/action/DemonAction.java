package action;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.stances.AbstractStance;
import stance.DemonStance;






public class DemonAction
  extends AbstractGameAction
{
  AbstractPlayer p = AbstractDungeon.player;


  
  public void update() {
    addToTop((AbstractGameAction)new ChangeStanceAction((AbstractStance)new DemonStance()));
    this.isDone = true;
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/DemonAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */