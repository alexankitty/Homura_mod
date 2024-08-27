/*    */ package potions;
/*    */ 
/*    */ import EgoMod.HomuraMod;
/*    */ import basemod.ReflectionHacks;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.HealAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.helpers.PowerTip;
/*    */ import com.megacrit.cardcrawl.localization.PotionStrings;
/*    */ import com.megacrit.cardcrawl.potions.AbstractPotion;
/*    */ import com.megacrit.cardcrawl.rooms.AbstractRoom;
/*    */ 
/*    */ public class GriefSeed extends AbstractPotion {
/*    */   public static final String POTION_ID = "GriefSeed";
/* 18 */   private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString("GriefSeed");
/*    */   public GriefSeed() {
/* 20 */     super(potionStrings.NAME, "GriefSeed", AbstractPotion.PotionRarity.COMMON, AbstractPotion.PotionSize.FAIRY, AbstractPotion.PotionColor.SMOKE);
/* 21 */     this.labOutlineColor = HomuraMod.PurpleBlack;
/* 22 */     ReflectionHacks.setPrivate(this, AbstractPotion.class, "containerImg", PhotoTexture.getTexture("img/potions/GriefSeed.png"));
/* 23 */     ReflectionHacks.setPrivate(this, AbstractPotion.class, "liquidImg", PhotoTexture.getTexture("img/potions/GriefSeed.png"));
/* 24 */     ReflectionHacks.setPrivate(this, AbstractPotion.class, "hybridImg", PhotoTexture.getTexture("img/potions/GriefSeed.png"));
/* 25 */     ReflectionHacks.setPrivate(this, AbstractPotion.class, "spotsImg", PhotoTexture.getTexture("img/potions/GriefSeed.png"));
/* 26 */     ReflectionHacks.setPrivate(this, AbstractPotion.class, "outlineImg", PhotoTexture.getTexture("img/potions/GriefSeed.png"));
/*    */     
/* 28 */     this.potency = getPotency();
/* 29 */     this.isThrown = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeData() {
/* 35 */     this.potency = getPotency();
/* 36 */     this.description = potionStrings.DESCRIPTIONS[0] + this.potency + potionStrings.DESCRIPTIONS[1];
/* 37 */     this.tips.clear();
/* 38 */     this.tips.add(new PowerTip(this.name, this.description));
/*    */   }
/*    */   
/*    */   public void use(AbstractCreature target) {
/* 42 */     if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
/* 43 */       addToBot((AbstractGameAction)new HealAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, (int)(AbstractDungeon.player.maxHealth * this.potency / 100.0F)));
/* 44 */       addToBot((AbstractGameAction)new RemoveDebuffsAction((AbstractCreature)AbstractDungeon.player));
/*    */     } else {
/* 46 */       AbstractDungeon.player.heal((int)(AbstractDungeon.player.maxHealth * this.potency / 100.0F));
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean canUse() {
/* 51 */     if (AbstractDungeon.actionManager.turnHasEnded && (AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
/* 52 */       return false;
/*    */     }
/* 54 */     return ((AbstractDungeon.getCurrRoom()).event == null || !((AbstractDungeon.getCurrRoom()).event instanceof com.megacrit.cardcrawl.events.shrines.WeMeetAgain));
/*    */   }
/*    */ 
/*    */   
/*    */   public int getPotency(int ascensionLevel) {
/* 59 */     return 15;
/*    */   }
/*    */   public AbstractPotion makeCopy() {
/* 62 */     return new GriefSeed();
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/potions/GriefSeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */