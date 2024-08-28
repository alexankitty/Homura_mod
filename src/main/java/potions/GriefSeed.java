package potions;

import EgoMod.HomuraMod;
import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class GriefSeed extends AbstractPotion {

  public static final String POTION_ID = "GriefSeed";
  private static final PotionStrings potionStrings =
    CardCrawlGame.languagePack.getPotionString("GriefSeed");

  public GriefSeed() {
    super(
      potionStrings.NAME,
      "GriefSeed",
      AbstractPotion.PotionRarity.COMMON,
      AbstractPotion.PotionSize.FAIRY,
      AbstractPotion.PotionColor.SMOKE
    );
    this.labOutlineColor = HomuraMod.PurpleBlack;
    ReflectionHacks.setPrivate(
      this,
      AbstractPotion.class,
      "containerImg",
      PhotoTexture.getTexture("img/potions/GriefSeed.png")
    );
    ReflectionHacks.setPrivate(
      this,
      AbstractPotion.class,
      "liquidImg",
      PhotoTexture.getTexture("img/potions/GriefSeed.png")
    );
    ReflectionHacks.setPrivate(
      this,
      AbstractPotion.class,
      "hybridImg",
      PhotoTexture.getTexture("img/potions/GriefSeed.png")
    );
    ReflectionHacks.setPrivate(
      this,
      AbstractPotion.class,
      "spotsImg",
      PhotoTexture.getTexture("img/potions/GriefSeed.png")
    );
    ReflectionHacks.setPrivate(
      this,
      AbstractPotion.class,
      "outlineImg",
      PhotoTexture.getTexture("img/potions/GriefSeed.png")
    );

    this.potency = getPotency();
    this.isThrown = false;
  }

  public void initializeData() {
    this.potency = getPotency();
    this.description = potionStrings.DESCRIPTIONS[0] +
    this.potency +
    potionStrings.DESCRIPTIONS[1];
    this.tips.clear();
    this.tips.add(new PowerTip(this.name, this.description));
  }

  public void use(AbstractCreature target) {
    if (
      (AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT
    ) {
      addToBot(
        (AbstractGameAction) new HealAction(
          (AbstractCreature) AbstractDungeon.player,
          (AbstractCreature) AbstractDungeon.player,
          (int) ((AbstractDungeon.player.maxHealth * this.potency) / 100.0F)
        )
      );
      addToBot(
        (AbstractGameAction) new RemoveDebuffsAction(
          (AbstractCreature) AbstractDungeon.player
        )
      );
    } else {
      AbstractDungeon.player.heal(
        (int) ((AbstractDungeon.player.maxHealth * this.potency) / 100.0F)
      );
    }
  }

  public boolean canUse() {
    if (
      AbstractDungeon.actionManager.turnHasEnded &&
      (AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT
    ) {
      return false;
    }
    return (
      (AbstractDungeon.getCurrRoom()).event == null ||
      !((AbstractDungeon.getCurrRoom()).event instanceof
        com.megacrit.cardcrawl.events.shrines.WeMeetAgain)
    );
  }

  public int getPotency(int ascensionLevel) {
    return 15;
  }

  public AbstractPotion makeCopy() {
    return new GriefSeed();
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/potions/GriefSeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
