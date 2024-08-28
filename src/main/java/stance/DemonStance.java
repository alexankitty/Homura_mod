package stance;

import EgoMod.HomuraMod;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.stances.AbstractStance;
import com.megacrit.cardcrawl.vfx.stance.DivinityParticleEffect;
import com.megacrit.cardcrawl.vfx.stance.StanceAuraEffect;

public class DemonStance extends AbstractStance {

  public static final String STANCE_ID = "DemonStance";
  private static long sfxId = -1L;
  AbstractPlayer p;

  public DemonStance() {
    this.p = AbstractDungeon.player;
    this.ID = "DemonStance";
    this.name = "";
    updateDescription();
  }

  public void updateDescription() {
    this.description = "";
  }

  public void onEnterStance() {
    if (sfxId != -1L) {
      stopIdleSfx();
    }
    if (HomuraMod.isSchoolUniform || HomuraMod.isMagicalGirl) {
      AbstractDungeon.player.img = ImageMaster.loadImage("img/char/Demon.png");
    }
  }

  public void onExitStance() {
    stopIdleSfx();
  }

  public void stopIdleSfx() {
    if (sfxId != -1L) {
      sfxId = -1L;
    }
    if (HomuraMod.isSchoolUniform) {
      AbstractDungeon.player.img = ImageMaster.loadImage(
        "img/char/Homura_SchoolUniform.png"
      );
    }
    if (HomuraMod.isMagicalGirl) {
      AbstractDungeon.player.img = ImageMaster.loadImage(
        "img/char/Homura_MagicalGirl.png"
      );
    }
  }

  public void updateAnimation() {
    if (!Settings.DISABLE_EFFECTS) {
      this.particleTimer -= Gdx.graphics.getDeltaTime();
      if (this.particleTimer < 0.0F) {
        this.particleTimer = 0.2F;
        AbstractDungeon.effectsQueue.add(new DivinityParticleEffect());
      }
    }

    this.particleTimer2 -= Gdx.graphics.getDeltaTime();
    if (this.particleTimer2 < 0.0F) {
      this.particleTimer2 = MathUtils.random(0.45F, 0.55F);
      AbstractDungeon.effectsQueue.add(new StanceAuraEffect("Divinity"));
    }
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/stance/DemonStance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
