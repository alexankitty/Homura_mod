/*     */ package EgoMod;
/*     */ import basemod.BaseMod;
/*     */ import basemod.IUIElement;
/*     */ import basemod.ModLabel;
/*     */ import basemod.ModLabeledToggleButton;
/*     */ import basemod.ModPanel;
/*     */ import basemod.ModToggleButton;
/*     */ import basemod.interfaces.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import cards.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import characters.Homura;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
/*     */ import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
/*     */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*     */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
/*     */ import com.megacrit.cardcrawl.core.Settings;
/*     */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*     */ import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.FontHelper;
/*     */ import com.megacrit.cardcrawl.localization.*;
/*     */
/*     */
/*     */
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDrawPileEffect;
import potions.GriefSeed;
import relics.BlackLongbow;
import relics.Mami;
import relics.MetalShield;
import relics.SoulGem_Demon;

/*     */
/*     */ @SpireInitializer
/*     */ public class HomuraMod implements AddAudioSubscriber, StartGameSubscriber, RelicGetSubscriber, PostPowerApplySubscriber, PostExhaustSubscriber, PostBattleSubscriber, PostDungeonInitializeSubscriber, PostDrawSubscriber, PostEnergyRechargeSubscriber, PostInitializeSubscriber, EditCharactersSubscriber, EditRelicsSubscriber, EditCardsSubscriber, EditKeywordsSubscriber, EditStringsSubscriber, OnCardUseSubscriber, OnPowersModifiedSubscriber {
/*     */   private static final String ATTACK_CC = "img/512/Homura_attack.png";
/*     */   private static final String SKILL_CC = "img/512/Homura_skill.png";
/*     */   private static final String POWER_CC = "img/512/Homura_power.png";
/*     */   private static final String ENERGY_ORB_CC = "img/512/Homura_card_purple_orb.png";
/*     */   private static final String ATTACK_CC_PORTRAIT = "img/1024/Homura_attack.png";
/*  70 */   public static final Color PurpleBlack = CardHelper.getColor(22, 23, 28); private static final String SKILL_CC_PORTRAIT = "img/1024/Homura_skill.png"; private static final String POWER_CC_PORTRAIT = "img/1024/Homura_power.png"; private static final String ENERGY_ORB_CC_PORTRAIT = "img/1024/Homura_cardOrb.png"; public static final String CARD_ENERGY_ORB = "img/UI/Homura_energyOrb.png"; private static final String MY_CHARACTER_BUTTON = "img/charSelect/Homura_Button.png"; private static final String Homura_PORTRAIT = "img/charSelect/Homura_Portrait.png";
/*  71 */   private final ArrayList<AbstractCard> cardsToAdd = new ArrayList<>();
/*  72 */   public static ArrayList<AbstractCard> recyclecards = new ArrayList<>();
/*     */ 
/*     */   
/*  75 */   public static SpireConfig config = null;
/*     */   public static boolean isSchoolUniform = false;
/*     */   public static boolean isMagicalGirl = false;
/*     */   
/*     */   public HomuraMod() {
/*  80 */     BaseMod.subscribe((ISubscriber)this);
/*  81 */     BaseMod.addColor(AbstractCardEnum.Homura_COLOR, PurpleBlack, PurpleBlack, PurpleBlack, PurpleBlack, PurpleBlack, PurpleBlack, PurpleBlack, "img/512/Homura_attack.png", "img/512/Homura_skill.png", "img/512/Homura_power.png", "img/512/Homura_card_purple_orb.png", "img/1024/Homura_attack.png", "img/1024/Homura_skill.png", "img/1024/Homura_power.png", "img/1024/Homura_cardOrb.png", "img/UI/Homura_energyOrb.png");
/*     */     try {
/*  83 */       if (config == null) {
/*  84 */         config = new SpireConfig("Akemi_Homura", "SaveLoadData");
/*     */       }
/*  86 */       config.load();
/*  87 */       isSchoolUniform = config.getBool("SchoolUniform");
/*  88 */       isMagicalGirl = config.getBool("MagicalGirl");
/*  89 */     } catch (IOException e) {
/*  90 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void receiveAddAudio() {
/*  95 */     BaseMod.addAudio("TimeStop", "audio/TimeStop.mp3");
/*     */   }
/*     */   public static boolean reset = false;
/*     */   
/*     */   public static int getSaveLoadCount() {
/* 100 */     return config.getInt("MetalShield");
/*     */   }
/*     */   public static void setSaveLoadCount(int SaveLoadCount) {
/*     */     try {
/* 104 */       config.setInt("MetalShield", SaveLoadCount);
/* 105 */       config.save();
/* 106 */     } catch (IOException e) {
/* 107 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void receiveStartGame() {
/* 112 */     if (config == null) {
/*     */       try {
/* 114 */         config = new SpireConfig("Akemi_Homura", "SaveLoadData");
/* 115 */       } catch (IOException e) {
/* 116 */         e.printStackTrace();
/*     */       } 
/*     */     }
/* 119 */     if (reset || !config.has("MetalShield")) {
/* 120 */       reset = false;
/* 121 */       setSaveLoadCount(-1);
/*     */     } 
/* 123 */     setSaveLoadCount(getSaveLoadCount() + 1);
/* 124 */     CauseAndEffect.loadGame();
/* 125 */     Puzzle.loadMagicNumber();
/*     */   }
/*     */   
/*     */   public void receivePostInitialize() {
/*     */     String labelText1, labelText2;
/* 130 */     BaseMod.addPotion(GriefSeed.class, Color.BLACK.cpy(), Color.BLACK.cpy(), null, "GriefSeed");
/*     */     
/* 132 */     Texture badgeTexture = new Texture("img/char/Homura_Badge.png");
/* 133 */     ModPanel settingsPanel = new ModPanel();
/* 134 */     BaseMod.registerModBadge(badgeTexture, "Akemi_Homura", "EGOIST", "", settingsPanel);
/*     */ 
/*     */     
/* 137 */     if (Settings.language == Settings.GameLanguage.ZHS || Settings.language == Settings.GameLanguage.ZHT) {
/* 138 */       labelText1 = "校服(静态)";
/*     */     } else {
/* 140 */       labelText1 = "SchoolUniform(static)";
/*     */     } 
/* 142 */     if (Settings.language == Settings.GameLanguage.ZHS || Settings.language == Settings.GameLanguage.ZHT) {
/* 143 */       labelText2 = "魔法少女(静态)";
/*     */     } else {
/* 145 */       labelText2 = "MagicalGirl(static)";
/*     */     } 
/*     */     
/* 148 */     ModLabeledToggleButton setSchoolUniform = new ModLabeledToggleButton(labelText1, 350.0F, 750.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, isSchoolUniform, settingsPanel, label -> {
/*     */         
/*     */         }, button -> {
/*     */           isSchoolUniform = button.enabled;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           try {
/*     */             config.setBool("SchoolUniform", isSchoolUniform);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             config.save();
/* 164 */           } catch (Exception e) {
/*     */             e.printStackTrace();
/*     */           } 
/*     */         });
/* 168 */     ModLabeledToggleButton setMagicalGirl = new ModLabeledToggleButton(labelText2, 350.0F, 700.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, isMagicalGirl, settingsPanel, label -> {
/*     */         
/*     */         }, button -> {
/*     */           isMagicalGirl = button.enabled;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           try {
/*     */             config.setBool("MagicalGirl", isMagicalGirl);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             config.save();
/* 184 */           } catch (Exception e) {
/*     */             e.printStackTrace();
/*     */           } 
/*     */         });
/* 188 */     settingsPanel.addUIElement((IUIElement)setSchoolUniform);
/* 189 */     settingsPanel.addUIElement((IUIElement)setMagicalGirl);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveEditCharacters() {
/* 196 */     BaseMod.addCharacter((AbstractPlayer)new Homura("Akemi_Homura"), "img/charSelect/Homura_Button.png", "img/charSelect/Homura_Portrait.png", EgomodClassEnum.Homura_CLASS);
/*     */   }
/*     */   
/*     */   public void receiveEditCards() {
/* 200 */     loadCardsToAdd();
/* 201 */     for (AbstractCard card : this.cardsToAdd) {
/* 202 */       BaseMod.addCard(card);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void initialize() {
/* 207 */     new HomuraMod();
/*     */   }
/*     */ 
/*     */   
/*     */   public void receivePostExhaust(AbstractCard c) {}
/*     */
/*     */   public void receivePowersModified() {}
/*     */ 
/*     */   
/*     */   public void receivePostDungeonInitialize() {}
/*     */   
/*     */   public void receivePostDraw(AbstractCard arg0) {}
/*     */   
/*     */   public void receiveEditKeywords() {
/*     */     String keywordsPath;
/* 226 */     switch (Settings.language) {
/*     */       case ZHT:
/*     */       case ZHS:
/* 229 */         keywordsPath = "localization/zh/EgoMod_Homura_keywords-zh.json";
/*     */         break;
/*     */       case RUS:
/* 232 */         keywordsPath = "localization/rus/EgoMod_Homura_keywords-rus.json";
/*     */         break;
/*     */       case KOR:
/* 235 */         keywordsPath = "localization/kor/EgoMod_Homura_keywords-kor.json";
/*     */         break;
/*     */       default:
/* 238 */         keywordsPath = "localization/eng/EgoMod_Homura_keywords-eng.json";
/*     */         break;
/*     */     } 
/* 241 */     Gson gson = new Gson();
/*     */     
/* 243 */     Keywords keywords = (Keywords)gson.fromJson(loadJson(keywordsPath), Keywords.class);
/* 244 */     for (Keyword key : keywords.keywords) {
/* 245 */       BaseMod.addKeyword(key.NAMES, key.DESCRIPTION);
/*     */     }
/*     */   }
/*     */   
/*     */   public void receiveEditStrings() {
/*     */     String relic, card, power, potion, score_bonuse;
/* 251 */     switch (Settings.language) {
/*     */       case ZHT:
/*     */       case ZHS:
/* 254 */         card = "localization/zh/EgoMod_Homura_cards-zh.json";
/* 255 */         relic = "localization/zh/EgoMod_Homura_relics-zh.json";
/* 256 */         power = "localization/zh/EgoMod_Homura_powers-zh.json";
/* 257 */         potion = "localization/zh/EgoMod_Homura_potions-zh.json";
/* 258 */         score_bonuse = "localization/zh/EgoMod_Homura_score_bonuses-zh.json";
/*     */         break;
/*     */       case RUS:
/* 261 */         card = "localization/rus/EgoMod_Homura_cards-rus.json";
/* 262 */         relic = "localization/rus/EgoMod_Homura_relics-rus.json";
/* 263 */         power = "localization/rus/EgoMod_Homura_powers-rus.json";
/* 264 */         potion = "localization/rus/EgoMod_Homura_potions-rus.json";
/* 265 */         score_bonuse = "localization/rus/EgoMod_Homura_score_bonuses-rus.json";
/*     */         break;
/*     */       case KOR:
/* 268 */         card = "localization/kor/EgoMod_Homura_cards-kor.json";
/* 269 */         relic = "localization/kor/EgoMod_Homura_relics-kor.json";
/* 270 */         power = "localization/kor/EgoMod_Homura_powers-kor.json";
/* 271 */         potion = "localization/kor/EgoMod_Homura_potions-kor.json";
/* 272 */         score_bonuse = "localization/kor/EgoMod_Homura_score_bonuses-kor.json";
/*     */         break;
/*     */       default:
/* 275 */         card = "localization/eng/EgoMod_Homura_cards-eng.json";
/* 276 */         relic = "localization/eng/EgoMod_Homura_relics-eng.json";
/* 277 */         power = "localization/eng/EgoMod_Homura_powers-eng.json";
/* 278 */         potion = "localization/eng/EgoMod_Homura_potions-eng.json";
/* 279 */         score_bonuse = "localization/eng/EgoMod_Homura_score_bonuses-eng.json";
/*     */         break;
/*     */     } 
/* 282 */     String relicStrings = Gdx.files.internal(relic).readString(String.valueOf(StandardCharsets.UTF_8));
/* 283 */     BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
/*     */     
/* 285 */     String cardStrings = Gdx.files.internal(card).readString(String.valueOf(StandardCharsets.UTF_8));
/* 286 */     BaseMod.loadCustomStrings(CardStrings.class, cardStrings);
/*     */     
/* 288 */     String powerStrings = Gdx.files.internal(power).readString(String.valueOf(StandardCharsets.UTF_8));
/* 289 */     BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);
/*     */     
/* 291 */     String potionStrings = Gdx.files.internal(potion).readString(String.valueOf(StandardCharsets.UTF_8));
/* 292 */     BaseMod.loadCustomStrings(PotionStrings.class, potionStrings);
/*     */     
/* 294 */     String scoreStrings = Gdx.files.internal(score_bonuse).readString(String.valueOf(StandardCharsets.UTF_8));
/* 295 */     BaseMod.loadCustomStrings(ScoreBonusStrings.class, scoreStrings);
/*     */   }
/*     */ 
/*     */   
/*     */   private void loadCardsToAdd() {
/* 300 */     this.cardsToAdd.clear();
/*     */     
/* 302 */     this.cardsToAdd.add(new CauseAndEffect());
/* 303 */     this.cardsToAdd.add(new Despair());
/*     */     
/* 305 */     this.cardsToAdd.add(new Strike_Homura());
/* 306 */     this.cardsToAdd.add(new Defend_Homura());
/* 307 */     this.cardsToAdd.add(new Alone());
/* 308 */     this.cardsToAdd.add(new AT4());
/* 309 */     this.cardsToAdd.add(new BombMaking());
/* 310 */     this.cardsToAdd.add(new Clean());
/* 311 */     this.cardsToAdd.add(new Clocks());
/* 312 */     this.cardsToAdd.add(new Coercion());
/* 313 */     this.cardsToAdd.add(new Confrontation());
/* 314 */     this.cardsToAdd.add(new Contract());
/* 315 */     this.cardsToAdd.add(new Detonate());
/* 316 */     this.cardsToAdd.add(new DodgeShot());
/* 317 */     this.cardsToAdd.add(new Demon());
/* 318 */     this.cardsToAdd.add(new DesertEagle());
/* 319 */     this.cardsToAdd.add(new Encircle());
/* 320 */     this.cardsToAdd.add(new FalseTown());
/* 321 */     this.cardsToAdd.add(new Feeding());
/* 322 */     this.cardsToAdd.add(new FireExtinguisher());
/* 323 */     this.cardsToAdd.add(new Flash());
/* 324 */     this.cardsToAdd.add(new FlashBang());
/* 325 */     this.cardsToAdd.add(new FuelTankCar());
/* 326 */     this.cardsToAdd.add(new GunsWorkBetterThanMagic());
/* 327 */     this.cardsToAdd.add(new Hope());
/* 328 */     this.cardsToAdd.add(new Hunt());
/* 329 */     this.cardsToAdd.add(new IED());
/* 330 */     this.cardsToAdd.add(new Kick());
/* 331 */     this.cardsToAdd.add(new LawOfCycles());
/* 332 */     this.cardsToAdd.add(new LiftHair());
/* 333 */     this.cardsToAdd.add(new M18A1());
/* 334 */     this.cardsToAdd.add(new M84());
/* 335 */     this.cardsToAdd.add(new M92());
/* 336 */     this.cardsToAdd.add(new M249());
/* 337 */     this.cardsToAdd.add(new M870());
/* 338 */     this.cardsToAdd.add(new MagicLongbow());
/* 339 */     this.cardsToAdd.add(new Mercy());
/* 340 */     this.cardsToAdd.add(new Maze());
/* 341 */     this.cardsToAdd.add(new ModifyMemory());
/* 342 */     this.cardsToAdd.add(new MoveAndFire());
/* 343 */     this.cardsToAdd.add(new Mud());
/* 344 */     this.cardsToAdd.add(new No1());
/* 345 */     this.cardsToAdd.add(new No2());
/* 346 */     this.cardsToAdd.add(new No3());
/* 347 */     this.cardsToAdd.add(new No4());
/* 348 */     this.cardsToAdd.add(new No5());
/* 349 */     this.cardsToAdd.add(new No6());
/* 350 */     this.cardsToAdd.add(new No7());
/* 351 */     this.cardsToAdd.add(new No8());
/* 352 */     this.cardsToAdd.add(new No9());
/* 353 */     this.cardsToAdd.add(new No10());
/* 354 */     this.cardsToAdd.add(new No11());
/* 355 */     this.cardsToAdd.add(new No12());
/* 356 */     this.cardsToAdd.add(new No13());
/* 357 */     this.cardsToAdd.add(new No14());
/* 358 */     this.cardsToAdd.add(new No15());
/* 359 */     this.cardsToAdd.add(new Prepare());
/* 360 */     this.cardsToAdd.add(new Pretend());
/* 361 */     this.cardsToAdd.add(new Production());
/* 362 */     this.cardsToAdd.add(new Puzzle());
/*     */     
/* 364 */     this.cardsToAdd.add(new Reload());
/* 365 */     this.cardsToAdd.add(new Ruin());
/* 366 */     this.cardsToAdd.add(new Rush());
/* 367 */     this.cardsToAdd.add(new Separate());
/* 368 */     this.cardsToAdd.add(new Smoke());
/* 369 */     this.cardsToAdd.add(new SSM1());
/* 370 */     this.cardsToAdd.add(new Stamina());
/* 371 */     this.cardsToAdd.add(new Stock());
/* 372 */     this.cardsToAdd.add(new Strong());
/* 373 */     this.cardsToAdd.add(new SwivelThrow());
/* 374 */     this.cardsToAdd.add(new ThePriceOfMiracles());
/* 375 */     this.cardsToAdd.add(new Throw());
/* 376 */     this.cardsToAdd.add(new TimeBomb());
/*     */     
/* 378 */     this.cardsToAdd.add(new Treatment());
/* 379 */     this.cardsToAdd.add(new Twining());
/* 380 */     this.cardsToAdd.add(new Untie());
/* 381 */     this.cardsToAdd.add(new Witch());
/*     */   }
/*     */   
/*     */   public void receiveEditRelics() {
/* 385 */     BaseMod.addRelicToCustomPool((AbstractRelic)new MetalShield(), AbstractCardEnum.Homura_COLOR);
/* 386 */     BaseMod.addRelicToCustomPool((AbstractRelic)new Mami(), AbstractCardEnum.Homura_COLOR);
/* 387 */     BaseMod.addRelicToCustomPool((AbstractRelic)new BlackLongbow(), AbstractCardEnum.Homura_COLOR);
/* 388 */     BaseMod.addRelicToCustomPool((AbstractRelic)new SoulGem_Demon(), AbstractCardEnum.Homura_COLOR);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveRelicGet(AbstractRelic relic) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveCardUsed(AbstractCard abstractCard) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void receivePostBattle(AbstractRoom r) {}
/*     */
/*     */ 
/*     */   
/*     */   public void receivePostEnergyRecharge() {
/* 406 */     for (AbstractCard c : recyclecards) {
/* 407 */       AbstractCard card = c.makeStatEquivalentCopy();
/* 408 */       AbstractDungeon.effectList.add(new ShowCardAndAddToDrawPileEffect(card, Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F, false, true, true));
/*     */     } 
/* 410 */     recyclecards.clear();
/*     */   }


    @Override
    public void receivePostPowerApplySubscriber(AbstractPower abstractPower, AbstractCreature abstractCreature, AbstractCreature abstractCreature1) {

    }

    /*     */
/*     */   static class Keywords {
/*     */     Keyword[] keywords; }
/*     */   
/*     */   private static String loadJson(String jsonPath) {
/* 417 */     return Gdx.files.internal(jsonPath).readString(String.valueOf(StandardCharsets.UTF_8));
/*     */   }
/*     */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/EgoMod/HomuraMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */