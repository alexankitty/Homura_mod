package relics;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import java.util.ArrayList;

public class BlackLongbow extends CustomRelic {
  public static final String ID = "BlackLongbow";
  private static final String IMG = "img/relics/BlackLongbow.png";
  private static final String IMG_OTL = "img/relics/outline/BlackLongbow.png";

  public BlackLongbow() {
    super("BlackLongbow", ImageMaster.loadImage("img/relics/BlackLongbow.png"), ImageMaster.loadImage("img/relics/outline/BlackLongbow.png"), AbstractRelic.RelicTier.BOSS, AbstractRelic.LandingSound.CLINK);
  }



  public void atTurnStart() {
    flash();
    AbstractPlayer p = AbstractDungeon.player;
    AbstractMonster m = (AbstractDungeon.getCurrRoom()).monsters.getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
    switch (AbstractDungeon.cardRandomRng.random(0, 2)) {
      case 0:
        if (m != null && !m.powers.isEmpty()) {
          ArrayList<AbstractPower> pows = new ArrayList<>();
          for (AbstractPower pow : m.powers) {
            if (pow.type == AbstractPower.PowerType.BUFF &&
              !pow.ID.equals("Fading") &&
              !pow.ID.equals("Shifting") &&
              !pow.ID.equals("Life Link"))
            {
              pows.add(pow);
            }
          }
          if (!pows.isEmpty()) {
            AbstractPower po = pows.get((int)(Math.random() * pows.size()));
            AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)m, (AbstractCreature)p, po));
            return;
          }
        }
      case 1:
        if (m != null) {
          addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)m, -1), -1)); return;
        }
        break;
    }
    addToBot((AbstractGameAction)new GainEnergyAction(1));
  }
  public boolean canSpawn() {
    return AbstractDungeon.player.hasRelic("MetalShield");
  } public void obtain() {
    if (AbstractDungeon.player.hasRelic("MetalShield")) {
      AbstractDungeon.player.getRelic("MetalShield").onUnequip();
      instantObtain(AbstractDungeon.player, 0, false);
    } else {
      super.obtain();
    }
  }



  public String getUpdatedDescription() {
    return this.DESCRIPTIONS[0];
  }


  public AbstractRelic makeCopy() {
    return (AbstractRelic)new BlackLongbow();
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/relics/BlackLongbow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */