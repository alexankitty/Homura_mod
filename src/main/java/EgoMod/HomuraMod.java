package EgoMod;

import basemod.BaseMod;
import basemod.IUIElement;
import basemod.ModLabel;
import basemod.ModLabeledToggleButton;
import basemod.ModPanel;
import basemod.ModToggleButton;
import basemod.interfaces.*;
import cards.*;
import characters.Homura;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDrawPileEffect;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import potions.GriefSeed;
import relics.BlackLongbow;
import relics.Mami;
import relics.MetalShield;
import relics.SoulGem_Demon;

@SpireInitializer
public class HomuraMod
  implements
    AddAudioSubscriber,
    StartGameSubscriber,
    RelicGetSubscriber,
    PostPowerApplySubscriber,
    PostExhaustSubscriber,
    PostBattleSubscriber,
    PostDungeonInitializeSubscriber,
    PostDrawSubscriber,
    PostEnergyRechargeSubscriber,
    PostInitializeSubscriber,
    EditCharactersSubscriber,
    EditRelicsSubscriber,
    EditCardsSubscriber,
    EditKeywordsSubscriber,
    EditStringsSubscriber,
    OnCardUseSubscriber,
    OnPowersModifiedSubscriber {

  private static final String ATTACK_CC = "img/512/Homura_attack.png";
  private static final String SKILL_CC = "img/512/Homura_skill.png";
  private static final String POWER_CC = "img/512/Homura_power.png";
  private static final String ENERGY_ORB_CC =
    "img/512/Homura_card_purple_orb.png";
  private static final String ATTACK_CC_PORTRAIT = "img/1024/Homura_attack.png";
  public static final Color PurpleBlack = CardHelper.getColor(22, 23, 28);
  private static final String SKILL_CC_PORTRAIT = "img/1024/Homura_skill.png";
  private static final String POWER_CC_PORTRAIT = "img/1024/Homura_power.png";
  private static final String ENERGY_ORB_CC_PORTRAIT =
    "img/1024/Homura_cardOrb.png";
  public static final String CARD_ENERGY_ORB = "img/UI/Homura_energyOrb.png";
  private static final String MY_CHARACTER_BUTTON =
    "img/charSelect/Homura_Button.png";
  private static final String Homura_PORTRAIT =
    "img/charSelect/Homura_Portrait.png";
  private final ArrayList<AbstractCard> cardsToAdd = new ArrayList<>();
  public static ArrayList<AbstractCard> recyclecards = new ArrayList<>();

  public static SpireConfig config = null;
  public static boolean isSchoolUniform = false;
  public static boolean isMagicalGirl = false;

  public HomuraMod() {
    BaseMod.subscribe((ISubscriber) this);
    BaseMod.addColor(
      AbstractCardEnum.Homura_COLOR,
      PurpleBlack,
      PurpleBlack,
      PurpleBlack,
      PurpleBlack,
      PurpleBlack,
      PurpleBlack,
      PurpleBlack,
      "img/512/Homura_attack.png",
      "img/512/Homura_skill.png",
      "img/512/Homura_power.png",
      "img/512/Homura_card_purple_orb.png",
      "img/1024/Homura_attack.png",
      "img/1024/Homura_skill.png",
      "img/1024/Homura_power.png",
      "img/1024/Homura_cardOrb.png",
      "img/UI/Homura_energyOrb.png"
    );
    try {
      if (config == null) {
        config = new SpireConfig("Akemi_Homura", "SaveLoadData");
        config.setBool("MagicalGirl", true); //set magical girl outfit as default
      }
      config.load();
      isSchoolUniform = config.getBool("SchoolUniform");
      isMagicalGirl = config.getBool("MagicalGirl");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void receiveAddAudio() {
    BaseMod.addAudio("TimeStop", "audio/TimeStop.mp3");
  }

  public static boolean reset = false;

  public static int getSaveLoadCount() {
    return config.getInt("MetalShield");
  }

  public static void setSaveLoadCount(int SaveLoadCount) {
    try {
      config.setInt("MetalShield", SaveLoadCount);
      config.save();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void receiveStartGame() {
    if (config == null) {
      try {
        config = new SpireConfig("Akemi_Homura", "SaveLoadData");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (reset || !config.has("MetalShield")) {
      reset = false;
      setSaveLoadCount(-1);
    }
    setSaveLoadCount(getSaveLoadCount() + 1);
    CauseAndEffect.loadGame();
    Puzzle.loadMagicNumber();
  }

  public void receivePostInitialize() {
    String labelText1, labelText2;
    BaseMod.addPotion(
      GriefSeed.class,
      Color.BLACK.cpy(),
      Color.BLACK.cpy(),
      null,
      "GriefSeed"
    );

    Texture badgeTexture = new Texture("img/char/Homura_Badge.png");
    ModPanel settingsPanel = new ModPanel();
    BaseMod.registerModBadge(
      badgeTexture,
      "Akemi_Homura",
      "EGOIST",
      "",
      settingsPanel
    );

    if (
      Settings.language == Settings.GameLanguage.ZHS ||
      Settings.language == Settings.GameLanguage.ZHT
    ) {
      labelText1 = "校服(静态)";
    } else {
      labelText1 = "SchoolUniform(static)";
    }
    if (
      Settings.language == Settings.GameLanguage.ZHS ||
      Settings.language == Settings.GameLanguage.ZHT
    ) {
      labelText2 = "魔法少女(静态)";
    } else {
      labelText2 = "MagicalGirl(static)";
    }

    ModLabeledToggleButton setSchoolUniform = new ModLabeledToggleButton(
      labelText1,
      350.0F,
      750.0F,
      Settings.CREAM_COLOR,
      FontHelper.charDescFont,
      isSchoolUniform,
      settingsPanel,
      label -> {},
      button -> {
        isSchoolUniform = button.enabled;

        try {
          config.setBool("SchoolUniform", isSchoolUniform);

          config.save();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    );
    ModLabeledToggleButton setMagicalGirl = new ModLabeledToggleButton(
      labelText2,
      350.0F,
      700.0F,
      Settings.CREAM_COLOR,
      FontHelper.charDescFont,
      isMagicalGirl,
      settingsPanel,
      label -> {},
      button -> {
        isMagicalGirl = button.enabled;

        try {
          config.setBool("MagicalGirl", isMagicalGirl);

          config.save();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    );
    settingsPanel.addUIElement((IUIElement) setSchoolUniform);
    settingsPanel.addUIElement((IUIElement) setMagicalGirl);
  }

  public void receiveEditCharacters() {
    BaseMod.addCharacter(
      (AbstractPlayer) new Homura("Akemi_Homura"),
      "img/charSelect/Homura_Button.png",
      "img/charSelect/Homura_Portrait.png",
      EgomodClassEnum.Homura_CLASS
    );
  }

  public void receiveEditCards() {
    loadCardsToAdd();
    for (AbstractCard card : this.cardsToAdd) {
      BaseMod.addCard(card);
    }
  }

  public static void initialize() {
    new HomuraMod();
  }

  public void receivePostExhaust(AbstractCard c) {}

  public void receivePowersModified() {}

  public void receivePostDungeonInitialize() {}

  public void receivePostDraw(AbstractCard arg0) {}

  public void receiveEditKeywords() {
    String keywordsPath;
    switch (Settings.language) {
      case ZHT:
      case ZHS:
        keywordsPath = "localization/zh/EgoMod_Homura_keywords-zh.json";
        break;
      case RUS:
        keywordsPath = "localization/rus/EgoMod_Homura_keywords-rus.json";
        break;
      case KOR:
        keywordsPath = "localization/kor/EgoMod_Homura_keywords-kor.json";
        break;
      default:
        keywordsPath = "localization/eng/EgoMod_Homura_keywords-eng.json";
        break;
    }
    Gson gson = new Gson();

    Keywords keywords = (Keywords) gson.fromJson(
      loadJson(keywordsPath),
      Keywords.class
    );
    for (Keyword key : keywords.keywords) {
      BaseMod.addKeyword(key.NAMES, key.DESCRIPTION);
    }
  }

  public void receiveEditStrings() {
    String relic, card, power, potion, score_bonuse;
    switch (Settings.language) {
      case ZHT:
      case ZHS:
        card = "localization/zh/EgoMod_Homura_cards-zh.json";
        relic = "localization/zh/EgoMod_Homura_relics-zh.json";
        power = "localization/zh/EgoMod_Homura_powers-zh.json";
        potion = "localization/zh/EgoMod_Homura_potions-zh.json";
        score_bonuse = "localization/zh/EgoMod_Homura_score_bonuses-zh.json";
        break;
      case RUS:
        card = "localization/rus/EgoMod_Homura_cards-rus.json";
        relic = "localization/rus/EgoMod_Homura_relics-rus.json";
        power = "localization/rus/EgoMod_Homura_powers-rus.json";
        potion = "localization/rus/EgoMod_Homura_potions-rus.json";
        score_bonuse = "localization/rus/EgoMod_Homura_score_bonuses-rus.json";
        break;
      case KOR:
        card = "localization/kor/EgoMod_Homura_cards-kor.json";
        relic = "localization/kor/EgoMod_Homura_relics-kor.json";
        power = "localization/kor/EgoMod_Homura_powers-kor.json";
        potion = "localization/kor/EgoMod_Homura_potions-kor.json";
        score_bonuse = "localization/kor/EgoMod_Homura_score_bonuses-kor.json";
        break;
      default:
        card = "localization/eng/EgoMod_Homura_cards-eng.json";
        relic = "localization/eng/EgoMod_Homura_relics-eng.json";
        power = "localization/eng/EgoMod_Homura_powers-eng.json";
        potion = "localization/eng/EgoMod_Homura_potions-eng.json";
        score_bonuse = "localization/eng/EgoMod_Homura_score_bonuses-eng.json";
        break;
    }
    String relicStrings = Gdx.files
      .internal(relic)
      .readString(String.valueOf(StandardCharsets.UTF_8));
    BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);

    String cardStrings = Gdx.files
      .internal(card)
      .readString(String.valueOf(StandardCharsets.UTF_8));
    BaseMod.loadCustomStrings(CardStrings.class, cardStrings);

    String powerStrings = Gdx.files
      .internal(power)
      .readString(String.valueOf(StandardCharsets.UTF_8));
    BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);

    String potionStrings = Gdx.files
      .internal(potion)
      .readString(String.valueOf(StandardCharsets.UTF_8));
    BaseMod.loadCustomStrings(PotionStrings.class, potionStrings);

    String scoreStrings = Gdx.files
      .internal(score_bonuse)
      .readString(String.valueOf(StandardCharsets.UTF_8));
    BaseMod.loadCustomStrings(ScoreBonusStrings.class, scoreStrings);
  }

  private void loadCardsToAdd() {
    this.cardsToAdd.clear();

    this.cardsToAdd.add(new CauseAndEffect());
    this.cardsToAdd.add(new Despair());

    this.cardsToAdd.add(new Strike_Homura());
    this.cardsToAdd.add(new Defend_Homura());
    this.cardsToAdd.add(new Alone());
    this.cardsToAdd.add(new AT4());
    this.cardsToAdd.add(new BombMaking());
    this.cardsToAdd.add(new Clean());
    this.cardsToAdd.add(new Clocks());
    this.cardsToAdd.add(new Coercion());
    this.cardsToAdd.add(new Confrontation());
    this.cardsToAdd.add(new Contract());
    this.cardsToAdd.add(new Detonate());
    this.cardsToAdd.add(new DodgeShot());
    this.cardsToAdd.add(new Demon());
    this.cardsToAdd.add(new DesertEagle());
    this.cardsToAdd.add(new Encircle());
    this.cardsToAdd.add(new FalseTown());
    this.cardsToAdd.add(new Feeding());
    this.cardsToAdd.add(new FireExtinguisher());
    this.cardsToAdd.add(new Flash());
    this.cardsToAdd.add(new FlashBang());
    this.cardsToAdd.add(new FuelTankCar());
    this.cardsToAdd.add(new GunsWorkBetterThanMagic());
    this.cardsToAdd.add(new Hope());
    this.cardsToAdd.add(new Hunt());
    this.cardsToAdd.add(new IED());
    this.cardsToAdd.add(new Kick());
    this.cardsToAdd.add(new LawOfCycles());
    this.cardsToAdd.add(new LiftHair());
    this.cardsToAdd.add(new M18A1());
    this.cardsToAdd.add(new M84());
    this.cardsToAdd.add(new M92());
    this.cardsToAdd.add(new M249());
    this.cardsToAdd.add(new M870());
    this.cardsToAdd.add(new MagicLongbow());
    this.cardsToAdd.add(new Mercy());
    this.cardsToAdd.add(new Maze());
    this.cardsToAdd.add(new ModifyMemory());
    this.cardsToAdd.add(new MoveAndFire());
    this.cardsToAdd.add(new Mud());
    this.cardsToAdd.add(new No1());
    this.cardsToAdd.add(new No2());
    this.cardsToAdd.add(new No3());
    this.cardsToAdd.add(new No4());
    this.cardsToAdd.add(new No5());
    this.cardsToAdd.add(new No6());
    this.cardsToAdd.add(new No7());
    this.cardsToAdd.add(new No8());
    this.cardsToAdd.add(new No9());
    this.cardsToAdd.add(new No10());
    this.cardsToAdd.add(new No11());
    this.cardsToAdd.add(new No12());
    this.cardsToAdd.add(new No13());
    this.cardsToAdd.add(new No14());
    this.cardsToAdd.add(new No15());
    this.cardsToAdd.add(new Prepare());
    this.cardsToAdd.add(new Pretend());
    this.cardsToAdd.add(new Production());
    this.cardsToAdd.add(new Puzzle());

    this.cardsToAdd.add(new Reload());
    this.cardsToAdd.add(new Ruin());
    this.cardsToAdd.add(new Rush());
    this.cardsToAdd.add(new Separate());
    this.cardsToAdd.add(new Smoke());
    this.cardsToAdd.add(new SSM1());
    this.cardsToAdd.add(new Stamina());
    this.cardsToAdd.add(new Stock());
    this.cardsToAdd.add(new Strong());
    this.cardsToAdd.add(new SwivelThrow());
    this.cardsToAdd.add(new ThePriceOfMiracles());
    this.cardsToAdd.add(new Throw());
    this.cardsToAdd.add(new TimeBomb());

    this.cardsToAdd.add(new Treatment());
    this.cardsToAdd.add(new Twining());
    this.cardsToAdd.add(new Untie());
    this.cardsToAdd.add(new Witch());
  }

  public void receiveEditRelics() {
    BaseMod.addRelicToCustomPool(
      (AbstractRelic) new MetalShield(),
      AbstractCardEnum.Homura_COLOR
    );
    BaseMod.addRelicToCustomPool(
      (AbstractRelic) new Mami(),
      AbstractCardEnum.Homura_COLOR
    );
    BaseMod.addRelicToCustomPool(
      (AbstractRelic) new BlackLongbow(),
      AbstractCardEnum.Homura_COLOR
    );
    BaseMod.addRelicToCustomPool(
      (AbstractRelic) new SoulGem_Demon(),
      AbstractCardEnum.Homura_COLOR
    );
  }

  public void receiveRelicGet(AbstractRelic relic) {}

  public void receiveCardUsed(AbstractCard abstractCard) {}

  public void receivePostBattle(AbstractRoom r) {}

  public void receivePostEnergyRecharge() {
    for (AbstractCard c : recyclecards) {
      AbstractCard card = c.makeStatEquivalentCopy();
      AbstractDungeon.effectList.add(
        new ShowCardAndAddToDrawPileEffect(
          card,
          Settings.WIDTH / 2.0F,
          Settings.HEIGHT / 2.0F,
          false,
          true,
          true
        )
      );
    }
    recyclecards.clear();
  }

  @Override
  public void receivePostPowerApplySubscriber(
    AbstractPower abstractPower,
    AbstractCreature abstractCreature,
    AbstractCreature abstractCreature1
  ) {}

  static class Keywords {

    Keyword[] keywords;
  }

  private static String loadJson(String jsonPath) {
    return Gdx.files
      .internal(jsonPath)
      .readString(String.valueOf(StandardCharsets.UTF_8));
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/EgoMod/HomuraMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
