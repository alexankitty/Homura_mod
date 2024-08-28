package relics;

import EgoMod.HomuraMod;
import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.potions.PotionSlot;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import powers.ZeroEnergePower;

public class MetalShield extends CustomRelic {

  public static final String ID = "MetalShield";
  private static final String IMG = "img/relics/MetalShield.png";

  public MetalShield() {
    super(
      "MetalShield",
      ImageMaster.loadImage("img/relics/MetalShield.png"),
      ImageMaster.loadImage("img/relics/outline/MetalShield.png"),
      AbstractRelic.RelicTier.STARTER,
      AbstractRelic.LandingSound.CLINK
    );
    this.Rclick = false;
    this.RclickStart = false;
  }

  private static final String IMG_OTL = "img/relics/outline/MetalShield.png";
  private boolean RclickStart;
  private boolean Rclick;

  public void onEquip() {
    AbstractDungeon.player.potionSlots += 2;
    AbstractDungeon.player.potions.add(
      new PotionSlot(AbstractDungeon.player.potionSlots - 2)
    );
    AbstractDungeon.player.potions.add(
      new PotionSlot(AbstractDungeon.player.potionSlots - 1)
    );
    this.counter = 6;
    HomuraMod.reset = true;
  }

  public void onUnequip() {
    System.out.println("MetalShield");
    AbstractPotion p1 = AbstractDungeon.player.potions.remove(
      AbstractDungeon.player.potionSlots - 1
    );
    AbstractPotion p2 = AbstractDungeon.player.potions.remove(
      AbstractDungeon.player.potionSlots - 2
    );
    AbstractDungeon.player.potionSlots -= 2;
    if (p1 != null) {
      AbstractDungeon.player.obtainPotion(p1);
    }
    if (p2 != null) {
      AbstractDungeon.player.obtainPotion(p2);
    }
  }

  public void atTurnStart() {
    if (this.counter < 12) {
      this.counter++;
    }
  }

  public void onRightClick() {
    AbstractPlayer p = AbstractDungeon.player;
    if (
      this.counter > 5 &&
      (AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT
    ) {
      flash();
      addToBot(
        (AbstractGameAction) new ApplyPowerAction(
          (AbstractCreature) p,
          (AbstractCreature) p,
          (AbstractPower) new ZeroEnergePower((AbstractCreature) p),
          1
        )
      );
      this.counter -= 6;
    }
  }

  public void update() {
    super.update();
    if (this.RclickStart && InputHelper.justReleasedClickRight) {
      if (this.hb.hovered) {
        this.Rclick = true;
      }
      this.RclickStart = false;
    }
    if (
      this.isObtained &&
      this.hb != null &&
      this.hb.hovered &&
      InputHelper.justClickedRight
    ) {
      this.RclickStart = true;
    }
    if (this.Rclick) {
      this.Rclick = false;
      onRightClick();
    }
  }

  public String getUpdatedDescription() {
    return this.DESCRIPTIONS[0];
  }

  public AbstractRelic makeCopy() {
    return (AbstractRelic) new MetalShield();
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/relics/MetalShield.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
