/*     */ package relics;
/*     */ 
/*     */ import EgoMod.HomuraMod;
/*     */ import basemod.abstracts.CustomRelic;
/*     */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*     */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*     */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*     */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*     */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*     */ import com.megacrit.cardcrawl.helpers.ImageMaster;
/*     */ import com.megacrit.cardcrawl.helpers.input.InputHelper;
/*     */ import com.megacrit.cardcrawl.potions.AbstractPotion;
/*     */ import com.megacrit.cardcrawl.potions.PotionSlot;
/*     */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*     */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*     */ import com.megacrit.cardcrawl.rooms.AbstractRoom;
/*     */ import powers.ZeroEnergePower;
/*     */ 
/*     */ public class MetalShield extends CustomRelic {
/*     */   public static final String ID = "MetalShield";
/*     */   private static final String IMG = "img/relics/MetalShield.png";
/*     */   
/*     */   public MetalShield() {
/*  24 */     super("MetalShield", ImageMaster.loadImage("img/relics/MetalShield.png"), ImageMaster.loadImage("img/relics/outline/MetalShield.png"), AbstractRelic.RelicTier.STARTER, AbstractRelic.LandingSound.CLINK);
/*  25 */     this.Rclick = false;
/*  26 */     this.RclickStart = false;
/*     */   }
/*     */   private static final String IMG_OTL = "img/relics/outline/MetalShield.png"; private boolean RclickStart; private boolean Rclick;
/*     */   public void onEquip() {
/*  30 */     AbstractDungeon.player.potionSlots += 2;
/*  31 */     AbstractDungeon.player.potions.add(new PotionSlot(AbstractDungeon.player.potionSlots - 2));
/*  32 */     AbstractDungeon.player.potions.add(new PotionSlot(AbstractDungeon.player.potionSlots - 1));
/*  33 */     this.counter = 6;
/*  34 */     HomuraMod.reset = true;
/*     */   }
/*     */   
/*     */   public void onUnequip() {
/*  38 */     System.out.println("MetalShield");
/*  39 */     AbstractPotion p1 = AbstractDungeon.player.potions.remove(AbstractDungeon.player.potionSlots - 1);
/*  40 */     AbstractPotion p2 = AbstractDungeon.player.potions.remove(AbstractDungeon.player.potionSlots - 2);
/*  41 */     AbstractDungeon.player.potionSlots -= 2;
/*  42 */     if (p1 != null) {
/*  43 */       AbstractDungeon.player.obtainPotion(p1);
/*     */     }
/*  45 */     if (p2 != null) {
/*  46 */       AbstractDungeon.player.obtainPotion(p2);
/*     */     }
/*     */   }
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
/*     */   public void atTurnStart() {
/*  63 */     if (this.counter < 12) {
/*  64 */       this.counter++;
/*     */     }
/*     */   }
/*     */   
/*     */   public void onRightClick() {
/*  69 */     AbstractPlayer p = AbstractDungeon.player;
/*  70 */     if (this.counter > 5 && (AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT) {
/*  71 */       flash();
/*  72 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ZeroEnergePower((AbstractCreature)p), 1));
/*  73 */       this.counter -= 6;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/*  80 */     super.update();
/*  81 */     if (this.RclickStart && InputHelper.justReleasedClickRight) {
/*  82 */       if (this.hb.hovered) {
/*  83 */         this.Rclick = true;
/*     */       }
/*  85 */       this.RclickStart = false;
/*     */     } 
/*  87 */     if (this.isObtained && this.hb != null && this.hb.hovered && InputHelper.justClickedRight) {
/*  88 */       this.RclickStart = true;
/*     */     }
/*  90 */     if (this.Rclick) {
/*  91 */       this.Rclick = false;
/*  92 */       onRightClick();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpdatedDescription() {
/*  99 */     return this.DESCRIPTIONS[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public AbstractRelic makeCopy() {
/* 104 */     return (AbstractRelic)new MetalShield();
/*     */   }
/*     */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/relics/MetalShield.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */