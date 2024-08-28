package characters;

import EgoMod.AbstractCardEnum;
import EgoMod.EgomodClassEnum;
import EgoMod.HomuraMod;
import basemod.abstracts.CustomPlayer;
import cards.Throw;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.cutscenes.CutscenePanel;
import com.megacrit.cardcrawl.events.beyond.SpireHeart;
import com.megacrit.cardcrawl.events.city.Vampires;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.ui.panels.energyorb.EnergyOrbInterface;
import com.megacrit.cardcrawl.ui.panels.energyorb.EnergyOrbPurple;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import java.util.ArrayList;
import java.util.List;

public class Homura extends CustomPlayer {

  private static final int ENERGY_PER_TURN = 3;
  private static final String SHOULDER_2 = "img/char/Homura_shoulder.png";
  private static final String SHOULDER_1 = "img/char/Homura_shoulder.png";
  private static final String CORPSE = "img/char/Homura_fallen.png";
  private static String STAND = "";

  private static final String SchoolUniform =
    "img/char/Homura_SchoolUniform.png";
  private static final String MagicalGirl = "img/char/Homura_MagicalGirl.png";
  private static final String[] ORB_TEXTURES = new String[] {
    "img/UI/layer/border.png",
    "img/UI/layer/l1.png",
    "img/UI/layer/l2.png",
    "img/UI/layer/l3.png",
    "img/UI/layer/l4.png",
  };

  private static final String ORB_VFX = "img/UI/energyPurpleVFX.png";
  private static final int STARTING_HP = 65;
  private static final int MAX_HP = 65;
  private static final int STARTING_GOLD = 99;
  private static final int HAND_SIZE = 0;
  private static final int ASCENSION_MAX_HP_LOSS = 3;

  public Homura(String name) {
    super(
      name,
      EgomodClassEnum.Homura_CLASS,
      ORB_TEXTURES,
      "img/UI/energyPurpleVFX.png",
      null,
      null,
      null
    );
    this.dialogX = this.drawX + 0.0F * Settings.scale;
    this.dialogY = this.drawY + 220.0F * Settings.scale;
    if (HomuraMod.isSchoolUniform) {
      STAND = "img/char/Homura_SchoolUniform.png";
    }
    if (HomuraMod.isMagicalGirl) {
      STAND = "img/char/Homura_MagicalGirl.png";
    }
    initializeClass(
      STAND,
      "img/char/Homura_shoulder.png",
      "img/char/Homura_shoulder.png",
      "img/char/Homura_fallen.png",
      getLoadout(),
      20.0F,
      0.0F,
      220.0F,
      290.0F,
      new EnergyManager(3)
    );

    this.energyOrb = (EnergyOrbInterface) new EnergyOrbPurple();

    if (!HomuraMod.isSchoolUniform && !HomuraMod.isMagicalGirl) {
      loadAnimation("img/char/Homura_1.atlas", "img/char/Homura_1.json", 1.0F);
      AnimationState.TrackEntry e =
        this.state.setAnimation(0, "newAnimation", true);
      e.setTime(e.getEndTime() * MathUtils.random());
    }
  }

  public Texture getEnergyImage() {
    return ImageMaster.PURPLE_ORB_FLASH_VFX;
  }

  public BitmapFont getEnergyNumFont() {
    return FontHelper.energyNumFontPurple;
  }

  public void renderOrb(
    SpriteBatch sb,
    boolean enabled,
    float current_x,
    float current_y
  ) {
    this.energyOrb.renderOrb(sb, enabled, current_x, current_y);
  }

  public void updateOrb(int orbCount) {
    this.energyOrb.updateOrb(orbCount);
  }

  public void doCharSelectScreenSelectEffect() {
    CardCrawlGame.sound.play("TimeStop");
    CardCrawlGame.screenShake.shake(
      ScreenShake.ShakeIntensity.MED,
      ScreenShake.ShakeDur.SHORT,
      true
    );
  }

  public String getCustomModeCharacterButtonSoundKey() {
    return "TimeStop";
  }

  public ArrayList<String> getStartingDeck() {
    ArrayList<String> retVal = new ArrayList<>();
    retVal.add("Strike_Homura");
    retVal.add("Strike_Homura");
    retVal.add("Strike_Homura");
    retVal.add("Strike_Homura");
    retVal.add("Defend_Homura");
    retVal.add("Defend_Homura");
    retVal.add("Defend_Homura");
    retVal.add("Defend_Homura");
    retVal.add("Throw");
    retVal.add("IED");
    retVal.add("IED");
    retVal.add("CauseAndEffect");
    return retVal;
  }

  public ArrayList<String> getStartingRelics() {
    ArrayList<String> retVal = new ArrayList<>();
    retVal.add("MetalShield");
    UnlockTracker.markRelicAsSeen("MetalShield");
    return retVal;
  }

  public CharSelectInfo getLoadout() {
    String title = "";
    String flavor = "";
    switch (Settings.language) {
      case ZHT:
      case ZHS:
        title = "晓美焰";
        flavor =
          "外表秀丽，说的话总是意向不明的魔法少女。 NL 不具备攻击性的魔法，装备各式军火战斗。";

        return new CharSelectInfo(
          title,
          flavor,
          65,
          65,
          0,
          99,
          5,
          (AbstractPlayer) this,
          getStartingRelics(),
          getStartingDeck(),
          false
        );
      case RUS:
        title = "Акеми Хомура";
        flavor =
          "Девушка-волшебница с пекрасной внешностью и неизвестными намерениями. NL Никакой агрессивной магии! — Ей достаточно пушек.";
        return new CharSelectInfo(
          title,
          flavor,
          65,
          65,
          0,
          99,
          5,
          (AbstractPlayer) this,
          getStartingRelics(),
          getStartingDeck(),
          false
        );
      case KOR:
        title = "아케미 호무라";
        flavor =
          "아름답지만 속내를 알 수 없는 마법 소녀. NL 공격 마법을 못 쓰는 대신 다양한 무기를 들고 싸웁니다.";
        return new CharSelectInfo(
          title,
          flavor,
          65,
          65,
          0,
          99,
          5,
          (AbstractPlayer) this,
          getStartingRelics(),
          getStartingDeck(),
          false
        );
    }
    title = "Akemi Homura";
    flavor =
      "A magical girl with beautiful appearance and unknown intention. NL No offensive magic, equipped with all kinds of weapons to fight.";
    return new CharSelectInfo(
      title,
      flavor,
      65,
      65,
      0,
      99,
      5,
      (AbstractPlayer) this,
      getStartingRelics(),
      getStartingDeck(),
      false
    );
  }

  public String getTitle(AbstractPlayer.PlayerClass playerClass) {
    String title = "";
    switch (Settings.language) {
      case ZHT:
      case ZHS:
        title = "魔法少女";

        return title;
      case RUS:
        title = "Хомура";
        return title;
      case KOR:
        title = "마법소녀";
        return title;
    }
    title = "the Magical Girl";
    return title;
  }

  public String getLocalizedCharacterName() {
    String char_name = "";
    switch (Settings.language) {
      case ZHT:
      case ZHS:
        char_name = "晓美焰";

        return char_name;
      case RUS:
        char_name = "Акеми Хомура";
        return char_name;
      case KOR:
        char_name = "아케미 호무라";
        return char_name;
    }
    char_name = "Akemi Homura";
    return char_name;
  }

  public AbstractCard.CardColor getCardColor() {
    return AbstractCardEnum.Homura_COLOR;
  }

  public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
    return new AbstractGameAction.AttackEffect[] {
      AbstractGameAction.AttackEffect.SLASH_HEAVY,
      AbstractGameAction.AttackEffect.FIRE,
      AbstractGameAction.AttackEffect.SLASH_DIAGONAL,
      AbstractGameAction.AttackEffect.SLASH_HEAVY,
      AbstractGameAction.AttackEffect.FIRE,
      AbstractGameAction.AttackEffect.SLASH_DIAGONAL,
    };
  }

  public String getSpireHeartText() {
    return SpireHeart.DESCRIPTIONS[10];
  }

  public Color getCardRenderColor() {
    return HomuraMod.PurpleBlack;
  }

  public Color getCardTrailColor() {
    return HomuraMod.PurpleBlack;
  }

  public Color getSlashAttackColor() {
    return HomuraMod.PurpleBlack;
  }

  public int getAscensionMaxHPLoss() {
    return 3;
  }

  public AbstractPlayer newInstance() {
    return (AbstractPlayer) new Homura(this.name);
  }

  public void applyEndOfTurnTriggers() {
    super.applyEndOfTurnTriggers();
  }

  public String getVampireText() {
    return Vampires.DESCRIPTIONS[1];
  }

  public AbstractCard getStartCardForEvent() {
    return (AbstractCard) new Throw();
  }

  public Texture getCutsceneBg() {
    return ImageMaster.loadImage("images/scenes/purpleBg.jpg");
  }

  public List<CutscenePanel> getCutscenePanels() {
    List<CutscenePanel> panels = new ArrayList<>();
    panels.add(new CutscenePanel("img/char/homura1.png"));
    panels.add(new CutscenePanel("img/char/homura2.png"));
    panels.add(new CutscenePanel("img/char/homura3.png"));
    return panels;
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/characters/Homura.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
