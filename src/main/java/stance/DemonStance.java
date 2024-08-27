/*    */ package stance;
/*    */ 
/*    */ import EgoMod.HomuraMod;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.helpers.ImageMaster;
/*    */ import com.megacrit.cardcrawl.stances.AbstractStance;
/*    */ import com.megacrit.cardcrawl.vfx.stance.DivinityParticleEffect;
/*    */ import com.megacrit.cardcrawl.vfx.stance.StanceAuraEffect;
/*    */ 
/*    */ public class DemonStance extends AbstractStance {
/*    */   public static final String STANCE_ID = "DemonStance";
/* 16 */   private static long sfxId = -1L;
/*    */   AbstractPlayer p;
/*    */   
/*    */   public DemonStance() {
/* 20 */     this.p = AbstractDungeon.player;
/* 21 */     this.ID = "DemonStance";
/* 22 */     this.name = "";
/* 23 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 28 */     this.description = "";
/*    */   }
/*    */   
/*    */   public void onEnterStance() {
/* 32 */     if (sfxId != -1L) {
/* 33 */       stopIdleSfx();
/*    */     }
/* 35 */     if (HomuraMod.isSchoolUniform || HomuraMod.isMagicalGirl) {
/* 36 */       AbstractDungeon.player.img = ImageMaster.loadImage("img/char/Demon.png");
/*    */     }
/*    */   }
/*    */   
/*    */   public void onExitStance() {
/* 41 */     stopIdleSfx();
/*    */   }
/*    */ 
/*    */   
/*    */   public void stopIdleSfx() {
/* 46 */     if (sfxId != -1L) {
/* 47 */       sfxId = -1L;
/*    */     }
/* 49 */     if (HomuraMod.isSchoolUniform) {
/* 50 */       AbstractDungeon.player.img = ImageMaster.loadImage("img/char/Homura_SchoolUniform.png");
/*    */     }
/* 52 */     if (HomuraMod.isMagicalGirl) {
/* 53 */       AbstractDungeon.player.img = ImageMaster.loadImage("img/char/Homura_MagicalGirl.png");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateAnimation() {
/* 60 */     if (!Settings.DISABLE_EFFECTS) {
/* 61 */       this.particleTimer -= Gdx.graphics.getDeltaTime();
/* 62 */       if (this.particleTimer < 0.0F) {
/* 63 */         this.particleTimer = 0.2F;
/* 64 */         AbstractDungeon.effectsQueue.add(new DivinityParticleEffect());
/*    */       } 
/*    */     } 
/*    */     
/* 68 */     this.particleTimer2 -= Gdx.graphics.getDeltaTime();
/* 69 */     if (this.particleTimer2 < 0.0F) {
/* 70 */       this.particleTimer2 = MathUtils.random(0.45F, 0.55F);
/* 71 */       AbstractDungeon.effectsQueue.add(new StanceAuraEffect("Divinity"));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/stance/DemonStance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */